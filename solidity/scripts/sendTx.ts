
const { createAlchemyWeb3 } = require("@alch/alchemy-web3");
const path = require('path')
require('dotenv').config({ path: path.resolve(__dirname, '../../.env') })
const { API_URL, PRIVATE_KEY } = process.env;
async function main() {
    // console.log("dirname : " + JSON.stringify(process.env))
    const web3 = createAlchemyWeb3(API_URL);
    const myAddress = '0x9645e72f2471ae5d9edEE41BcCFF399caC57DF0e' //TODO: replace this address with your own public address
   
    const nonce = await web3.eth.getTransactionCount(myAddress, 'latest'); // nonce starts counting from 0

    const transaction = {
     'to': '0x31B98D14007bDEe637298086988A0bBd31184523', // faucet address to return eth
     'value': 100,
     'gas': 30000,
     'maxPriorityFeePerGas': 1000000108,
     //'maxFeePerGas': 1000000108,
     'nonce': nonce,
     // optional data field to send message or execute smart contract
    };
   
    const signedTx = await web3.eth.accounts.signTransaction(transaction, PRIVATE_KEY);
    
    web3.eth.sendSignedTransaction(signedTx.rawTransaction, function(error, hash) {
    if (!error) {
      console.log("🎉 The hash of your transaction is: ", hash, "\n Check Alchemy's Mempool to view the status of your transaction!");
    } else {
      console.log("❗Something went wrong while submitting your transaction:", error)
    }
   });
}

main();