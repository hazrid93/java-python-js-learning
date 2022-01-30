### Extra note about date handling in java
Use two columns: DATETIME, and a VARCHAR to hold the time zone information, which may be in several forms:

A timezone or location such as America/New_York is the highest data fidelity.

A timezone abbreviation such as PST is the next highest fidelity.

A time offset such as -2:00 is the smallest amount of data in this regard.

Some key points:

Avoid TIMESTAMP because it's limited to the year 2038, and MySQL relates it to the server timezone, which is probably undesired.
A time offset should not be stored naively in an INT field, because there are half-hour and quarter-hour offsets.
If it's important for your use case to have MySQL compare or sort these dates chronologically, DATETIME has a problem:

'2009-11-10 11:00:00 -0500' is before '2009-11-10 10:00:00 -0700' in terms of "instant in time", but they would sort the other way when inserted into a DATETIME.

You can do your own conversion to UTC. In the above example, you would then have
'2009-11-10 16:00:00' and '2009-11-10 17:00:00' respectively, which would sort correctly. When retrieving the data, you would then use the timezone info to revert it to its original form.

One recommendation which I quite like is to have three columns:

local_time DATETIME
utc_time DATETIME
time_zone VARCHAR(X) where X is appropriate for what kind of data you're storing there. (I would choose 64 characters for timezone/location.)
An advantage to the 3-column approach is that it's explicit: with a single DATETIME column, you can't tell at a glance if it's been converted to UTC before insertion.

Regarding the descent of accuracy through timezone/abbreviation/offset:

If you have the user's timezone/location such as America/Juneau, you can know accurately what the wall clock time is for them at any point in the past or future (barring changes to the way Daylight Savings is handled in that location). The start/end points of DST, and whether it's used at all, are dependent upon location, so this is the only reliable way.
If you have a timezone abbreviation such as MST, (Mountain Standard Time) or a plain offset such as -0700, you will be unable to predict a wall clock time in the past or future. For example, in the United States, Colorado and Arizona both use MST, but Arizona doesn't observe DST. So if the user uploads his cat photo at 14:00 -0700 during the winter months, was he in Arizona or California? If you added six months exactly to that date, would it be 14:00 or 13:00 for the user?
These things are important to consider when your application has time, dates, or scheduling as core function.

References:
MySQL Date/Time Reference
The Proper Way to Handle Multiple Time Zones in MySQL

[source](https://stackoverflow.com/a/59004019)

### Timezone and abbreviation  
- There are timezone that share the same offset
- There are also no uniform standard for timezone abbreviation

[source](https://stackoverflow.com/questions/19251420/get-timezone-abbreviation-from-utc-offset#:~:text=There%20isn't%20a%20guaranteed,does%20the%20offset%20from%20UTC.)


### Resources
[freecodecamp](https://stackoverflow.com/questions/19251420/get-timezone-abbreviation-from-utc-offset#:~:text=There%20isn't%20a%20guaranteed,does%20the%20offset%20from%20UTC.)
[w3](https://www.w3.org/TR/timezone/)
[stackoverflow - always UTC?](https://stackoverflow.com/questions/11537106/is-it-always-a-good-idea-to-store-time-in-utc-or-is-this-the-case-where-storing)