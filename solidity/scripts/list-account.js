
async function main () {
    // Our code will go here
    // Retrieve accounts from the local node
    const accounts = await ethers.provider.listAccounts();
    if(accounts.length >= 0) {
        for(const account of accounts){
            let balance = await ethers.provider.getBalance(account);
            // change to ether unit instead of wei
            console.log(ethers.utils.formatEther(balance));
        }
    }
    console.log(accounts);
  }
  
  main()
    .then(() => process.exit(0))
    .catch(error => {
      console.error(error);
      process.exit(1);
    });