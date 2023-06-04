package ru.zakusilov.quest.resolvers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultResolverTest {

    private static ResultResolver resultResolver;

    @BeforeAll
    static void setUp() {
        resultResolver = new ResultResolver();
    }

    @ParameterizedTest(name = "Should test correct result with answer {0}")
    @ValueSource(booleans = {true, false})
    void getResult_PassedDifferentAnswers(Boolean answer) {
        String expected;
        if (answer) {
            expected = "Ура, капитан userName, ты выйграл!";
        } else {
            expected = "Увы, капитан userName, ты проиграл...";
        }
        String active = resultResolver.getResult("userName", answer);
        assertEquals(expected, active);
    }
}