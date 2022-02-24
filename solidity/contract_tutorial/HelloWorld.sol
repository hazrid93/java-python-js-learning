pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";

contract HelloWorld {
    string public greet = "hello world!";
    
    constructor(){
        console.log(greet);
    }
}