package pl.kurs.service;

import pl.kurs.exception.ProvidedNullArrayException;

public class BigNumberUtils {

    public int sum(int[] elements) throws ProvidedNullArrayException {
        if (elements == null) {
            throw new ProvidedNullArrayException("Elements is null.");
        }
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }
        return sum;
    }

    public int multi(int[] elements) throws ProvidedNullArrayException {
        if (elements == null) {
            throw new ProvidedNullArrayException("Elements is null.");
        }
        int multi = 1;
        for (int i = 0; i < elements.length; i++) {
            multi *= elements[i];
        }
        return multi;
    }

}
