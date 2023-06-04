package ru.zakusilov.quest.resolvers;

public class ResultResolver {

    public String getResult(String name, Boolean answer) {
        String result;
        if (Boolean.TRUE.equals(answer)) {
            result = "Ура, капитан " + name + ", ты выйграл!";
        } else {
            result = "Увы, капитан " + name + ", ты проиграл...";
        }
        return result;
    }
}