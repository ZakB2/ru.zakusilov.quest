package ru.zakusilov.quest.resolvers;

public class ResultResolver {
    private static final String WIN = "Ура, капитан %s, ты выиграл!";
    private static final String LOSE = "Увы, капитан %s, ты проиграл...";

    public String getResult(String name, Boolean answer) {
        return Boolean.TRUE.equals(answer) ? String.format(WIN, name) : String.format(LOSE, name);
    }
}