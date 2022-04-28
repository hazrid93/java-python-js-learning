const path = require('path')
require('dotenv').config({ path: path.resolve(__dirname, '../.env') });
const { createAlchemyWeb3 } = require("@alch/alchemy-web3"); // for testnet but not for local hardhat node
//const rinkebyUrl = process.env.API_URL;
const localNodeUrl = "http://localhost:8545";
const web3 = createAlchemyWeb3(localNodeUrl);


async function main(){
    //import mock private acc
    const account1Key = "0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80";
    const account1 = web3.eth.accounts.privateKeyToAccount(account1Key).address;
    const account2 = "0x70997970c51812dc3a010c7d01b50e0d17dc79c8";

    const accountBalance = await web3.eth.getBalance("0x70997970c51812dc3a010c7d01b50e0d17dc79c8");
    console.log(accountBalance)
}

main();