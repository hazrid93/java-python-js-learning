// adding inside node package.json = "type": "module" will allow us to use ES6 import export syntax on local node_modules
// without 'type: module', a node project only support common.js import-export by using 'modules.export' and 'require' for dependencies under node_modules.
// on webpack project with Babel transpiller, we dont need type:module because babel will help transform ES6 import export syntax into common.js
// more notes on node(commonjs) import/export syntax: https://www.w3schools.com/nodejs/nodejs_modules.asp

const utility = require("utility") // nodejs(commonjs import/export module)


// example of using node module (imported dependency)
let stringToEncode = "hazrid"
console.log(utility.base64encode(stringToEncode));
