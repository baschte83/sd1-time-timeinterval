/**
 * Organisation: University of applied sciences Munich, faculty 07
 * Project: lab to class software developement 1 Mrs. Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, sebastian_baumann@gmx.net
 * Study group: IF3A
 * Date: 27. November 2016
 * Purpose: solution to lab TimeInterval
 */
public class TimeInterval {

    /**
     * Private variable to store the lower border of this TimeInterval object.
     */
    private Time lower;

    /**
     * Private variable to store the difference from the start to the end of this TimeInterval object.
     */
    private int duration;

    /**
     * Constructor which needs a start (as a Time object) and the length of this interval as seconds.
     * @param lower - lower border of this TimeInterval object as a Time object.
     * @param duration - the length of this TimeInterval object.
     */
    public TimeInterval(Time lower, int duration) {

        this.lower = lower;
        this.duration = duration;

    }

    /**
     * Constructor which only needs the length of this TimeInterval object.
     * The start for this TimeInterval object is automatically set to 00:00:00.
     * @param duration - length of this TimeInterval in seconds.
     */
    public TimeInterval(int duration) {

        this(new Time(), duration);

    }

    /**
     * Constructor to make this TimeInterval object a copy of other TimeInterval object.
     * @param other - other TimeInterval object this TimeInterval object should be a copy of.
     */
    public TimeInterval(TimeInterval other) {

        this(other.getLower(), other.getDuration());

    }

    /**
     * Method to return the start of this TimeInterval object as a Time object.
     * @return - returns the start of this TimeInterval object as a Time object.
     */
    Time getLower() {

        return this.lower;

    }

    /**
     * Method to return the end of this TimeInterval object as a Time object.
     * @return - returns the end of this TimeInterval object as a Time object.
     */
    Time getUpper() {

        return new Time(this.getLower().getTimeInSeconds() + this.getDuration());

    }

    /**
     * Method to return the length of this TimeInterval object as seconds as an integer value.
     * @return - returns the length of this TimeInterval object as seconds as an integer value.
     */
    int getDuration() {

        return this.duration;

    }

    /**
     * Method to move this TimeInterval object.
     * @param sec - amount of seconds this TimeInterval object has to be moved.
     */
    void move(int sec) {

        this.getLower().add(sec);

    }

    /**
     * Method generated a deep copy of this TimeInterval object and returns a new TimeInterval object with the values of this one.
     * @return - returns a new TimeInterval object as a deep copy of this TimeInterval object.
     */
    public TimeInterval deepCopy() {

        return new TimeInterval(new Time(this.getLower()), this.getDuration());

    }

    // Liefert dieses Intervall in der Form [<Untere Grenze>,<Obere Grenze>] zurueck

    /**
     * Method generates a string representation of this TimeInterval object.
     * The string representation looks like this: [hh:mm:ss,hh:mm:ss].
     * @return - returns a string of this TimeInterval object.
     */
    public String toString() {

        return String.format("[%s,%s]", this.getLower().toString(), this.getUpper().toString());

    }
}