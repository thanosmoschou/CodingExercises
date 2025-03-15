pragma solidity >=0.5.9; // Use compiler 0.5.17

contract Crowdfunding {
    // Helping codes
    uint private constant CAMPAIGN_NOT_FOUND = 2 ** 256 - 1;
    uint private constant MINIMUM_ETHER_AMOUNT = 0.02 ether;

    // Contract Attributes
    bool private contractIsActive = true; // Only for simulation of contract destruction. If a contract is destroyed, it cannot receive any ether.

    address payable private contractOwner;

    // These fees will be transfered to contract's owner.
    // Only fulfilled campaigns are included (20% fee per fulfilled campaign + 0.02 ether for each campaign creation)
    uint private fulfilledCampaignsFees;

    // Fees for all campaigns, not only the fulfilled ones.
    // 20% per fulfilled + 0.02 Ether for each campaign ever created
    uint private feesForAllCampaigns;

    // Struct that contains the details of each campaign.
    struct Campaign {
        uint campaignId;
        address payable entrepreneur;
        string title;
        uint pledgeCost;
        uint pledgesNeeded;
        uint pledgesCount;
        bool fulfilled;
        bool canceled;
        mapping(address => uint) pledgesPerBacker;
        address[] backers;
    }

    uint private totalCampaignsCtr; // I increase it everytime a new campaign is added. This helps me to assign an id to each campaign and traverse the campaigns mapping with for loop.
    mapping(uint => Campaign) private campaigns; // All campaigns

    address[] private bannedBackers;

    // Contract Events
    event CampaignCreated(uint campaignId, address entrepreneur, string title);
    event PledgeMade(uint campaignId, address backer, uint amount);
    event CampaignCanceled(uint campaignId, address whoCanceled, string title);
    event RefundMade(uint amount, address backer);
    event CampaignFulfilled(
        uint campaignId,
        address whoFulfilled,
        string title
    );

    constructor() public {
        contractOwner = msg.sender;
        totalCampaignsCtr = 0;
    }

    // Modifiers

    /*
    Disclaimer:
    In some modifiers I do the same checks. For example I check if campaign exists in plenty of my modifiers. 
    This happens because I cannot create a single modifier that does this job and then call it from
    inside another modifier.
    */

    modifier contractNotDestroyed() {
        require(contractIsActive, "Contract is destroyed.");
        _;
    }

    modifier onlyOwner() {
        require(msg.sender == contractOwner, "You are not the owner");
        _;
    }

    modifier notOwner() {
        require(msg.sender != contractOwner, "You are the owner");
        _;
    }

    modifier onlyEntrepreneur(uint _campaignId) {
        require(
            msg.sender == campaigns[_campaignId].entrepreneur,
            "You are not the entrepreneur"
        );
        _;
    }

    // Scan the bannedBackers array to see if _addr is included. User must not be banned.
    modifier notBanned(address _addr) {
        bool banned = false;

        for (uint i = 0; i < bannedBackers.length; i++) {
            if (bannedBackers[i] == _addr) {
                banned = true;
                break;
            }
        }

        require(!banned, "User is banned");
        _;
    }

    // This modifier checks if a campaign does not exist. It helps to avoid having campaigns with the same name.
    modifier campaignNotExists(string memory _name) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId == CAMPAIGN_NOT_FOUND, "Campaign exists.");
        _;
    }

    modifier enoughEtherForCampaignCreation() {
        require(
            msg.value >= MINIMUM_ETHER_AMOUNT,
            "Not enough ether for campaign creation."
        );
        _;
    }

    // This modifier helps me to see if the campaign name is valid and the ether amount is enough to buy pledges.
    modifier enoughMoneyToSupportACampaign(
        string memory _name,
        uint _pledgesAmount
    ) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId != CAMPAIGN_NOT_FOUND, "Invalid campaign name.");
        require(
            msg.value >= campaigns[campaignId].pledgeCost * _pledgesAmount,
            "Not enough money to buy pledges"
        );
        _;
    }

    // Check if the campaign exists and then check if it is not canceled.
    modifier notCanceled(string memory _name) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId != CAMPAIGN_NOT_FOUND, "Invalid campaign name.");

        bool canceled = campaigns[campaignId].canceled;
        require(!canceled, "Campaign is canceled");
        _;
    }

    // Check if the campaign exists and then check if it is already fulfilled.
    modifier notFulfilled(string memory _name) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId != CAMPAIGN_NOT_FOUND, "Invalid campaign name.");
        require(!campaigns[campaignId].fulfilled, "Campaign is fulfilled");
        _;
    }

    /* 
    This modifier gets the name of a campaign I want to cancel and see if the needed conditions are applied, 
    in order to cancel it. Only contract's owner or entrepreneur can cancel the campaign. Also
    if you want to cancel it, it must not be already canceled or fulfilled.

    For readability purposes, I do not specify all the conditions in a single require statement. If a require statement
    passes successfully, then the other require statements are checked. Also I want to provide some good error messages
    in case of not passing the require statements, in order to see what was wrong. If I check all my conditions
    in a single require statement, I will not be able to know exactly what condition failed, because the error message
    will contain all the possible errors.

    I could achieve the same functionality using existing modifiers, 
    but the requirement specifies that only the contract owner OR the entrepreneur can cancel. 
    Therefore, I cannot combine onlyOwner and onlyEntrepreneur modifiers directly in the function 
    signature with an OR condition. Thus, a new modifier is created to handle this case.
    */
    modifier cancelConditions(string memory _name) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId != CAMPAIGN_NOT_FOUND, "Invalid campaign name.");

        bool isContractOwner = (msg.sender == contractOwner);
        bool isCampaignCreator = (msg.sender ==
            campaigns[campaignId].entrepreneur);
        require(
            isContractOwner || isCampaignCreator,
            "Only contract's owner or campaign's creator can cancel a campaign"
        );

        bool campaignIsNotFulfilled = !campaigns[campaignId].fulfilled;
        require(campaignIsNotFulfilled, "Campaign is fulfilled");

        bool canceled = campaigns[campaignId].canceled;
        require(!canceled, "Campaign is canceled.");
        _;
    }

    /*
    This modifier checks if the campaign exists and then it checks if the fulfilling conditions are applied.
    In order to fulfill a campaign, you must be either the entrepreneur or the contract's owner, and then
    the campaign must reach the required pledges.

    I use the same logic with the modifier above, just to make it more readable and provide good error messages
    to know exactly what went wrong.
    */
    modifier fulfillConditions(string memory _name) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId != CAMPAIGN_NOT_FOUND, "Invalid campaign name.");

        bool isOwner = (msg.sender == contractOwner);
        bool isEntrepreneur = (msg.sender ==
            campaigns[campaignId].entrepreneur);
        require(
            isOwner || isEntrepreneur,
            "Only contract's owner or campaign's creator can fulfill a campaign."
        );

        bool canceled = campaigns[campaignId].canceled;
        require(!canceled, "Campaign is canceled so it cannot be fulfilled");

        bool campaignIsNotFulfilled = !campaigns[campaignId].fulfilled;
        require(campaignIsNotFulfilled, "Campaign is fulfilled");

        bool reachedPledges = (campaigns[campaignId].pledgesCount >=
            campaigns[campaignId].pledgesNeeded);
        require(
            reachedPledges,
            "This campaign has not reached the required pledges yet."
        );
        _;
    }

    modifier haveFeesToTransfer() {
        require(fulfilledCampaignsFees > 0, "Not fees to transfer");
        _;
    }

    // Contract's Functionality

    // Basic Functionallity

    /* 
    To create a new campaign, the contract must not be destroyed, the campaign must not be created already, 
    you cannot be the owner, you cannot be banned,
    and lastly you need to have the required fee.
    */
    function addNewCampaign(
        string memory _name,
        uint _costPerPledge,
        uint _totalPledgesNeeded
    )
        public
        payable
        contractNotDestroyed
        notOwner
        notBanned(msg.sender)
        campaignNotExists(_name)
        enoughEtherForCampaignCreation
    {
        Campaign storage newCampaign = campaigns[totalCampaignsCtr]; // A new campaign is created automatically and added to my mapping.

        newCampaign.campaignId = totalCampaignsCtr;
        newCampaign.entrepreneur = msg.sender;
        newCampaign.title = _name;
        newCampaign.pledgeCost = _costPerPledge;
        newCampaign.pledgesNeeded = _totalPledgesNeeded;
        newCampaign.pledgesCount = 0;
        newCampaign.fulfilled = false;
        newCampaign.canceled = false;
        // backers array is created automatically inside this campaign object

        totalCampaignsCtr++;

        // I will add the creation fee to the fulfilledCampaignsFees also, but only if the campaign will be fulfilled.
        feesForAllCampaigns += MINIMUM_ETHER_AMOUNT;

        // If user entered more ether than needed, contract returns the remaining amount.
        if (msg.value > MINIMUM_ETHER_AMOUNT) {
            msg.sender.transfer(msg.value - MINIMUM_ETHER_AMOUNT);
        }

        emit CampaignCreated(
            newCampaign.campaignId,
            newCampaign.entrepreneur,
            newCampaign.title
        );
    }

    /*
    In order to support a campaign, the contract must be active, 
    the campaign must not be cancelled or fulfilled, and lastly
    you need to have the required ether amount depending the pledges
    you want to buy.
    */
    function supportACampaign(
        string memory _name,
        uint _pledgesAmount
    )
        public
        payable
        contractNotDestroyed
        notCanceled(_name)
        notFulfilled(_name)
        enoughMoneyToSupportACampaign(_name, _pledgesAmount)
    {
        uint campaignId = getCampaignsId(_name); // I skip the require here because if there is an error, I will be notified by the modifiers and nothing will be executed at this function.

        bool backerIsAddedToArrayOfThisCampaign = checkIfBackerIsAlreadyAddedToTheBackersArrayOfACampaign(
                campaignId,
                msg.sender
            );

        // Prevent from having duplicates
        if (!backerIsAddedToArrayOfThisCampaign) {
            campaigns[campaignId].pledgesPerBacker[msg.sender] = 0;
            campaigns[campaignId].backers.push(msg.sender);
        }

        campaigns[campaignId].pledgesCount += _pledgesAmount;
        campaigns[campaignId].pledgesPerBacker[msg.sender] += _pledgesAmount;

        // If user entered more ether than needed, contract returns the remaining amount.
        if (msg.value > _pledgesAmount * campaigns[campaignId].pledgeCost) {
            msg.sender.transfer(
                msg.value - (_pledgesAmount * campaigns[campaignId].pledgeCost)
            );
        }

        emit PledgeMade(
            campaignId,
            msg.sender,
            _pledgesAmount * campaigns[campaignId].pledgeCost
        );
    }

    function cancelACampaign(
        string memory _name
    ) public cancelConditions(_name) {
        uint campaignId = getCampaignsId(_name);

        campaigns[campaignId].canceled = true;

        emit CampaignCanceled(
            campaignId,
            msg.sender,
            campaigns[campaignId].title
        );
    }

    // User gets his refund for canceled campaigns. He can get his refund from a canceled campaign only once.
    function refund() public payable {
        uint refundAmount = 0;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (
                campaigns[i].canceled &&
                campaigns[i].pledgesPerBacker[msg.sender] > 0
            ) {
                refundAmount +=
                    campaigns[i].pledgesPerBacker[msg.sender] *
                    campaigns[i].pledgeCost;
                campaigns[i].pledgesCount -= campaigns[i].pledgesPerBacker[
                    msg.sender
                ]; // Useless here. Only for tracking purposes.
                campaigns[i].pledgesPerBacker[msg.sender] = 0; // Backer got his refund from this campaign.
            }
        }

        require(refundAmount > 0, "No refunds");

        msg.sender.transfer(refundAmount);

        emit RefundMade(refundAmount, msg.sender);
    }

    // Keep in mind that I take fees from a campaign only when it is fulfilled
    function fulfillACampaign(
        string memory _name
    ) public payable fulfillConditions(_name) {
        uint campaignId = getCampaignsId(_name);

        uint campaignMoneyEarned = campaigns[campaignId].pledgeCost *
            campaigns[campaignId].pledgesCount;

        campaigns[campaignId].fulfilled = true;

        uint twentyPercentFee = (campaignMoneyEarned * 20) / 100;
        uint remainingAmount = (campaignMoneyEarned * 80) / 100;

        // Get 20% fee from this campaign
        fulfilledCampaignsFees += twentyPercentFee;
        fulfilledCampaignsFees += MINIMUM_ETHER_AMOUNT; // Get 0.002 Ether as a fee for creating a campaign. The fee is also added to the feesFromAllCampaigns at the creation of the campaign.

        feesForAllCampaigns += twentyPercentFee; // The 0.02 fee for campaign creation is already added when the campaign was created

        // Send the 80% of the total amount to the entrepreneur.
        campaigns[campaignId].entrepreneur.transfer(remainingAmount);

        emit CampaignFulfilled(
            campaignId,
            msg.sender,
            campaigns[campaignId].title
        );
    }

    // Contract's management functions

    // Available to all.

    /*
    Disclaimer: 

    I know that I am using two for loops, and the first one might seem unnecessary. 
    However, I use it to count how many campaigns I have, for example, completed or canceled, 
    so that I can create statically sized arrays. 

    This is why you see that I am practically checking the same things twice. 
    The first check is done to count the campaigns, while the second one adds elements to the arrays. 

    Then, I use the second for loop, which performs the actual work. 

    I could have used just one for loop with the push method, but that would have required the arrays to be of type storage, 
    which would have increased the gas cost due to space usage.

    The same happens to the most of my getter functions.

    Also keep in mind that I do not return the titles of my campaigns because it needs a newer ABI encoder.
    */

    function getActiveCampaigns()
        public
        view
        returns (
            uint[] memory,
            address[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory
        )
    {
        uint activeCampaignsCtr = 0;

        // See which campaigns are actually active, then create fixed size arrays and fill them
        // with all campaign details.
        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (!campaigns[i].canceled && !campaigns[i].fulfilled) {
                activeCampaignsCtr++;
            }
        }

        uint[] memory ids = new uint[](activeCampaignsCtr);
        address[] memory entrepreneurs = new address[](activeCampaignsCtr);
        uint[] memory pledgesCosts = new uint[](activeCampaignsCtr);
        uint[] memory pledgesNeeded = new uint[](activeCampaignsCtr);
        uint[] memory pledgesCounts = new uint[](activeCampaignsCtr);

        uint index = 0;
        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (!campaigns[i].canceled && !campaigns[i].fulfilled) {
                ids[index] = campaigns[i].campaignId;
                entrepreneurs[index] = campaigns[i].entrepreneur;
                pledgesCosts[index] = campaigns[i].pledgeCost;
                pledgesNeeded[index] = campaigns[i].pledgesNeeded;
                pledgesCounts[index] = campaigns[i].pledgesCount;
                index++;
            }
        }

        return (ids, entrepreneurs, pledgesCosts, pledgesNeeded, pledgesCounts);
    }

    function getFulfilledCampaigns()
        public
        view
        returns (
            uint[] memory,
            address[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory
        )
    {
        uint fulfilledCampaignsCtr = 0;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].fulfilled) {
                fulfilledCampaignsCtr++;
            }
        }

        uint[] memory ids = new uint[](fulfilledCampaignsCtr);
        address[] memory entrepreneurs = new address[](fulfilledCampaignsCtr);
        uint[] memory pledgesCosts = new uint[](fulfilledCampaignsCtr);
        uint[] memory pledgesNeeded = new uint[](fulfilledCampaignsCtr);
        uint[] memory pledgesCounts = new uint[](fulfilledCampaignsCtr);

        uint index = 0;
        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].fulfilled) {
                ids[index] = campaigns[i].campaignId;
                entrepreneurs[index] = campaigns[i].entrepreneur;
                pledgesCosts[index] = campaigns[i].pledgeCost;
                pledgesNeeded[index] = campaigns[i].pledgesNeeded;
                pledgesCounts[index] = campaigns[i].pledgesCount;

                index++;
            }
        }

        return (ids, entrepreneurs, pledgesCosts, pledgesNeeded, pledgesCounts);
    }

    function getContractFees() public view returns (uint) {
        return feesForAllCampaigns;
    }

    function getCanceledCampaigns()
        public
        view
        returns (uint[] memory, address[] memory, uint[] memory, uint[] memory)
    {
        uint canceledCampaignsCtr = 0; // I get the total amount of canceled campaigns. I will check for each campaign if it is canceled because mappings are not iterative...

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].canceled) {
                canceledCampaignsCtr++;
            }
        }

        uint[] memory ids = new uint[](canceledCampaignsCtr);
        address[] memory entrepreneurs = new address[](canceledCampaignsCtr);
        uint[] memory pledgesCosts = new uint[](canceledCampaignsCtr);
        uint[] memory pledgesNeeded = new uint[](canceledCampaignsCtr);

        uint index = 0;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].canceled) {
                ids[index] = campaigns[i].campaignId;
                entrepreneurs[index] = campaigns[i].entrepreneur;
                pledgesCosts[index] = campaigns[i].pledgeCost;
                pledgesNeeded[index] = campaigns[i].pledgesNeeded;

                index++;
            }
        }

        return (ids, entrepreneurs, pledgesCosts, pledgesNeeded);
    }

    function getBannedBackers() public view returns (address[] memory) {
        return bannedBackers;
    }

    function getBackersForACampaign(
        string memory _name
    ) public view returns (address[] memory, uint[] memory) {
        uint campaignId = getCampaignsId(_name);
        require(campaignId != CAMPAIGN_NOT_FOUND, "Invalid campaign name.");

        address[] memory backersOfThisCampaign = campaigns[campaignId].backers;
        uint[] memory pledgesPerBacker = new uint[](
            backersOfThisCampaign.length
        );

        for (uint i = 0; i < backersOfThisCampaign.length; i++) {
            pledgesPerBacker[i] = campaigns[campaignId].pledgesPerBacker[
                backersOfThisCampaign[i]
            ];
        }

        return (backersOfThisCampaign, pledgesPerBacker);
    }

    // Available to contract's owner only.

    function transferAllFeesToContractOwner()
        public
        payable
        onlyOwner
        haveFeesToTransfer
    {
        contractOwner.transfer(fulfilledCampaignsFees);
        feesForAllCampaigns -= fulfilledCampaignsFees; // Subtract the fees from fulfilled campaigns because they will be transfered to the contract's owner.
        fulfilledCampaignsFees = 0;
    }

    function addUserToBanList(
        address _banAddr
    ) public contractNotDestroyed onlyOwner notBanned(_banAddr) {
        bannedBackers.push(_banAddr);
    }

    function changeContractOwner(
        address payable _newOwner
    ) public contractNotDestroyed onlyOwner {
        contractOwner = _newOwner;
    }

    // Destroying the contract cancels all active campaigns.
    function destroyContract() public contractNotDestroyed onlyOwner {
        contractIsActive = false;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (!campaigns[i].fulfilled && !campaigns[i].canceled) {
                campaigns[i].canceled = true;
            }
        }
    }

    // Additional helping functions

    // This function gets the name of a campaign and returns its id, or CAMPAIGN_NOT_FOUND if the campaign does not exist.
    function getCampaignsId(string memory _name) internal view returns (uint) {
        bool stringsAreEqual = false;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            stringsAreEqual = compareStrings(_name, campaigns[i].title);
            if (stringsAreEqual) {
                return i;
            }
        }

        return CAMPAIGN_NOT_FOUND; // 2**256 - 1
    }

    // Get the backers array of a certain campaign and see if the addr is already added. This helps me to avoid
    // having duplicate addresses inside the array.
    function checkIfBackerIsAlreadyAddedToTheBackersArrayOfACampaign(
        uint _campaignId,
        address addr
    ) internal view returns (bool) {
        for (uint i = 0; i < campaigns[_campaignId].backers.length; i++) {
            if (campaigns[_campaignId].backers[i] == addr) {
                return true;
            }
        }

        return false;
    }

    function compareStrings(
        string memory s1,
        string memory s2
    ) private pure returns (bool) {
        return
            keccak256(abi.encodePacked(s1)) == keccak256(abi.encodePacked(s2));
    }
}
