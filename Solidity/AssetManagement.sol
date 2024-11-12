pragma solidity ^0.5.3; // Use compiler 0.5.17

contract AssetManagement {
    address public owner;

    constructor() public {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(owner == msg.sender, "You are not the owner...");
        _;
    }

    mapping(address => uint) public balances;

    function withdrawAll() public onlyOwner {
        uint amount = balances[msg.sender];
        require(amount > 0, "Not enough balance.");
        balances[msg.sender] = 0;
        msg.sender.transfer(amount);
    }

    // I get ethers with this function. The amount of them is specified by msg.value
    function deposit() public payable {
        balances[msg.sender] += msg.value;
    }

    function withdraw(uint _amount) public {
        require(balances[msg.sender] >= _amount, "Not enough balance.");
        balances[msg.sender] -= _amount;
        msg.sender.transfer(_amount);
    }

    function getBalance() public view returns (uint) {
        return balances[msg.sender];
    }
}