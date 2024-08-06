package pl.kurs.app;

import pl.kurs.service.Capitalizer;

public class Main {
    public static void main(String[] args) {
        Capitalizer capitalizer = new Capitalizer();

        System.out.println(capitalizer.capitalize("tekst"));
    }
}