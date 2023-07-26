package ru.zakusilov.quest.resolvers;

import ru.zakusilov.quest.Step;

public class TellMeAboutYourselfResolver extends Resolver {

    private static final String QUESTION = "<p>Ты телепортировался и переговоры начались с неожиданного вопроса: " +
            "Кто ты?</p>" + "<p>Так кто же ты, капитан? Расскажешь правду о себе?</p>";

    public TellMeAboutYourselfResolver() {
        super(Step.TELL_ME_ABOUT_YOURSELF);
    }

    @Override
    public String getQuestion() {
        return QUESTION;
    }
}