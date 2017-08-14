/**
 * Organisation: University of applied sciences Munich, faculty 07
 * Project: lab to class software developement 1 Mrs. Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, sebastian_baumann@gmx.net
 * Study group: IF3A
 * Date: 27. November 2016
 * Purpose: solution to lab Time
 */
public class Time {

    /**
     * Private constant to store the amounts of seconds of a whole day.
     */
    private static final int SECONDS_A_DAY = 86400;

    /**
     * Private constant to store the amounts of seconds of a whole hour.
     */
    private static final int SECONDS_AN_HOUR = 3600;

    /**
     * Private constant to store the amounts of seconds of a whole minute.
     */
    private static final int SECONDS_A_MINUTE = 60;


    /**
     * Private variable to store the amounts of seconds of this time object.
     */
    private int timeInSeconds;


    /**
     * Constructor which needs no parameters.
     */
    Time() {

        this(0);

    }

    /**
     * Constructor which needs the amount of seconds of this time object as a parameter.
     */
    Time(int seconds) {

        this(0, 0, seconds);

    }

    /**
     * Constructor which needs the amount of hours and minutes as parameters.
     */
    Time(int hours, int minutes) {

        this(hours, minutes, 0);

    }

    /**
     * Constructor which needs the amount of hours, minutes and seconds as parameters.
     */
    Time(int hours, int minutes, int seconds) {

        this.timeInSeconds = seconds + (minutes * SECONDS_A_MINUTE) + (hours * SECONDS_AN_HOUR);

    }

    /**
     * Custom copy constructor.
     */
    Time(Time obj) {

        this.timeInSeconds = obj.getTimeInSeconds();

    }


    /**
     * Method to return the amount of seconds of this time object.
     * @return - returns amount of seconds as an integer value.
     */
    int getSeconds() {

        return ((this.getTimeInSeconds() % SECONDS_A_DAY) % SECONDS_AN_HOUR) % SECONDS_A_MINUTE;

    }

    /**
     * Method to return the amount of minutes of this time object.
     * @return - returns amount of minutes as an integer value.
     */
    int getMinutes() {

        return ((this.getTimeInSeconds() % SECONDS_A_DAY) % SECONDS_AN_HOUR) / SECONDS_A_MINUTE;

    }

    /**
     * Method to return the amount of hours of this time object.
     * @return - returns amount of hours as an integer value.
     */
    int getHours() {

        return (this.getTimeInSeconds() % SECONDS_A_DAY) / SECONDS_AN_HOUR;

    }

    /**
     * Method to determine if this time object is equal to another one.
     * @param other - the other time object this time object has to be compared to.
     * @return - returns true, if this and other are equal, and false if not.
     */
    boolean isEqual(Time other) {

        return other != null && this.getTimeInSeconds() == other.getTimeInSeconds();

    }

    /**
     * Method returns the stored time of this time object as seconds.
     * @return - returns seconds as an integer value.
     */
    int getTimeInSeconds() {

        return timeInSeconds;

    }

    /**
     * Method to add time as seconds to this time object.
     * @param sec - time as seconds which should be added to this time object.
     */
    void add(int sec) {

        if (sec >= 0 || this.getTimeInSeconds() > Math.abs(sec)) {

            this.timeInSeconds += sec;

        }

        else {

            this.timeInSeconds = SECONDS_A_DAY - Math.abs(timeInSeconds - (Math.abs(sec) % SECONDS_A_DAY));

        }
    }

    /**
     * Method to determine the difference of this time object to another time object 'other'.
     * @param other - other time object this time object has to be compared to.
     * @return - returns the difference of this time object to other time object as seconds as an inter value.
     */
    int diff(Time other) {

        if (other == null) {

            return -1;

        }

        return Math.abs(this.getTimeInSeconds() - other.getTimeInSeconds());

    }

    /**
     * Method to generate a string representation of this time object.
     * @return - returns a string representation of this time object.
     */
    public String toString() {

        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());

    }
}