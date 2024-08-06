package pl.kurs.homework.service;

import pl.kurs.homework.exception.NotUniqueResultException;
import pl.kurs.homework.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    public Employee returnHighestEarningEmployee(List<Employee> employees) throws NotUniqueResultException {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty.");
        }
        Optional<Employee> highestEarningEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));

        double highestSalary = highestEarningEmployee.get().getSalary();
        long count = employees.stream()
                .filter(employee -> employee.getSalary() == highestSalary)
                .count();

        if (count > 1) {
            throw new NotUniqueResultException("More than one employee found with the highest salary.");
        }

        return highestEarningEmployee.get();
    }

    public Employee returnHighestEarningEmployeeFromCity(List<Employee> employees, String city) throws NotUniqueResultException {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty.");
        }

        if (employees.stream()
                .noneMatch(employee -> city.equalsIgnoreCase(employee.getCity()))) {
            throw new IllegalArgumentException("There are no employees from city: " + city + ".");
        }

        Optional<Employee> highestEarningEmployee = employees.stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase(city))
                .max(Comparator.comparing(Employee::getSalary));

        double highestSalary = highestEarningEmployee.get().getSalary();
        long count = employees.stream()
                .filter(employee -> employee.getCity().equalsIgnoreCase(city))
                .filter(employee -> employee.getSalary() == highestSalary)
                .count();

        if (count > 1) {
            throw new NotUniqueResultException("More than one employee found with the highest salary from " + city + ".");
        }

        return highestEarningEmployee.get();
    }

    public String returnCityWithMostEmployees(List<Employee> employees) throws NotUniqueResultException {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty.");
        }
        Map<String, Long> cityWorkersCounter = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));

        long maxValue = cityWorkersCounter.values().stream()
                .max(Long::compare)
                .orElseThrow();

        long count = cityWorkersCounter.values().stream()
                .filter(value -> value == maxValue)
                .count();

        if (count > 1) {
            throw new NotUniqueResultException("More than one city found with the most employees.");
        }

        return cityWorkersCounter.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();
    }

    public double returnAverageSalaryForPosition(List<Employee> employees, String position) {
        if (employees == null || employees.isEmpty()) {
            throw new IllegalArgumentException("Employee list cannot be null or empty.");
        }

        if (employees.stream()
                .noneMatch(employee -> position.equalsIgnoreCase(employee.getPosition()))) {
            throw new IllegalArgumentException("There are no employees from position: " + position + ".");
        }

        return employees.stream()
                .filter(employee -> employee.getPosition().equalsIgnoreCase(position))
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}