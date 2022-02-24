pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";

//Immutable variables are like constants. Values of immutable variables can be set inside the constructor but cannot be modified afterwards.
contract Immutable {
    address public immutable MY_ADDRESS;
    uint public immutable MY_UINT;
    
    constructor(uint _myUint){
        MY_ADDRESS = msg.sender;
        MY_UINT = _myUint;
    }
}