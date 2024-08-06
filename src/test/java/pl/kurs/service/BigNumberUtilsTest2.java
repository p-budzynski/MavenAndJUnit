package pl.kurs.service;

import org.junit.jupiter.api.*;
import pl.kurs.exception.ProvidedNullArrayException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class BigNumberUtilsTest2 {

    private final BigNumberUtils bigNumberUtils = new BigNumberUtils();

    @BeforeEach
    void init() {
        System.out.println("Wywoluje sie przed kazdym testem");
    }

    @AfterEach
    void exit() {
        System.out.println("Wywoluje sie po kazdym tescie");
    }

    @BeforeAll
    static void init2() {
        System.out.println("Wywolam sie tylko przed pierwszym testem");
    }

    @AfterAll
    static void exit2() {
        System.out.println("Wywolam sie po wszystkich testach");
    }

    @Test
    void shouldCalculateSum() throws ProvidedNullArrayException {
        //given - sekcja w ktorej przygotowujemy dane do testow
        int[] elements = {1, 5, 8, 4, 6, -5, -7};

        //when - tutaj nastepuje odpalenie wlasciciwej metody ktora chcemy przetestowac
        int result = bigNumberUtils.sum(elements);

        //then - weryfikacja rezultatu
        //12
        assertThat(result).isEqualTo(12);
    }

    @Test
    void shouldCalculateMulti() throws ProvidedNullArrayException {
        //given
        int[] elements = {1, 5, 3};

        //when
        int result = bigNumberUtils.multi(elements);

        //then
        //15
        assertThat(result).isEqualTo(15);
    }

    @Test
    void shouldThrowExceptionWhenArrayIsNullOnSumCalculations() {
        //when then
        assertThatThrownBy(() -> bigNumberUtils.sum(null))
                .isInstanceOf(ProvidedNullArrayException.class)
                .hasMessage("Elements is null.");
    }

    @Test
    void shouldThrowExceptionWhenArrayIsNullOnMultiCalculations() {
        //when then
        assertThatThrownBy(() -> bigNumberUtils.multi(null))
                .isInstanceOf(ProvidedNullArrayException.class)
                .hasMessage("Elements is null.");

    }
}
