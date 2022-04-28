// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

import "hardhat/console.sol";
/**
            [parent]
            /      \
        [childA]    [childB]
            \          /
           [YoungestChild]
*/
contract Parent {


    constructor(){

    }

    function printName() public pure virtual returns (string memory){
        string memory name = "Parent";
        return (name);
    }

}