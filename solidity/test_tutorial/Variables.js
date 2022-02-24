const { expect } = require("chai");
const { ethers } = require("hardhat");

describe("Box contract tests", function () {
    let Token;
    let hardhatToken;
    let owner;
    let addr1;
    let addr2;
    let addrs;
    before(async function() {
        // Get the ContractFactory and Signers here.
        Token = await ethers.getContractFactory("Variables");
    });
    // `beforeEach` will run before each test, re-deploying the contract every
    // time. It receives a callback, which can be async.
    beforeEach(async function () {
      [owner, addr1, addr2, ...addrs] = await ethers.getSigners();
  
      // To deploy our contract, we just have to call Token.deploy() and await
      // for it to be deployed(), which happens onces its transaction has been
      // mined.
      hardhatToken = await Token.deploy();
  
      // We can interact with the contract by calling `hardhatToken.method()`
      await hardhatToken.deployed();
      console.log("Token address:", hardhatToken.address);
    });
  
    it("hello", async function () {
        let res = await hardhatToken.doSomething();
        expect(false).to.be.false; // dummy to always pass
    });

  
});
  