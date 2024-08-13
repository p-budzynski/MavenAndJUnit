package pl.kurs.service;

public class MathService {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isOdd(int number) {
        return !isEven(number);
    }

}
