package ru.zakusilov.quest.resolvers;

import ru.zakusilov.quest.Step;

public class UFOCallResolver extends Resolver {

    private static final String QUESTION = "<p>Капитан, внезапно поступил видео-вызов от неопознанного корабля.</p>" +
            "<p>Принять видео-вызов?</p>";

    public UFOCallResolver() {
        super(Step.UFO_CALL);
    }

    @Override
    public String getQuestion() {
        return QUESTION;
    }
}