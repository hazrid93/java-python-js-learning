pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";

/*
There are 3 types of variables in Solidity
[Variables]
local
-declared inside a function
-not stored on the blockchain
state
-declared outside a function
-stored on the blockchain
global (provides information about the blockchain)
*/
contract Variables {
    // these are state
    string public text = "Hello";
    uint public num = 123;
    constructor(){
    }

    function doSomething() public {
        // local var
        uint i = 456;

        //here are some global
        uint timestamp = block.timestamp; // current block timestamp
        address sender = msg.sender; // address of caller from msg object

        console.log(timestamp);
        console.log(sender);
    }
}