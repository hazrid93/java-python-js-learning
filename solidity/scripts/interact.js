const path = require('path')
require('dotenv').config({ path: path.resolve(__dirname, '../../.env') })
const { ROP_API_KEY, PRIVATE_KEY } = process.env;

// helloworld.sol in ropsten address
const CONTRACT_ADDRESS = "0xB621093D85FCFa34610574823ec16C84cB1E4Bc8"
const contract = require("../artifacts/contracts/HelloWorld.sol/HelloWorld.json");

// print ABI
//console.log(JSON.stringify(contract.abi));

// interact.js

// Provider
const alchemyProvider = new ethers.providers.AlchemyProvider(network="ropsten", ROP_API_KEY);

// Signer
const signer = new ethers.Wallet(PRIVATE_KEY, alchemyProvider);

// Contract
const helloWorldContract = new ethers.Contract(CONTRACT_ADDRESS, contract.abi, signer);

async function main() {
    const message = await helloWorldContract.message();
    console.log("The message is: " + message);

    console.log("Updating the message...");
    const tx = await helloWorldContract.update("hello");
    // make a call to .wait() on the returned transaction object. 
    // This ensures that our script waits for the transaction to be mined on the blockchain before proceeding onwards
    await tx.wait();

    const newMessage = await helloWorldContract.message();
    console.log("The new message is: " + newMessage); 
}
main().then(() => {
    process.exit(0)
}).catch((error)=> {
    console.error(error)
    process.exit(1)
});