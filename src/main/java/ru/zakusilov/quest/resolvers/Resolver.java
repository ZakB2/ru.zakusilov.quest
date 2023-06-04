package ru.zakusilov.quest.resolvers;

import ru.zakusilov.quest.Step;

public abstract class Resolver {
    private Resolver nextSuccessfulResolver;
    private Step step;


    protected Resolver(Step step) {
        this.step = step;
    }

    public Resolver getNextSuccessfulResolver() {
        return nextSuccessfulResolver;
    }

    public void setNextSuccessfulResolver(Resolver nextSuccessfulResolver) {
        this.nextSuccessfulResolver = nextSuccessfulResolver;
    }

    public Step getStep() {
        return step;
    }

    public abstract String getQuestion();
}