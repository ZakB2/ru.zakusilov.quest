package ru.zakusilov.quest.resolvers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultResolverTest {

    private static ResultResolver resultResolver;

    @BeforeAll
    static void setUp() {
        resultResolver = new ResultResolver();
    }

    @ParameterizedTest(name = "Should test correct result with answer {0}")
    @MethodSource("provideCorrectResultForDifferentAnswers")
    void  getResult_PassedDifferentAnswers(Boolean answer, String expected) {
        String active = resultResolver.getResult("userName", answer);
        assertEquals(expected, active);
    }

    private static List<Arguments> provideCorrectResultForDifferentAnswers() {
        return List.of(
                Arguments.of(true, String.format((ResultResolver.WIN), "userName")),
                Arguments.of(true, String.format((ResultResolver.WIN), "userName"))
        );
    }
}