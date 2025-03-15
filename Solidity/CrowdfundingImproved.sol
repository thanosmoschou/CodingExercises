pragma solidity >=0.5.9; // Use compiler 0.5.17

contract CrowdfundingImproved {
    // Helping codes
    uint private constant CAMPAIGN_NOT_FOUND = 2 ** 256 - 1;
    uint private constant MINIMUM_ETHER_AMOUNT = 0.02 ether;

    // Contract Attributes
    bool private contractIsActive = true; // Only for simulation of contract destruction. If a contract is destroyed, it cannot receive any ether.

    address payable private contractOwner;

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
    event WithdrawMade(uint balance, string message);
    event OwnerChanged(address old, address newAddr);
    event ContractDestroyed(string message);
    event UserBanned(address bannedAddr);

    constructor() public {
        contractOwner = msg.sender;
        totalCampaignsCtr = 0;
    }

    // Modifiers

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

    modifier enoughMoneyToSupportACampaign(uint _id) {
        require(
            msg.value >= campaigns[_id].pledgeCost,
            "Not enough money to buy pledges"
        );
        _;
    }

    modifier notCanceled(uint _id) {
        bool canceled = campaigns[_id].canceled;
        require(!canceled, "Campaign is canceled");
        _;
    }

    modifier notFulfilled(uint _id) {
        require(!campaigns[_id].fulfilled, "Campaign is fulfilled");
        _;
    }

    modifier cancelConditions(uint _id) {
        bool isContractOwner = (msg.sender == contractOwner);
        bool isCampaignCreator = (msg.sender == campaigns[_id].entrepreneur);
        require(
            isContractOwner || isCampaignCreator,
            "Only contract's owner or campaign's creator can cancel a campaign"
        );

        bool campaignIsNotFulfilled = !campaigns[_id].fulfilled;
        require(campaignIsNotFulfilled, "Campaign is fulfilled");

        bool canceled = campaigns[_id].canceled;
        require(!canceled, "Campaign is canceled.");
        _;
    }

    modifier fulfillConditions(uint _id) {
        bool isOwner = (msg.sender == contractOwner);
        bool isEntrepreneur = (msg.sender == campaigns[_id].entrepreneur);
        require(
            isOwner || isEntrepreneur,
            "Only contract's owner or campaign's creator can fulfill a campaign."
        );

        bool canceled = campaigns[_id].canceled;
        require(!canceled, "Campaign is canceled so it cannot be fulfilled");

        bool campaignIsNotFulfilled = !campaigns[_id].fulfilled;
        require(campaignIsNotFulfilled, "Campaign is fulfilled");

        bool reachedPledges = (campaigns[_id].pledgesCount >=
            campaigns[_id].pledgesNeeded);
        require(
            reachedPledges,
            "This campaign has not reached the required pledges yet."
        );
        _;
    }

    modifier haveFeesToTransfer() {
        require(feesForAllCampaigns > 0, "Not fees to transfer");
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
    the campaign must not be cancelled or fulfilled.
    The msg.value will have the correct value from the front end side
    */
    function supportACampaign(
        uint _id
    )
        public
        payable
        contractNotDestroyed
        notCanceled(_id)
        notFulfilled(_id)
        enoughMoneyToSupportACampaign(_id)
    {
        bool backerIsAddedToArrayOfThisCampaign = checkIfBackerIsAlreadyAddedToTheBackersArrayOfACampaign(
                _id,
                msg.sender
            );

        // Prevent from having duplicates
        if (!backerIsAddedToArrayOfThisCampaign) {
            campaigns[_id].pledgesPerBacker[msg.sender] = 0;
            campaigns[_id].backers.push(msg.sender);
        }

        campaigns[_id].pledgesCount++;
        campaigns[_id].pledgesPerBacker[msg.sender]++;

        emit PledgeMade(_id, msg.sender, campaigns[_id].pledgeCost);
    }

    function cancelACampaign(uint _id) public cancelConditions(_id) {
        campaigns[_id].canceled = true;

        emit CampaignCanceled(_id, msg.sender, campaigns[_id].title);
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

        emit RefundMade(refundAmount, msg.sender);

        msg.sender.transfer(refundAmount);
    }

    function fulfillACampaign(uint _id) public payable fulfillConditions(_id) {
        uint campaignMoneyEarned = campaigns[_id].pledgeCost *
            campaigns[_id].pledgesCount;

        campaigns[_id].fulfilled = true;

        uint twentyPercentFee = (campaignMoneyEarned * 20) / 100;
        uint remainingAmount = (campaignMoneyEarned * 80) / 100;

        feesForAllCampaigns += twentyPercentFee; // The 0.02 fee for campaign creation is already added when the campaign was created

        // Send the 80% of the total amount to the entrepreneur.
        campaigns[_id].entrepreneur.transfer(remainingAmount);

        emit CampaignFulfilled(_id, msg.sender, campaigns[_id].title);
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
            address[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory,
            bool[] memory
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

        address[] memory entrepreneurs = new address[](activeCampaignsCtr);
        uint[] memory ids = new uint[](activeCampaignsCtr); // I cannot find a way to return the title so I return its id instead.
        uint[] memory pledgesCosts = new uint[](activeCampaignsCtr);
        uint[] memory pledgesCounts = new uint[](activeCampaignsCtr);
        uint[] memory pledgesUntilFulfill = new uint[](activeCampaignsCtr);
        uint[] memory currentBackerPledgesForEveryActiveCampaign = new uint[](
            activeCampaignsCtr
        );
        bool[] memory isPrivilegedPerCampaign = new bool[](activeCampaignsCtr); // Each position contains true if msg.sender is either the entrepreneur or the contract's owner, or false otherwise.

        uint index = 0;
        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (!campaigns[i].canceled && !campaigns[i].fulfilled) {
                entrepreneurs[index] = campaigns[i].entrepreneur;
                ids[index] = campaigns[i].campaignId;
                pledgesCosts[index] = campaigns[i].pledgeCost;
                pledgesCounts[index] = campaigns[i].pledgesCount;
                pledgesUntilFulfill[index] = (campaigns[i].pledgesNeeded >
                    campaigns[i].pledgesCount)
                    ? campaigns[i].pledgesNeeded - campaigns[i].pledgesCount
                    : 0;
                currentBackerPledgesForEveryActiveCampaign[index] = campaigns[i]
                    .pledgesPerBacker[msg.sender];
                isPrivilegedPerCampaign[index] =
                    msg.sender == contractOwner ||
                    msg.sender == campaigns[i].entrepreneur;
                index++;
            }
        }

        return (
            entrepreneurs,
            ids,
            pledgesCosts,
            pledgesCounts,
            pledgesUntilFulfill,
            currentBackerPledgesForEveryActiveCampaign,
            isPrivilegedPerCampaign
        );
    }

    function getFulfilledCampaigns()
        public
        view
        returns (
            address[] memory,
            uint[] memory,
            uint[] memory,
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

        address[] memory entrepreneurs = new address[](fulfilledCampaignsCtr);
        uint[] memory ids = new uint[](fulfilledCampaignsCtr); // I cannot find a way to return the title so I return its id instead.
        uint[] memory pledgesCosts = new uint[](fulfilledCampaignsCtr);
        uint[] memory pledgesCounts = new uint[](fulfilledCampaignsCtr);
        uint[] memory pledgesUntilFulfill = new uint[](fulfilledCampaignsCtr);
        uint[] memory currentBackerPledgesForEveryActiveCampaign = new uint[](
            fulfilledCampaignsCtr
        );

        uint index = 0;
        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].fulfilled) {
                entrepreneurs[index] = campaigns[i].entrepreneur;
                ids[index] = campaigns[i].campaignId;
                pledgesCosts[index] = campaigns[i].pledgeCost;
                pledgesCounts[index] = campaigns[i].pledgesCount;
                pledgesUntilFulfill[index] = 0;
                currentBackerPledgesForEveryActiveCampaign[index] = campaigns[i]
                    .pledgesPerBacker[msg.sender];
                index++;
            }
        }

        return (
            entrepreneurs,
            ids,
            pledgesCosts,
            pledgesCounts,
            pledgesUntilFulfill,
            currentBackerPledgesForEveryActiveCampaign
        );
    }

    function getCanceledCampaigns()
        public
        view
        returns (
            address[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory,
            uint[] memory,
            bool
        )
    {
        uint canceledCampaignsCtr = 0; // I get the total amount of canceled campaigns. I will check for each campaign if it is canceled because mappings are not iterative...

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].canceled) {
                canceledCampaignsCtr++;
            }
        }

        address[] memory entrepreneurs = new address[](canceledCampaignsCtr);
        uint[] memory ids = new uint[](canceledCampaignsCtr); // I cannot find a way to return the title so I return its id instead.
        uint[] memory pledgesCosts = new uint[](canceledCampaignsCtr);
        uint[] memory pledgesCounts = new uint[](canceledCampaignsCtr);
        uint[] memory pledgesUntilFulfill = new uint[](canceledCampaignsCtr);
        uint[] memory currentBackerPledgesForEveryActiveCampaign = new uint[](
            canceledCampaignsCtr
        );
        bool deservesRefund = false; // If there is at least 1 canceled campaign that user hasn't got his refund, this variable is true, otherwise it is false.

        uint index = 0;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (campaigns[i].canceled) {
                entrepreneurs[index] = campaigns[i].entrepreneur;
                ids[index] = campaigns[i].campaignId;
                pledgesCosts[index] = campaigns[i].pledgeCost;
                pledgesCounts[index] = campaigns[i].pledgesCount;
                pledgesUntilFulfill[index] = 0;
                currentBackerPledgesForEveryActiveCampaign[index] = campaigns[i]
                    .pledgesPerBacker[msg.sender];
                deservesRefund =
                    deservesRefund ||
                    campaigns[i].pledgesPerBacker[msg.sender] > 0;
                index++;
            }
        }

        return (
            entrepreneurs,
            ids,
            pledgesCosts,
            pledgesCounts,
            pledgesUntilFulfill,
            currentBackerPledgesForEveryActiveCampaign,
            deservesRefund
        );
    }

    function getContractFees() public view returns (uint) {
        return feesForAllCampaigns;
    }

    // This returns the total amount of money that is stored in the contract (not only fees)
    function getContractWholeBalance() public view returns (uint) {
        return address(this).balance;
    }

    function getContractOwner() public view returns (address) {
        return contractOwner;
    }

    function getBannedBackers() public view returns (address[] memory) {
        return bannedBackers;
    }

    function getBackersForACampaign(
        uint _id
    ) public view returns (address[] memory, uint[] memory) {
        address[] memory backersOfThisCampaign = campaigns[_id].backers;
        uint[] memory pledgesPerBacker = new uint[](
            backersOfThisCampaign.length
        );

        for (uint i = 0; i < backersOfThisCampaign.length; i++) {
            pledgesPerBacker[i] = campaigns[_id].pledgesPerBacker[
                backersOfThisCampaign[i]
            ];
        }

        return (backersOfThisCampaign, pledgesPerBacker);
    }

    function checkIfContractIsActive() public view returns (bool) {
        return contractIsActive;
    }

    // Available to contract's owner only.

    function transferAllFeesToContractOwner()
        public
        payable
        onlyOwner
        haveFeesToTransfer
    {
        contractOwner.transfer(feesForAllCampaigns);
        emit WithdrawMade(feesForAllCampaigns, "Withdraw made");
        feesForAllCampaigns = 0;
    }

    function addUserToBanList(
        address _banAddr
    ) public contractNotDestroyed onlyOwner notBanned(_banAddr) {
        bannedBackers.push(_banAddr);

        // Cancel all his live campaigns
        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (
                campaigns[i].entrepreneur == _banAddr &&
                !campaigns[i].fulfilled &&
                !campaigns[i].canceled
            ) campaigns[i].canceled = true;
        }

        emit UserBanned(_banAddr);
    }

    function changeContractOwner(
        address payable _newOwner
    ) public contractNotDestroyed onlyOwner {
        address prev = contractOwner;
        contractOwner = _newOwner;

        emit OwnerChanged(prev, contractOwner);
    }

    // Destroying the contract cancels all active campaigns.
    function destroyContract() public contractNotDestroyed onlyOwner {
        contractIsActive = false;

        for (uint i = 0; i < totalCampaignsCtr; i++) {
            if (!campaigns[i].fulfilled && !campaigns[i].canceled) {
                campaigns[i].canceled = true;
            }
        }

        contractOwner.transfer(feesForAllCampaigns);
        feesForAllCampaigns = 0;

        emit ContractDestroyed("Contract is destroyed.");
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
