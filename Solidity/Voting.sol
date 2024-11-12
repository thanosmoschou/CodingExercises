pragma solidity ^0.5.3; // Use compiler 0.5.17

contract Voting {
    /*struct VoteOption {
        string voteName;
        uint totalVotes;
    }*/

    mapping(string => uint) public voteOptions;
    string[] public voteNames;

    mapping(address => bool) public voters;

    function addOption(string memory _optionName) public {
        voteOptions[_optionName] = 0;
        voteNames.push(_optionName);
    }

    function vote(string memory _voteName) public {
        require(voteOptions[_voteName] != 0, "Invalid Option");

        voteOptions[_voteName]++;
        voters[msg.sender] = true;
    }

    function getVotes(string memory _voteName) public view returns (uint) {
        return voteOptions[_voteName];
    }

    function getWinningOption() public view returns (string memory, uint) {
        uint maxValue = voteOptions[voteNames[0]];
        string memory maxVoteName = voteNames[0];

        for (uint i = 1; i < voteNames.length; i++) {
            if (voteOptions[voteNames[i]] > maxValue) {
                maxValue = voteOptions[voteNames[i]];
                maxVoteName = voteNames[i];
            }
        }

        return (maxVoteName, maxValue);
    }
}