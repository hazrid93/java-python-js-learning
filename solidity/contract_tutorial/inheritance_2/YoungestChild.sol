// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

import "hardhat/console.sol";
import "./ChildA.sol";
import "./ChildB.sol";

// inheritance with 'is' will go from <most_highest_parent> -> <most_derived_child>
// this also signifies the order of importance from Less_important -> Most_important
// Note this order of importance is not important in override, is it derived by EVM based on
// execution criteria, for example if ChildA and ChildB is defined as parent in YoungestChild
// as 'is ChildA, ChildB' the ChildB method will take precedence when called using super.<methodname>.
contract YoungestChild is ChildA,ChildB {

    constructor(){

    }

    function printName() public pure override(ChildA,ChildB) returns (string memory){
        string memory name = "YoungestChild"; //unused since calling super
        return (super.printName()); //this will call ChildB printName() which will call Parent printName()
    }

}