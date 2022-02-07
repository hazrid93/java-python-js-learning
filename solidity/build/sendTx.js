var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
var createAlchemyWeb3 = require("@alch/alchemy-web3").createAlchemyWeb3;
var path = require('path');
require('dotenv').config({ path: path.resolve(__dirname, '../../.env') });
var _a = process.env, API_URL = _a.API_URL, PRIVATE_KEY = _a.PRIVATE_KEY;
function main() {
    return __awaiter(this, void 0, void 0, function () {
        var web3, myAddress, nonce, transaction, signedTx;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    web3 = createAlchemyWeb3(API_URL);
                    myAddress = '0x9645e72f2471ae5d9edEE41BcCFF399caC57DF0e' //TODO: replace this address with your own public address
                    ;
                    return [4 /*yield*/, web3.eth.getTransactionCount(myAddress, 'latest')];
                case 1:
                    nonce = _a.sent();
                    transaction = {
                        'to': '0x31B98D14007bDEe637298086988A0bBd31184523',
                        'value': 100,
                        'gas': 30000,
                        'maxPriorityFeePerGas': 1000000108,
                        //'maxFeePerGas': 1000000108,
                        'nonce': nonce,
                        // optional data field to send message or execute smart contract
                    };
                    return [4 /*yield*/, web3.eth.accounts.signTransaction(transaction, PRIVATE_KEY)];
                case 2:
                    signedTx = _a.sent();
                    web3.eth.sendSignedTransaction(signedTx.rawTransaction, function (error, hash) {
                        if (!error) {
                            console.log("🎉 The hash of your transaction is: ", hash, "\n Check Alchemy's Mempool to view the status of your transaction!");
                        }
                        else {
                            console.log("❗Something went wrong while submitting your transaction:", error);
                        }
                    });
                    return [2 /*return*/];
            }
        });
    });
}
main();
//# sourceMappingURL=sendTx.js.map