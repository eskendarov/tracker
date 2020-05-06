package ru.job4j.prof;

public class Doctor extends Profession {
    String rank;
    String dress;
    Patient patient;

    public String getRank() {
        return rank;
    }

    public String getDress() {
        return dress;
    }

    public Patient getPatient() {
        return patient;
    }
}
