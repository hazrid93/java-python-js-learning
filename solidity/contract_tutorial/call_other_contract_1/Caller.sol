// SPDX-License-Identifier: MIT

pragma solidity ^0.8.4;

contract Caller {
    function someAction(address addr) public returns(uint) {
        Callee c = Callee(addr);
        return c.getValue(100);
    }
    
    function storeAction(address addr) public returns(uint) {
        // Note: Callee(addr) is basically the same as <addr>.call (dependency injection way)
        Callee c = Callee(addr);
        c.storeValue(100);
        return c.getValues();
    }
    
    function someUnsafeAction(address addr) public {
        uint8 _n = 100;
        // calling other contract without no ABI way
        (bool success,) = addr.call(abi.encodeWithSignature("storeValue(uint256)", 100));
        require(success);
    }
}

// ABI for dependency injection way
interface Callee {
    function getValue(uint initialValue) external pure returns(uint);
    function storeValue(uint value) external;
    function getValues() external view returns(uint);
}