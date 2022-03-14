// SPDX-License-Identifier: MIT

pragma solidity ^0.8.4;

contract Vehicle {
    string public brand;
    uint8 public wheels;

    event Received(address, uint);

    constructor(string memory _brand, uint8 _wheels){
        brand = _brand;
        wheels = _wheels;
    }

    function getbalance() public virtual view returns(uint){
        return address(this).balance;

    }

    receive() external payable {
        emit Received(msg.sender, msg.value);
    }

}
