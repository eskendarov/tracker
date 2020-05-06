package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text1 = new TextReport().generate("Report's name", "Report's body");
        String text2 = new HtmlReport().generate("Report's name", "Report's body");
        String text3 = new JSONReport().generate("Report's name", "Report's body");
        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
    }
}
