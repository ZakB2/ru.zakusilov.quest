package ru.zakusilov.quest.resolvers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.zakusilov.quest.Step;

import static org.junit.jupiter.api.Assertions.*;

class TellMeAboutYourselfResolverTest {

    private TellMeAboutYourselfResolver tellMeAboutYourselfResolver;

    @BeforeEach
    void setUp() {
        tellMeAboutYourselfResolver = new TellMeAboutYourselfResolver();
    }

    @Test
    @DisplayName("Should test of constructor parameter")
    void constructorTest_PassedTheStepAsParameter() {
        Step expected = Step.TELL_ME_ABOUT_YOURSELF;
        Step active = tellMeAboutYourselfResolver.getStep();
        assertEquals(expected, active);
    }

    @Test
    @DisplayName("Should test of quest question")
    void getQuestion_PassedAQuestionForTheThirdStep() {
        String expected = "<p>Ты телепортировался и переговоры начались с неожиданного вопроса: " +
                "Кто ты?</p>" + "<p>Так кто же ты, капитан? Расскажешь правду о себе?</p>";
        String active = tellMeAboutYourselfResolver.getQuestion();
        assertEquals(expected, active);
    }
}