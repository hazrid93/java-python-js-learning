let date = '2022-03-03T12:12:53';
let nowDate = '2022-03-06T12:12:43';
let now = new Date(nowDate);
console.log('now: ' + now)
let convertedLastResetDate = new Date(date);
console.log(now - convertedLastResetDate);
let secs = Math.floor((now - (convertedLastResetDate)) / 1000);
let mins = Math.floor(secs / 60);
let hours = Math.floor(mins / 60);
let days = Math.floor(hours / 24);

let output = "";

if (days > 0) {
output += days + " day"
} else if (hours > 0) {
output += hours + " hour"
} else if (mins > 0) {
output += mins + " minute"
} else if (secs > 0) {
output += secs + " second"
}

if (parseInt(output) > 1) {
output += "s "
} else {
output += " "
}
console.log(output)

