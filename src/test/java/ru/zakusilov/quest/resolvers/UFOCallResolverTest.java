package ru.zakusilov.quest.resolvers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zakusilov.quest.Step;

import static org.junit.jupiter.api.Assertions.*;

class UFOCallResolverTest {

    private UFOCallResolver ufoCallResolver;

    @BeforeEach
    void setUp() {
        ufoCallResolver = new UFOCallResolver();
    }

    @Test
    @DisplayName("Should test of constructor parameter")
    void constructorTest_PassedTheStepAsParameter() {
        Step expected = Step.UFO_CALL;
        Step active = ufoCallResolver.getStep();
        assertEquals(expected, active);
    }

    @Test
    @DisplayName("Should test of quest question")
    void getQuestion_PassedAQuestionForTheFirstStep() {
        String expected = "<p>Капитан, внезапно поступил видео-вызов от неопознанного корабля.</p>" +
                "<p>Принять видео-вызов?</p>";
        String active = ufoCallResolver.getQuestion();
        assertEquals(expected, active);
    }
}