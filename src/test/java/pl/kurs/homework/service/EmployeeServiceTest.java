package pl.kurs.homework.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.kurs.homework.exception.NotUniqueResultException;
import pl.kurs.homework.model.Employee;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeService employeeService = new EmployeeService();
    private static List<Employee> employees;

    @BeforeAll
    static void setUp() {
        employees = Arrays.asList(
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
    }

    @Test
    void shouldReturnHighestEarningEmployee() throws NotUniqueResultException {
        //when
        Employee earningEmployee = employeeService.returnHighestEarningEmployee(employees);

        //then
        assertThat(earningEmployee.getSalary()).isEqualTo(6300.0);
    }

    @Test
    void shouldThrowExceptionForEmptyListPassedToMethodReturningHighestEarningEmployee() {
        //when then
        assertThatThrownBy(() -> employeeService.returnHighestEarningEmployee(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Employee list cannot be null or empty.");
    }

    @Test
    void shouldThrowExceptionIfThereIsMoreThanOnePersonWithTheSameHighestEarnings() {
        //given
        List<Employee> personsWithTeSameEarnings = Arrays.asList(
                new Employee("Marek", "Jabłoński", "85010167897", 5100.0, "Developer", "Warszawa"),
                new Employee("Sylwia", "Stępień", "88020256786", 5100.0, "Tester", "Warszawa"));

        //when then
        assertThatThrownBy(() -> employeeService.returnHighestEarningEmployee(personsWithTeSameEarnings))
                .isInstanceOf(NotUniqueResultException.class)
                .hasMessage("More than one employee found with the highest salary.");
    }

    @Test
    void shouldReturnHighestEarningEmployeeFromCity() throws NotUniqueResultException {
        //when
        Employee earningEmployee = employeeService.returnHighestEarningEmployeeFromCity(employees, "Warszawa");

        //then
        assertThat(earningEmployee.getName()).isEqualTo("Izabela");
    }

    @Test
    void shouldThrowExceptionForEmptyListPassedToMethodReturningHighestEarningEmployeeFromCity() {
        //when then
        assertThatThrownBy(() -> employeeService.returnHighestEarningEmployeeFromCity(null, "Warszawa"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Employee list cannot be null or empty.");
    }

    @Test
    void shouldReturnAverageWhenDoesNotFindCityOnListPassedToMethodHighestEarningEmployeeFromCity() {
        //when then
        assertThatThrownBy(() -> employeeService.returnHighestEarningEmployeeFromCity(employees, "Toruń"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("There are no employees from city: Toruń.");
    }

    @Test
    void shouldThrowExceptionIfThereIsMoreThanOneCityWithTheSameHighestEarnings() {
        //given
        List<Employee> personsWithTeSameEarningsFromCity = Arrays.asList(
                new Employee("Marek", "Jabłoński", "85010167897", 5100.0, "Developer", "Warszawa"),
                new Employee("Sylwia", "Stępień", "88020256786", 5100.0, "Tester", "Warszawa"));

        //when then
        assertThatThrownBy(() -> employeeService.returnHighestEarningEmployeeFromCity(personsWithTeSameEarningsFromCity, "Warszawa"))
                .isInstanceOf(NotUniqueResultException.class)
                .hasMessage("More than one employee found with the highest salary from Warszawa.");
    }

    @Test
    void shouldReturnCityWithMostEmployees() throws NotUniqueResultException {
        //when
        String cityWithMostEmployees = employeeService.returnCityWithMostEmployees(employees);

        //then
        assertThat(cityWithMostEmployees).isEqualTo("Warszawa");
    }

    @Test
    void shouldThrowExceptionWhenPassedEmptyListToMethodCityWithMostEmployees() {
        //when then
        assertThatThrownBy(() -> employeeService.returnCityWithMostEmployees(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Employee list cannot be null or empty.");
    }

    @Test
    void shouldThrowExceptionWhenIsMoreThanOneCityWithTheSameLargestNumberOfEmployees() {
        //given
        List<Employee> differentCitySameSalary = Arrays.asList(
                new Employee("Marek", "Jabłoński", "85010167897", 5100.0, "Developer", "Łódź"),
                new Employee("Sylwia", "Stępień", "88020256786", 5100.0, "Tester", "Warszawa"));

        //when then
        assertThatThrownBy(() -> employeeService.returnCityWithMostEmployees(differentCitySameSalary))
                .isInstanceOf(NotUniqueResultException.class)
                .hasMessage("More than one city found with the most employees.");
    }

    @Test
    void shouldReturnAverageSalaryForPosition() {
        //when
        double averageSalary = employeeService.returnAverageSalaryForPosition(employees, "Tester");

        //then
        assertThat(averageSalary).isEqualTo(4800.0);
    }

    @Test
    void shouldThrowExceptionWhenPassedEmptyListToMethodAverageSalaryForPosition() {
        //when then
        assertThatThrownBy(() -> employeeService.returnAverageSalaryForPosition(null, "Tester"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Employee list cannot be null or empty.");
    }

    @Test
    void shouldThrowExceptionWhenDoesNotFindPositionOnListPassedToMethodAverageSalaryForPosition() {
        //when then
        assertThatThrownBy(() -> employeeService.returnAverageSalaryForPosition(employees, "Teacher"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("There are no employees from position: Teacher.");
    }
}
