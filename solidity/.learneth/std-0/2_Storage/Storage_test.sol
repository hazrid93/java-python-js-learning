pragma solidity >=0.5.0 <0.6.0;
import "remix_tests.sol";
import "./Storage.sol";

contract StorageTest {

  Storage storageContract;
  function beforeEach() public {
    storageContract = new Storage();
  }

  function checkStore () public {
    storageContract.set();
    Assert.equal(storageContract.get(), uint(5), "Method 'store' should set a storage value to '5'.");
  }

}
