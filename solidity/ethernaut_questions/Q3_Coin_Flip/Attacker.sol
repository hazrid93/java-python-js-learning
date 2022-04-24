// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";
import "./CoinFlip.sol";

contract Attacker {
    CoinFlip public coinFlip; 
    uint256 constant FACTOR = 57896044618658097711785492504343953926634992332820282019728792003956564819968;

    constructor(address _coinFlipAddr){
        coinFlip = CoinFlip(_coinFlipAddr);
    }

    function attack() external view {

    }

    function getData() public returns (bool){
        return this.coinFlip.print();
    }

}