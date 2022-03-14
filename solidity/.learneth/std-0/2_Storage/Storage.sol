pragma solidity ^0.5.0;

/**
 * @title Storage
 * @dev This contract stores hard coded value in the variable and returns its value on user demand
 */

contract Storage {

    uint256 n;

    /**
     * @dev Create a method "set" that stores the value 5 in variable 'n' 
     */

    /**
     * @dev Returns value of 'n'
     */
    function get() public view returns (uint256){
        return n;
    }
}