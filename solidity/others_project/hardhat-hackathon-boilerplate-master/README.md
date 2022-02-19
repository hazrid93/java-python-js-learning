# Hardhat Hackathon Boilerplate
This project folder is basically recommended template for hardhat solidity dapp project.

This repository contains a sample project that you can use as the starting point
for your Ethereum project. It's also a great fit for learning the basics of
smart contract development.

This project is intended to be used with the
[Hardhat Beginners Tutorial](https://hardhat.org/tutorial), but you should be
able to follow it by yourself by reading the README and exploring its
`contracts`, `tests`, `scripts` and `frontend` directories.

## Quick start

The first things you need to do are cloning this repository and installing its
dependencies:

```sh
git clone https://github.com/nomiclabs/hardhat-hackathon-boilerplate.git
cd hardhat-hackathon-boilerplate
npm install
```

Once installed, let's run Hardhat's testing network:

```sh
npx hardhat node
```

Compile the contract with:

```
npx hardhat compile
```

Then, on a new terminal, go to the repository's root folder and run this to
deploy your contract:

```sh
npx hardhat run scripts/deploy.js --network localhost
```

Finally, we can run the frontend with:

```sh
cd frontend
npm install
npm start
```

> Note: There's [an issue in `ganache-core`](https://github.com/trufflesuite/ganache-core/issues/650) that can make the `npm install` step fail. 
>
> If you see `npm ERR! code ENOLOCAL`, try running `npm ci` instead of `npm install`.

Open [http://localhost:3000/](http://localhost:3000/) to see your Dapp. You will
need to have [Metamask](https://metamask.io) installed and listening to
`localhost 8545`.


## Testing
- Create a new directory called test inside our project root directory and create a new file called Token.js
- Run command 
```npx hardhat test```
- More at [link](https://hardhat.org/tutorial/testing-contracts.html)
- Note that if contract is changed then contract will automatically be compiled again.

## Debugging
- Add ```import "hardhat/console.sol";``` into contract (.sol)
then use ```console.log(param)``` wherever in contract.
When running ```npx hardhat test``` the content will be printedd.
- More at [link](https://hardhat.org/tutorial/debugging-with-hardhat-network.html)

## Metamask and faucet
- When running hardhat locally change metamask to point to localhost
- If there are no token available then run ```npx hardhat --network localhost faucet 0x9645e72f2471ae5d9edee41bccff399cac57df0e``` to get some Ethers,
note replace the address with whatever address of wallet we want to have ETH.

## Web3.js /alchemy-web3 docs
source at [web3](https://web3js.readthedocs.io/en/v1.2.9/index.html)
source at [alchemy_web3](https://github.com/alchemyplatform/alchemy-web3)

## Openzeppelin tutorial
source at [link](https://docs.openzeppelin.com/learn/)

## Chai assertion solidity plugin
Chai with solidity plugin (by waffle)
- More at [link](https://ethereum-waffle.readthedocs.io/en/latest/matchers.html)
- Chai syntax [link](https://www.chaijs.com/api/bdd/)

## Hardhat Runtime Environment(HRE)
Note that when running hardhat using npx command the hardhat runtime environment(HRE) are injected including plugin.
For example adding ```require("@nomiclabs/hardhat-ethers");``` inside hardhat.config.js will make script able to use ethers.js
injected via hardhat. For running script without ```npx hardhat <script>``` then need to import HRE manually ```const hardhat = require("hardhat")```
- More at [link](https://hardhat.org/advanced/hardhat-runtime-environment.html)

## User Guide

You can find detailed instructions on using this repository and many tips in [its documentation](https://hardhat.org/tutorial).

- [Writing and compiling contracts](https://hardhat.org/tutorial/writing-and-compiling-contracts/)
- [Setting up the environment](https://hardhat.org/tutorial/setting-up-the-environment/)
- [Testing Contracts](https://hardhat.org/tutorial/testing-contracts/)
- [Setting up Metamask](https://hardhat.org/tutorial/hackathon-boilerplate-project.html#how-to-use-it)
- [Hardhat's full documentation](https://hardhat.org/getting-started/)

For a complete introduction to Hardhat, refer to [this guide](https://hardhat.org/getting-started/#overview).

## What’s Included?

Your environment will have everything you need to build a Dapp powered by Hardhat and React.

- [Hardhat](https://hardhat.org/): An Ethereum development task runner and testing network.
- [Mocha](https://mochajs.org/): A JavaScript test runner.
- [Chai](https://www.chaijs.com/): A JavaScript assertion library.
- [ethers.js](https://docs.ethers.io/v5/): A JavaScript library for interacting with Ethereum.
- [Waffle](https://github.com/EthWorks/Waffle/): To have Ethereum-specific Chai assertions/mathers.
- [A sample frontend/Dapp](./frontend): A Dapp which uses [Create React App](https://github.com/facebook/create-react-app).

## Troubleshooting

- `Invalid nonce` errors: if you are seeing this error on the `npx hardhat node`
  console, try resetting your Metamask account. This will reset the account's
  transaction history and also the nonce. Open Metamask, click on your account
  followed by `Settings > Advanced > Reset Account`.

## Feedback, help and news

We'd love to have your feedback on this tutorial. Feel free to reach us through
this repository or [our Discord server](https://invite.gg/HardhatSupport).

Also you can [follow us on Twitter](https://twitter.com/HardhatHQ).

**Happy _building_!**
