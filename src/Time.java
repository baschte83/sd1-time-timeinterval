/*
 * Organisation: Hochschule Muenchen, Fakultaet 07
 * Project: Praktikum Softwareentwicklung 1 Frau Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, bauman21@hm.edu
 * Study group: IF3A
 * Date: 27. November 2016
 * Purpose: Loesung Praktikumseinheit 05: Time
 * Software: Oracle Java SE JDK 1.8.0_101, Windows 10 x86_64
 * Hardware: Intel Core i5-6300 @ 2.40 GHz 2.50 GHz, 2 Cores, 4096 MB RAM
 */

/*
 * Hinweise:
 * add:     komplexeste Methode, Loesung mit maximal 9 Zeilen
 * diff:    Pruefung auf Null, maximal 4 Zeilen (inkl. korrekter Klammerung)
 * isEqual: Pruefung auf Null, maximal 4 Zeilen (inkl. korrekter Klammerung)
 * ae:      Eine einzige Zeile im Methodenrumpf
 */

public class Time {

    // Deklaration und Intitialisierung der benoetigten Konstanten -------------------------
    private static final int SECONDS_A_DAY = 86400;                         // 86400 Sekunden hat ein voller Tag
    private static final int SECONDS_AN_HOUR = 3600;                        // 3600 Sekunden hat eine Stunde
    private static final int SECONDS_A_MINUTE = 60;                         // 60 Sekunden hat eine Minute


    // Deklaration der benoetigten Objektvariablen -----------------------------------------
    private int timeInSeconds;


    // Default-Konstruktor, der das Objekt mit 00:00:00 initialisiert.
    // Benutzt Time(int seconds) {}
    Time() {

        this(0);

    }

    // Konstruktor, der Sekunden akzeptiert. Stunden und Minuten werden auf 0 gesetzt.
    // Benutzt Time(int hours, int minutes, int seconds) {}
    Time(int seconds) {

        this(0, 0, seconds);

    }

    // Konstruktor, der Stunden und Minuten akzeptiert, Sekunden werden automatisch auf 0 gesetzt
    // Benutzt Time(int hours, int minutes, int seconds) {}
    Time(int hours, int minutes) {

        this(hours, minutes, 0);

    }

    // Konstruktoren ----------------------------------------------------------------------
    Time(int hours, int minutes, int seconds) {

        this.timeInSeconds = seconds + (minutes * SECONDS_A_MINUTE) + (hours * SECONDS_AN_HOUR);

    }

    // Copy-Konstruktor
    Time(Time obj) {

        this.timeInSeconds = obj.getTimeInSeconds();

    }


    // Methoden ---------------------------------------------------------------------------
    // Liefert die Anzahl an Sekunden im Intervall von 0 bis 59
    int getSeconds() {

        return ((this.getTimeInSeconds() % SECONDS_A_DAY) % SECONDS_AN_HOUR) % SECONDS_A_MINUTE;

    }

    // Liefert die Anzahl an Minuten im Intervall 0 bis 59
    int getMinutes() {

        return ((this.getTimeInSeconds() % SECONDS_A_DAY) % SECONDS_AN_HOUR) / SECONDS_A_MINUTE;

    }

    // Liefert die Anzahl an Stunden im Intervall von 0 bis 23
    int getHours() {

        return (this.getTimeInSeconds() % SECONDS_A_DAY) / SECONDS_AN_HOUR;

    }

    // Liefert false zurueck, falls other == null oder falls dieses Objekt und other nicht uebereinstimmen
    boolean isEqual(Time other) {

        return other != null && this.getTimeInSeconds() == other.getTimeInSeconds();

    }

    // Liefert die gesamte gespeicherte Zeit in Sekunden zurueck
    int getTimeInSeconds() {

        return timeInSeconds;

    }

    // Zaehlt zu der gespeicherten Zeit in Sekunden sec hinzu. Falls sec groesser oder gleich
    // 0 ist oder die gespeicherte Zeit in Sekunden groesser ist als der Betrag von sec, dann wird sec einfach
    // zur gesamten Zeit in Sekunden hinzugezaehlt/abgezogen, je nach Vorzeichen von sec. Ist der Betrag von
    // sec aber groesser als die gespeicherte Zeit in Sekunden, so wird sicherlich eine Tagesgrenze rueckwaerts
    // ueberschritten. Wird eine Tagesgrenze Rueckwaerts ueberschritten, so muss die restliche Zeit, die uebrig
    // bleibt, wenn man von der gespeicherten Zeit in Sekunden sec abgezogen hat, von vollen 86400 Sekunden des
    // Tages davor abgezogen werden. Ich teste in meiner Methode noch, ob sec gleich mehrere Tage von dem aktuellen
    // Zeitpunkt abzieht. Deshalb das Modulo mit SECONDS_A_DAY.
    void add(int sec) {

        if (sec >= 0 || this.getTimeInSeconds() > Math.abs(sec)) {

            this.timeInSeconds += sec;

        }

        else {

            this.timeInSeconds = SECONDS_A_DAY - Math.abs(timeInSeconds - (Math.abs(sec) % SECONDS_A_DAY));

        }
    }

    // Liefert den Zeitunterschied von diesem Objekt zu Objekt other zurueck
    int diff(Time other) {

        if (other == null) {

            return -1;

        }

        return Math.abs(this.getTimeInSeconds() - other.getTimeInSeconds());

    }

    // Liefert einen String in der Form hh:mm:ss an den Aufrufer zurueck
    public String toString() {

        return String.format("%02d:%02d:%02d", getHours(), getMinutes(), getSeconds());

    }
}