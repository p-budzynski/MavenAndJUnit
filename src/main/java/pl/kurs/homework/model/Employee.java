package pl.kurs.homework.model;

import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String pesel;
    private double salary;
    private String position;
    private String city;

    public Employee() {

    }

    public Employee(String name, String surname, String pesel, double salary, String position, String city) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.salary = salary;
        this.position = position;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return Double.compare(salary, employee.salary) == 0 && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(pesel, employee.pesel) && Objects.equals(position, employee.position) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, pesel, salary, position, city);
    }

    @Override
    public String toString() {
        return name + " " + surname + ", PESEL: " + pesel + ", salary: " + salary +
                ", position: " + position + ", city: " + city;
    }
}
