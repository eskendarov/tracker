package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Эскендаров Энвер Асланович");
        student.setGroup("Junior");
        student.setDate("20/04/2020");
        System.out.println(
                "full name: " + student.getFullName()
                        + "\ngroup: " + student.getGroup()
                        + "\ndate: " + student.getDate()
        );
    }
}
