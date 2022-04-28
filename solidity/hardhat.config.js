/**
 * @type import('hardhat/config').HardhatUserConfig
 */

const path = require('path')
require("./tasks/faucet");
require('dotenv').config({ path: path.resolve(__dirname, './.env') })
require("@nomiclabs/hardhat-ethers");
require("@nomiclabs/hardhat-etherscan");

 const { 
   ROP_API_URL, 
   ROP_API_KEY, 
   PRIVATE_KEY,
   ETHERSCAN_API_KEY
  } = process.env;

module.exports = {
  solidity: "0.8.4",
  defaultNetwork: "hardhat",
   networks: {
      hardhat: {
        chainId: 31337
        // enable this to fork testnet/mainnet
        /*
        forking: {
          url: "https://eth-rinkeby.alchemyapi.io/v2/4hWsFUbJe7whcGZZ1vhgGYs-QjtsU7CZ"
        }
        */
      },
      ropsten: {
         url: ROP_API_URL,
         accounts: [`0x${PRIVATE_KEY}`]
      }
   },
   etherscan: {
    // Your API key for Etherscan
    // Obtain one at https://etherscan.io/
    apiKey: ETHERSCAN_API_KEY
  }
};
