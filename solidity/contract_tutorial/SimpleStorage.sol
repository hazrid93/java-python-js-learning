pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";

//To write or update a state variable you need to send a transaction.

//On the other hand, you can read state variables, for free, without any transaction fee.
contract SimpleStorage {
    uint public num;
    
    constructor(){
    }

    //this is a writing function *require transaction
    function set(uint _num) public {
        num = _num;
    }

    //this is a reading function, cost nothing * requires `view` and `return` keyword
    function get() public view returns (uint){
        return num;
    }
}