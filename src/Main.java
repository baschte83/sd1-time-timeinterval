public class Main {

    private static final int CONVERSION_CONSTANT_SECONDS_MINUTES = 60;
    private static final int CONVERSION_CONSTANT_HOURS_A_DAY = 24;

    public static void main(String[] args) {

        // Tests Time
        Time time1 = new Time(2, 2, 2);
        Time time2 = new Time(3, 3);
        Time time3 = new Time(20);
        Time time4 = new Time();
        Time time5 = new Time(time4);
        System.out.println("Test Custom-Konstruktor. Sollte 02:02:02 erzeugen: " + time1.toString());
        System.out.println("Test Custom-Konstruktor. Sollte 03:03:00 erzeugen: " + time2.toString());
        System.out.println("Test Custom-Konstruktor. Sollte 00:00:20 erzeugen: " + time3.toString());
        System.out.println("Test Custom-Konstruktor. Sollte 00:00:00 erzeugen: " + time4.toString());
        System.out.println("Test Copy-Konstruktor.   Sollte 00:00:00 erzeugen: " + time5.toString());
        time5.add(35);
        System.out.println("Test Copy-Konstruktor.   Sollte 00:00:00 erzeugen: " + time4.toString());
        System.out.println("Test Copy-Konstruktor.   Sollte 00:00:35 erzeugen: " + time5.toString());
        System.out.println("Test int getSeconds.     Sollte 35 zurückgeben:    " + time5.getSeconds());
        time5.add(3655);
        System.out.println("Test int .add().         Sollte 1 zurückgeben:     " + time5.getMinutes());
        System.out.println("Test int getHours.       Sollte 1 zurückgeben:     " + time5.getHours());
        System.out.println("Test int isEqual.        Sollte false zurückgeben: " + time5.isEqual(time1));
        Time time6 = new Time(time5);
        System.out.println("Test int isEqual.        Sollte true zurückgeben:  " + time5.isEqual(time6));
        System.out.println("Test getTimeInSeconds.   Sollte 3690 zurückgeben:  " + time5.getTimeInSeconds());
        System.out.println("Test int diff.           Sollte 3632 zurückgeben:  " + time5.diff(time1));

        // Tests Hammerschall
        Time time7 = new Time(23, 59, 59);
        Time time8 = new Time(24, 00, 00);
        System.out.println("Test int diff Hammerschall. Soll 1 zurückgeben:    " + time7.diff(time8));

        Time time9 = new Time(23, 59, 58);
        System.out.println("Test int diff Hammerschall. Soll 1 zurückgeben:    " + time7.diff(time9));

        Time time10 = new Time();
        System.out.println("Test int diff Hammerschall. Soll 86399 zurückgeben:" + time7.diff(time10));

        Time time11 = new Time();
        System.out.println("Test time11.                Soll 00:00:00 sein:    " + time11.toString());
        time11.add(-86410); // Abzug von mehr als einem Tag
        System.out.println("Test add(-86410).           Soll 23:59:50 sein:    " + time11.toString());

        /*// Test Time auf null

        Time time1 = new Time(0, 0, 0);
        Time time2 = null;
        System.out.println("Test int isEqual auf null.  Sollte false zurückgeben: " + time1.isEqual(time2));

        // Tests TimeInterval
        TimeInterval ival1 = new TimeInterval(new Time(0, 0, 0), 60);
        System.out.println("Test Konstruktor. Soll [00:00:00, 00:01:00] sein:  " + ival1.toString());
        TimeInterval ival2 = new TimeInterval(new Time(2, 2, 2), 20);
        System.out.println("Test toString().  Soll [02:02:02, 02:02:22] sein:  " + ival2.toString());
        System.out.println("Test getLower.    Soll 02:02:02 sein:              " + ival2.getLower().toString());
        System.out.println("Test getUpper.    Soll 02:02:22 sein:              " + ival2.getUpper().toString());
        System.out.println("Test getDuration. Soll 20 sein:                    " + ival2.getDuration());
        ival2.move(40);
        System.out.println("Test move(40).    Soll [02:02:42, 02:03:02] sein:  " + ival2.toString());
        ival2.deepCopy();
        System.out.println("Test deepCopy().  Soll [02:02:42, 02:03:02] sein:  " + ival2.toString());

        // Tests Hammerschall
        System.out.println("TestHS toString().Soll [12:50:00, 12:50:59] sein:  " + new TimeInterval(new Time(12, 50, 0), 59).toString());*/
    }
}