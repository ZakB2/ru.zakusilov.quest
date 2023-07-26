package ru.zakusilov.quest.resolvers;

public class ResultResolver {
    public static final String WIN = "Ура, капитан %s, ты выиграл!";
    public static final String LOSE = "Увы, капитан %s, ты проиграл...";

    public String getResult(String name, Boolean answer) {
        return Boolean.TRUE.equals(answer) ? String.format(WIN, name) : String.format(LOSE, name);
    }
}