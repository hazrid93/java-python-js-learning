// NOTE: this one using web3.js with alchemy provider, to connect to test network,
// this is not using alchemy/web3 library
const path = require('path')
require('dotenv').config({ path: path.resolve(__dirname, '../.env') })
const alchemyKey = process.env.ROP_API_URL;
const publicKey = process.env.PUBLIC_KEY;
const privateKey = process.env.PRIVATE_KEY;
const { createAlchemyWeb3 } = require("@alch/alchemy-web3");
const web3 = createAlchemyWeb3(alchemyKey);

// helloworld.sol in ropsten address
const contractAddress = "0xB621093D85FCFa34610574823ec16C84cB1E4Bc8"
const contract = require("../artifacts/contracts/HelloWorld.sol/HelloWorld.json");



// print ABI
//console.log(JSON.stringify(contract.abi));
const helloWorldContract = new web3.eth.Contract(
    contract.abi,
    contractAddress
);

// guide here : https://medium.com/finnovate-io/how-do-i-sign-transactions-with-web3-f90a853904a2
async function main() {
    // import account from private key
    const account = web3.eth.accounts.privateKeyToAccount(privateKey).address; // needed since this is not running with metamask injected
    console.log(account);
    
    const message = await helloWorldContract.methods.message().call();
    console.log("The message is: " + message);

    console.log("Updating the message...");
    // transaction object creation: https://web3js.readthedocs.io/en/v1.2.11/web3-eth-contract.html#id26
    const transaction = await helloWorldContract.methods.update("whats up");
    console.log(transaction)
    const options = {
        to: contractAddress,
        // 'Set the data field on web3.eth.sendTransaction options as the encodeABI() result and it is the same as calling the contract method with contract.myMethod.send().'
        data: transaction.encodeABI(), //https://web3js.readthedocs.io/en/v1.2.11/web3-eth-contract.html#methods-mymethod-encodeabi
        gas: await transaction.estimateGas({from: account}) // https://web3js.readthedocs.io/en/v1.2.11/web3-eth-contract.html#methods-mymethod-estimategas
    };
    const signed  = await web3.eth.accounts.signTransaction(options, privateKey); // this need to be done if running as script, but can also use web3.eth.method.send(<options>) directly and let metamask sign it
    const receipt = await web3.eth.sendSignedTransaction(signed.rawTransaction); // needed since this is not running with metamask injected
   // console.log(receipt);

    const newMessage = await helloWorldContract.methods.message().call();
    console.log("The new message is: " + newMessage); 
}
main().then(() => {
    process.exit(0)
}).catch((error)=> {
    console.error(error)
    process.exit(1)
});