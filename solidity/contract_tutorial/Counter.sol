pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";

contract Counter {
    uint public count;
    constructor(){
    }
    //get current count var
    function get() public view returns (uint) {
        return count;
    }
    //increment count
    function inc() public {
        count++;
        console.log(count);
    }
    //decrement count
    function dec() public {
        count--;
    }
 
}