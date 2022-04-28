// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

import "hardhat/console.sol";
import "./Parent.sol";

contract ChildB is Parent{
    constructor(){

    }

    // Note: function can have both virtual and override
    function printName() public pure override virtual returns (string memory){
        string memory name = "ChildB"; //unused since calling super
        //return (name);
       // - call parent function
      return super.printName(); 
    }

}