package pl.kurs.homework.app;

import pl.kurs.homework.exception.NotUniqueResultException;
import pl.kurs.homework.model.Employee;
import pl.kurs.homework.service.EmployeeService;

import java.util.Arrays;
import java.util.List;

public class EmployeeRunner {
    public static void main(String[] args) throws NotUniqueResultException {
        List<Employee> employees = Arrays.asList(
                new Employee("Jan", "Kowalski", "90010112345", 5000.0, "Developer", "Warszawa"),
                new Employee("Anna", "Nowak", "92020254324", 4500.0, "Tester", "Kraków"),
                new Employee("Piotr", "Wiśniewski", "88030367893", 5500.0, "Manager", "Gdańsk"),
                new Employee("Katarzyna", "Wójcik", "85040456782", 4800.0, "Developer", "Warszawa"),
                new Employee("Michał", "Kowalczyk", "94050512345", 5200.0, "Tester", "Kraków"),
                new Employee("Agnieszka", "Kamińska", "89060654326", 6000.0, "Manager", "Gdańsk"),
                new Employee("Tomasz", "Lewandowski", "87070767897", 5300.0, "Developer", "Warszawa"),
                new Employee("Magdalena", "Zielińska", "95080856786", 4700.0, "Tester", "Kraków"),
                new Employee("Marcin", "Szymański", "82090912345", 5800.0, "Manager", "Gdańsk"),
                new Employee("Joanna", "Woźniak", "83010154326", 5100.0, "Developer", "Warszawa"),
                new Employee("Paweł", "Dąbrowski", "96020267899", 4900.0, "Tester", "Kraków"),
                new Employee("Ewa", "Kozłowska", "91030356780", 6200.0, "Manager", "Gdańsk"),
                new Employee("Andrzej", "Jankowski", "84040412345", 5000.0, "Developer", "Warszawa"),
                new Employee("Dorota", "Mazur", "93050554324", 4600.0, "Tester", "Kraków"),
                new Employee("Rafał", "Krawczyk", "97060667891", 5700.0, "Manager", "Gdańsk"),
                new Employee("Izabela", "Zając", "86070756788", 5400.0, "Developer", "Warszawa"),
                new Employee("Grzegorz", "Król", "92080812345", 4800.0, "Tester", "Kraków"),
                new Employee("Alicja", "Wieczorek", "89090954324", 6300.0, "Manager", "Gdańsk"),
                new Employee("Marek", "Jabłoński", "85010167897", 5100.0, "Developer", "Warszawa"),
                new Employee("Sylwia", "Stępień", "88020256786", 4900.0, "Tester", "Warszawa"));

        EmployeeService service = new EmployeeService();

        System.out.println(service.returnHighestEarningEmployee(employees));
        System.out.println(service.returnHighestEarningEmployeeFromCity(employees, "Warszawa"));
        System.out.println(service.returnCityWithMostEmployees(employees));
        System.out.println(service.returnAverageSalaryForPosition(employees, "Tester"));

    }
}
