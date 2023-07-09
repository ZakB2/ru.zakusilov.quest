package ru.zakusilov.quest.resolvers;

import ru.zakusilov.quest.Step;

public abstract class Resolver {
    private Resolver nextResolver;
    private Step step;


    protected Resolver(Step step) {
        this.step = step;
    }

    public Resolver getNextResolver() {
        return nextResolver;
    }

    public void setNextResolver(Resolver nextResolver) {
        this.nextResolver = nextResolver;
    }

    public Step getStep() {
        return step;
    }

    public abstract String getQuestion();
}