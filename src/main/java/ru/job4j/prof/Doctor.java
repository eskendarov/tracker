package ru.job4j.prof;

public class Doctor extends Profession {
    private String rank;
    private String dress;
    private Patient patient;

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
