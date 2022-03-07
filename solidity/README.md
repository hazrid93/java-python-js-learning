# deployed contract
- hello world contract address: 
> 0xB621093D85FCFa34610574823ec16C84cB1E4Bc8
> ropsten etherscan address: https://ropsten.etherscan.io/address/0xB621093D85FCFa34610574823ec16C84cB1E4Bc8

## ropsten etherscan address
- https://ropsten.etherscan.io/

## running scripts
```
npx hardhat run scripts/deploy.js
npx hardhat run scripts/interact.js

```
Note: running ```npx run``` without -network if in config is defaulted to hardhat network then it is just an instance that will be destroyed after running. To have an instance that persist temporarily run ```npx hardhat node``` and do npx run with '-network localhost' this will persist as long as the node process still running.

## verify contract at etherscan
Note: the argument must be the argument we passed during contract creating *in constructor

- without argument file
```
npx hardhat verify --network ropsten <DEPLOYED_CONTRACT_ADDRESS> 'Hello World!'
```

- with argument file 'arguments.js'
```
npx hardhat verify --constructor-args ./scripts/arguments.js 0xB621093D85FCFa34610574823ec16C84cB1E4Bc8

```

# RUN AT REMIX
- npm install -g @remix-project/remixd
- run ```
remixd -s <absolute-path-to-the-shared-folder> --remix-ide <your-remix-ide-URL-instance>
e.x: remixd -s C:\codes\github\python-js-learning\solidity --remix-ide https://remix.ethereum.org

```
- open remix at browser and connect to localhost
- Optional: run hardhat locally and connect from remix to use local hardhat node 'npx hardhat node' at http://127.0.0.1:8545/
# DOCS
[web3.js docs](https://web3js.readthedocs.io/en/v1.2.11/web3-eth-contract.html#)
[Solidity official doc](https://docs.soliditylang.org/en/v0.8.4/contracts.html)
[Chai with solidity plugin](https://ethereum-waffle.readthedocs.io/en/latest/matchers.html)
[Hardhat docs](https://hardhat.org/getting-started/)
[Ethers.js](https://docs.ethers.io/v5/getting-started/)
[Metamask API](https://docs.metamask.io/guide/ethereum-provider.html#table-of-contents)
[Alchemy dashboard](https://dashboard.alchemyapi.io/)
[Alchemy composer](https://composer.alchemyapi.io/)
[alchemy/web3 docs](https://docs.alchemy.com/alchemy/documentation/alchemy-web3)
[Chai.js basic usage](https://www.chaijs.com/guide/styles/#expect)
[remix IDE doc](https://remix-ide.readthedocs.io/en/latest/%5C/hardhat_console.html)
[info about solidity ABI](https://medium.com/@eiki1212/explaining-ethereum-contract-abi-evm-bytecode-6afa6e917c3b,  https://ethereum.stackexchange.com/questions/234/what-is-an-abi-and-why-is-it-needed-to-interact-with-contracts) // note: the ABI are not only use for external->smartcontract but also smartcontract->smartcontract, hence there are use cases of keccak256 with abi.encode inside smartcontract,

# TUTORIALS
[example app-renting house](https://www.loginradius.com/blog/async/guest-post/ethereum-smart-contract-tutorial/)
[solidity by example](https://solidity-by-example.org/)
[handson smart contract](https://blockchain-conf.github.io/files/blockchain-hands-on-Tutorial.pdf)
[solidity cheatsheet](https://reference.auditless.com/cheatsheet/)
[solidity high level doc from ethereum](https://ethereum.org/en/developers/docs/smart-contracts/anatomy/)
[uniswap code walkthrough](https://ethereum.org/bg/developers/tutorials/uniswap-v2-annotated-code/#introduction)

Note: remix IDE has some tutorials to learn erc20/721 can use that to  learn.

## compile sol
```
npx hardhat compile
```

## run local eth server
```
npx hardhat node
```

# More README at:
:boom: [alchemy-tutorial-hello-world](./others_project/alchemy-tutorial-hello-world/README.md)

:boom: [hardhat-hackathon-boilerplate-master](./others_project/hardhat-hackathon-boilerplate-master/README.md)