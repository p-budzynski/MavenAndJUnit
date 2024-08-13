package pl.kurs.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    private final MathService mathService = new MathService();

    @ParameterizedTest
    @MethodSource("provideArgumentsForIsEven")
    void shouldReturnResultForIsEven(int number, boolean expected) {
        //when then
        assertEquals(mathService.isEven(number), expected);
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForIsOdd")
    void shouldReturnResultForIsOdd(int number, boolean expected) {
        //when then
        assertEquals(mathService.isOdd(number), expected);
    }

    private static Stream<Arguments> provideArgumentsForIsEven() {
        return Stream.of(
                Arguments.of(9, false),
                Arguments.of(2, true),
                Arguments.of(158, true),
                Arguments.of(177, false)
        );
    }

    private static Stream<Arguments> provideArgumentsForIsOdd() {
        return Stream.of(
                Arguments.of(7, true),
                Arguments.of(1983, true),
                Arguments.of(-144, false),
                Arguments.of(0, false)
        );
    }

}