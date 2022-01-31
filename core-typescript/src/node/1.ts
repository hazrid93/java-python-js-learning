
import fs = require('fs')

console.log(process);

module.exports = {
    print: function(msg){
        console.log("date: " + Date.now() + ", message: " + msg);
    }
}