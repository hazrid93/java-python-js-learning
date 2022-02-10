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

## compile sol
```
npx hardhat compile
```

## run local eth server
```
npx hardhat node
```