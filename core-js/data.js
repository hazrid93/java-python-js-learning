
/*
[way to create]:
new Date()
new Date(year, month, day, hours, minutes, seconds, milliseconds)
new Date(milliseconds) //  milliseconds since January 01, 1970, 00:00:00 UTC (Universal Time Coordinated).
new Date(date string) // example new Date("October 13, 2014 11:13:00");

[type of date string format]:
// more at https://www.w3schools.com/js/js_date_formats.asp
Type	    Example
ISO Date	"2015-03-25T12:00:00Z" (The International Standard)
ISO Date	"2015-03-25T12:00:00-06:30" (The International Standard)
Short Date	"03/25/2015"
Long Date	"Mar 25 2015" or "25 Mar 2015"

[methods]:
toUTCString() // method converts a date to a UTC string (a date display standard).
toDateString() // method converts a date to a more readable format:
toISOString() // method converts a Date object to a string, using the ISO standard format:

[timezone]:
When setting a date, without specifying the time zone, JavaScript will use the browser's time zone.
When getting a date, without specifying the time zone, the result is converted to the browser's time zone.
In other words: If a date/time is created in GMT (Greenwich Mean Time), the date/time will be converted to CDT (Central US Daylight Time) if a user browses from central US.

Note: UTC (Universal Time Coordinated) is the same as GMT (Greenwich Mean Time).
*/

// new date
const d1 = new Date();
console.log(d1 ) // default view is : Tue Jan 18 2022 21:44:45 GMT+0800 (Malaysia Time)
console.log(d1.toDateString())
console.log(d1.toUTCString())
console.log(d1.toISOString())

// Date.parse() returns the number of milliseconds between the date and January 1, 1970
const d2 = new Date();
console.log(Date.parse(d2))

/*
[Get methods]:
getFullYear()	Get the year as a four digit number (yyyy)
getMonth()	Get the month as a number (0-11)
getDate()	Get the day as a number (1-31)
getHours()	Get the hour (0-23)
getMinutes()	Get the minute (0-59)
getSeconds()	Get the second (0-59)
getMilliseconds()	Get the millisecond (0-999)
getTime()	Get the time (milliseconds since January 1, 1970)
getDay()	Get the weekday as a number (0-6)
Date.now()	Get the time. ECMAScript 5.

//for UTC
getUTCDate()	Same as getDate(), but returns the UTC date
getUTCDay()	Same as getDay(), but returns the UTC day
getUTCFullYear()	Same as getFullYear(), but returns the UTC year
getUTCHours()	Same as getHours(), but returns the UTC hour
getUTCMilliseconds()	Same as getMilliseconds(), but returns the UTC milliseconds
getUTCMinutes()	Same as getMinutes(), but returns the UTC minutes
getUTCMonth()	Same as getMonth(), but returns the UTC month
getUTCSeconds()	Same as getSeconds(), but returns the UTC seconds

[set methods]:
setDate()	        Set the day as a number (1-31)
setFullYear()	    Set the year (optionally month and day)
setHours()	        Set the hour (0-23)
setMilliseconds()	Set the milliseconds (0-999)
setMinutes()	    Set the minutes (0-59)
setMonth()	        Set the month (0-11)
setSeconds()	    Set the seconds (0-59)
setTime()	        Set the time (milliseconds since January 1, 1970)
*/


// setDate example
let text;
const today = new Date();
const someday = new Date();
someday.setFullYear(2100, 0, 14);

if (someday > today) {
  text = "Today is before January 14, 2100.";
} else {
  text = "Today is after January 14, 2100.";
}
console.log(text)