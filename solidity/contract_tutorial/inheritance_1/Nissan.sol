// SPDX-License-Identifier: MIT

pragma solidity ^0.8.4;

import "./Vehicle.sol";

contract Nissan is Vehicle {
    address owner;

    modifier onlyOwner {
        require(msg.sender == owner, "only owner may call this function");
        _;
    }
    // passing constructor value during creation
    constructor (string memory _brand, uint8 _wheels) Vehicle(_brand, _wheels){
        owner = msg.sender;
    }

    function getbalance() public override view returns(uint){
        return address(this).balance;

    }

    function printName() public onlyOwner view returns(string memory){
        return Vehicle.brand;
    }
}