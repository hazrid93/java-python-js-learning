pragma solidity ^0.8.0;

// We import this library to be able to use console.log
import "hardhat/console.sol";

// Import Auth from the access-control subdirectory
// import "./Auth.sol";
import "@openzeppelin/contracts/access/Ownable.sol";

contract Box is Ownable {
    uint256 private _value;
  //  Auth private _auth;
    event ValueChanged(uint256 value);
    constructor(){
       // _auth = new Auth(msg.sender);
    }
    function store(uint256 value) public onlyOwner {
      //  require(_auth.isAdministrator(msg.sender), "Unauthorized");
        console.log("value: %s" , value);
        _value = value;
        emit ValueChanged(value);
    }

    function retrieve() public view returns (uint256) {
        return _value;
    }

}