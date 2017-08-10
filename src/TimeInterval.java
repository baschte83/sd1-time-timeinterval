/*
 * Organisation: Hochschule Muenchen, Fakultaet 07
 * Project: Praktikum Softwareentwicklung 1 Frau Prof. Dr. Hammerschall, WS 2016/2017
 * Author: Sebastian Baumann, bauman21@hm.edu
 * Study group: IF3A
 * Date: 27. November 2016
 * Purpose: Loesung Praktikumseinheit 05: TimeInterval
 * Software: Oracle Java SE JDK 1.8.0_101, Windows 10 x86_64
 * Hardware: Intel Core i5-6300 @ 2.40 GHz 2.50 GHz, 2 Cores, 4096 MB RAM
 */

/*
 * Hinweise:
 * Konstruktoren:   In einem benoetigt man zwei Anweisungen
 * ae:              Eine einzige Anweisung im Methodenrumpf
 */

public class TimeInterval {

    // Deklaration der benoetigten Objektvariablen -----------------------------------------
    private Time lower;     // Untergrenze des Intervalls
    private int duration;   // Zeitraum des Intervalls als int-Wert


    // Konstruktoren ----------------------------------------------------------------------
    // Konstruktor, der die Startzeit als Time-Objekt und den Zeitraum erhaelt
    public TimeInterval(Time lower, int duration) {

        this.lower = lower;
        this.duration = duration;

    }

    // Konstruktor, der den Zeitraum als Wert erhaelt, wobei die Startzeit auf 00:00:00 gesetzt wird
    public TimeInterval(int duration) {

        this(new Time(), duration);

    }

    // Copy-Konstruktor, der eine flache Kopie des uebergebenen Zeitintervalls macht
    public TimeInterval(TimeInterval other) {

        this(other.getLower(), other.getDuration());

    }


    // Methoden ---------------------------------------------------------------------------
    // Liefert untere Grenze des Zeitintervalls zurueck
    Time getLower() {

        return this.lower;

    }

    // Liefert obere Grenze des Zeitintervalls zurueck
    Time getUpper() {

        return new Time(this.getLower().getTimeInSeconds() + this.getDuration());

    }

    // Liefert die Dauer des Zeitintervalls in Sekunden zurueck
    int getDuration() {

        return this.duration;

    }

    // Verschiebt das Intervall um sec Sekunden
    void move(int sec) {

        this.getLower().add(sec);

    }

    // Erzeugt eine tiefe Kopie dieses Zeitintervalls und gibt diese zurueck
    TimeInterval deepCopy() {

        return new TimeInterval(new Time(this.getLower()), this.getDuration());

    }

    // Liefert dieses Intervall in der Form [<Untere Grenze>,<Obere Grenze>] zurueck
    public String toString() {

        return String.format("[%s,%s]", this.getLower().toString(), this.getUpper().toString());

    }
}