package ru.zakusilov.quest.resolvers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zakusilov.quest.Step;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeleportResolverTest {

    private TeleportResolver teleportResolver;

    @BeforeEach
    void setUp() {
        teleportResolver = new TeleportResolver();
    }

    @Test
    @DisplayName("Should test of constructor parameter")
    void constructorTest_PassedTheStepAsParameter() {
        Step expected = Step.TELEPORT;
        Step active = teleportResolver.getStep();
        assertEquals(expected, active);
    }

    @Test
    @DisplayName("Should test of quest question")
    void getQuestion_PassedAQuestionForTheSecondStep() {
        String expected = "<p>Во время непродолжительного разговора тебе предложили телепортироваться" +
                " на неопознанный корабль.</p>" + "<p>Ты телепортируешься?</p>";
        String active = teleportResolver.getQuestion();
        assertEquals(expected, active);
    }
}

