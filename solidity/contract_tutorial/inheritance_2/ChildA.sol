// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

import "hardhat/console.sol";
import "./Parent.sol";

contract ChildA is Parent{

    constructor(){

    }

    function printName() public pure override virtual returns (string memory){
        string memory name = "ChildA";
        return (name);
    }

}