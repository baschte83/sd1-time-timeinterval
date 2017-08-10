# Time and TimeInterval

### Assignment, class and language
This is my solution to the assignment **Time and TimeInterval** of class **software developement 1,** written in Java.

### Requirements
This program consists of three classes: class **Time**, class **TimeInterval** and a custom **Main** class, to test the former two classes.

#### Class Time
Objects of this class represent a time data according to this scheme: `hh:mm:ss`. I was allowed to use only one variable, that was not a constant: to store the amount of seconds of this time object. It should be possible to add seconds to this time object, to compare this time object to another one, to get the represented seconds, minutes and hours of this time object and to generate a String representation of the time data of this time object which should look like this: `hh:mm:ss`.

#### Class TimeInterval
Objects of this class represent a range of time, which consists of an object of class **Time** as the start of the interval and an integer value as the **duration**, which means, how long the interval should be. I was allowed to use two non constant variables, one for the start of the interval and one for the duration. It should be possible to get the start and the end of the interval as **Time** objects, to get the duration, to move the whole interval by an amount of seconds, to copy the whole interval using methods to generate a **deep copy** and to generate a String representation of the interval which should look like this: `[hh:mm:ss, hh:mm:ss]`.
