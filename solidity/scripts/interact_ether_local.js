//NOTE: this one is using hardhat/ethers library to connect to localhost
//Note: this example is to deploy and interact
async function main() {
    // This is just a convenience check
    if (network.name === "hardhat") {
      console.warn(
        "You are trying to deploy a contract to the Hardhat Network, which" +
          "gets automatically created and destroyed every time. Use the Hardhat" +
          " option '--network localhost'"
      );
    }
  
    // ethers is available in the global scope
    const [deployer] = await ethers.getSigners();
    console.log(
      "Deploying the contracts with the account:",
      await deployer.getAddress()
    );
  
    console.log("Account balance:", (await deployer.getBalance()).toString());
      
    // deploy and interact
    const Token = await ethers.getContractFactory("Box");
    const token = await Token.deploy();
    await token.deployed();
  
    console.log("Token address:", token.address);
  }


/* Note: this example is to connect to deployed contract in local,
instead of deploying first.
async function main() {
  // Set up an ethers contract, representing our deployed Box instance
  // address=deployed contract address
  const address = '0x5FbDB2315678afecb367f032d93F642f64180aa3';
  const Box = await ethers.getContractFactory('Box');
  const box = await Box.attach(address);
  const value = await box.retrieve();
  console.log('Box value is', value.toString());
}

*/
main().then(() => {
    process.exit(0)
}).catch((error)=> {
    console.error(error)
    process.exit(1)
});