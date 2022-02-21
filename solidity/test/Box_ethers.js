const { expect } = require("chai");
const { ethers } = require("hardhat");

// note that for localhost testing its easier to just use this setup with ethers.js
// instead of web3
//these are written for ethers.js + waffle = https://hardhat.org/guides/waffle-testing.html
describe("Box contract tests", function () {
    // Mocha has four functions that let you hook into the the test runner's
    // lifecycle. These are: `before`, `beforeEach`, `after`, `afterEach`.
  
    // They're very useful to setup the environment for tests, and to clean it
    // up after they run.
  
    // A common pattern is to declare some variables, and assign them in the
    // `before` and `beforeEach` callbacks.
  
    let Token;
    let hardhatToken;
    let owner;
    let addr1;
    let addr2;
    let addrs;
    before(async function() {
        // Get the ContractFactory and Signers here.
        Token = await ethers.getContractFactory("Box");
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
  
    it("set value from owner", async function () {
        await hardhatToken.store(123);
        expect((await hardhatToken.retrieve()).toString()).to.equal('123');
    });

    it("set value from other account", async function () {
        await hardhatToken.connect(addr1).store(100);
        expect((await hardhatToken.retrieve()).toString()).to.equal('123');
    });
  
});
  