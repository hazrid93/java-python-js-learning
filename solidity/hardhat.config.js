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
  solidity: "0.7.3",
  defaultNetwork: "hardhat",
   networks: {
      hardhat: {
        chainId: 1337
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
