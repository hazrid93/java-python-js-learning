# Calling other contract
- 1) using dependency injection, defining the contract interface that 
refers to the remote contract that we want
to interact with, then pass the address in our Caller contract before calling the method
we defined in the interface.

[scenario 1): User wallet -> Caller contract -> Callee contract]
- 2) based on scenario 1 using call , this kinda work like dependency injection, the state vars,
 refers to the Callee contract, the msg.sender and msg.value refer to the Caller contract.
- 3) based on scenario 1 using delegatecall, this one for example is
 used in library in solidity, calling external contract
with this means the state vars refers to Caller contract while msg.sender and msg.value
 refer external user that called Caller

 ## Delegate call with similar state variable
 - if Caller has state variable 'x' and Callee also has same variable, then if
 Callee return 'x' need to make sure the state variable order(slot) is same as the Caller, because even though the state variable value refers to Caller the slot number refers to Callee since it has same state var.
 Note: that slot refer to order of defining state variable in contract (refer article at 'delegate call info'), e.x: 
 ```
 contract Caller {
     string s// slot 0
     int A;// slot 1
     int B;// slot 2
 }

 contract Callee {
     int A;//slot 0, if Callee returns A in its function it can make Caller get the slot 0 item in its storage which is 'string s'. Because slot number refer Callee.
 }
 ```

# More note at 
- [link](https://www.zupzup.org/smart-contract-interaction/)
- [more not for calling other contract](https://medium.com/@blockchain101/calling-the-function-of-another-contract-in-solidity-f9edfa921f4c)
- [stackoverflow](https://ethereum.stackexchange.com/questions/3667/difference-between-call-callcode-and-delegatecall)
- [abi.encode vs byte4.keccak256](https://ethereum.stackexchange.com/questions/91826/why-are-there-two-methods-encoding-arguments-abi-encode-and-abi-encodepacked)
- [delegate call info](https://medium.com/coinmonks/delegatecall-calling-another-contract-function-in-solidity-b579f804178c)
