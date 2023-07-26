package ru.zakusilov.quest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class StepTest {

    @ParameterizedTest(name = "Should test that Step enum is not null")
    @EnumSource(Step.class)
    void testEnumSource(Step step) {
        assertNotNull(step);
    }

    @ParameterizedTest(name = "Should test that step number {0} equals Step enum ordinal")
    @EnumSource(Step.class)
    void constructor_PassedOrdinalAsStepNumber(Step step) {
        int expected = step.ordinal() + 1;
        int active = step.getStepNumber();
        assertEquals(expected, active);
    }

    @ParameterizedTest(name = "Should test that step number {0} is not 0")
    @EnumSource(Step.class)
    void constructor_PassedZeroAsStepNumber(Step step) {
        int unexpected = 0;
        int actual = step.getStepNumber();
        assertNotEquals(unexpected, actual);
    }
}