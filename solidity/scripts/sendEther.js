const path = require('path')
require('dotenv').config({ path: path.resolve(__dirname, '../.env') });
const { createAlchemyWeb3 } = require("@alch/alchemy-web3");
//const rinkebyUrl = process.env.API_URL;
//const web3 = createAlchemyWeb3(rinkebyUrl);

const localNodeUrl = "http://localhost:8545";
const web3 = createAlchemyWeb3(localNodeUrl);

/**
 * Account #0: 0xf39fd6e51aad88f6f4ce6ab8827279cfffb92266 (10000 ETH)
 * Private Key: 0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80
 * Account #1: 0x70997970c51812dc3a010c7d01b50e0d17dc79c8 (10000 ETH)
 * Private Key: 0x59c6995e998f97a5a0044966f0945389dc9e86dae88c7a8412f4603b6b78690d
 */

async function main(){
    //import mock private acc
    const account1Key = "0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80";
    const account1 = web3.eth.accounts.privateKeyToAccount(account1Key).address;
    const account2 = "0x70997970c51812dc3a010c7d01b50e0d17dc79c8";
    const gasPrice = await web3.eth.getGasPrice();
    console.log("gasPrice : " + gasPrice);
    //web3.utils.toWei('1', 'ether')
    const options = {
        to: account2,
        gasPrice: gasPrice,
        data: "",
        gas: "41000", //sending to an address that is not a contract the gas is always 21000.
        value: web3.utils.toWei('1', 'ether') //must put in wei so use web3 utils to convert 1 ether to wei representative
    };
    const signed  = await web3.eth.accounts.signTransaction(options, account1Key); // this need to be done if running as script, but can also use web3.eth.method.send(<options>) directly and let metamask sign it
    const receipt = await web3.eth.sendSignedTransaction(signed.rawTransaction); // needed since this is not running with metamask injected
    console.log("receipt: " + JSON.stringify(receipt));
}

main();