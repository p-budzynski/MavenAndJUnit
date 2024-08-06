package pl.kurs.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.kurs.exception.ProvidedNullArrayException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigNumberUtilsTest {
    private final BigNumberUtils bigNumberUtils = new BigNumberUtils();

    @Test
    void shouldCalculateSum() throws ProvidedNullArrayException {
        //given - sekcja w ktorej przygotowujemy dane do testow
        int[] elements = {1, 5, 8, 4, 6, -5, -7};

        //when - tutaj nastepuje odpalenie wlasciciwej metody ktora chcemy przetestowac
        int result = bigNumberUtils.sum(elements);

        //then - weryfikacja rezultatu
        assertEquals(12, result);
    }

    @Test
    void shouldCalculateMulti() throws ProvidedNullArrayException {
        //given
        int[] elements = {1, 5, 3};

        //when
        int result = bigNumberUtils.multi(elements);

        //then
        assertEquals(15, result);
    }

    @Test
    void shouldThrowExceptionWhenArrayIsNullOnSumCalculations() {
        //when then
        Assertions.assertThrows(ProvidedNullArrayException.class, () -> bigNumberUtils.sum(null));
    }

    @Test
    void shouldThrowExceptionWhenArrayIsNullOnMultiCalculations() {
        //when then
        Assertions.assertThrows(ProvidedNullArrayException.class, () -> bigNumberUtils.multi(null));
    }
}
