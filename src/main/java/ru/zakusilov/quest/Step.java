package ru.zakusilov.quest;

public enum Step {
    UFO_CALL (1),
    TELEPORT (2),
    TELL_ME_ABOUT_YOURSELF (3);

    private int stepNumber;

    Step(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public int getStepNumber() {
        return stepNumber;
    }
}