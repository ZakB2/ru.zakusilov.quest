package ru.zakusilov.quest.resolvers;

import ru.zakusilov.quest.Step;

public class TeleportResolver extends Resolver {

    private static final String QUESTION = "<p>Во время непродолжительного разговора тебе предложили телепортироваться" +
            " на неопознанный корабль.</p>" + "<p>Ты телепортируешься?</p>";

    public TeleportResolver() {
        super(Step.TELEPORT);
    }



    @Override
    public String getQuestion() {
        return QUESTION;
    }
}