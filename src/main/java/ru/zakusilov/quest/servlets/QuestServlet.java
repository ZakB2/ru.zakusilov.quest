package ru.zakusilov.quest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.zakusilov.quest.Step;
import ru.zakusilov.quest.User;
import ru.zakusilov.quest.resolvers.*;

import java.io.IOException;

public class QuestServlet extends HttpServlet {
    private Resolver resolver;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        user = getUserWithName(request, user);
        session.setAttribute("user", user);

        Integer questionNumber = (Integer) session.getAttribute("questionNumber");
        questionNumber = getQuestionNumber(questionNumber);
        session.setAttribute("questionNumber", questionNumber);

        Resolver ufoCallResolver = new UFOCallResolver();
        Resolver teleportResolver = new TeleportResolver();
        Resolver tellMeAboutYourselfResolver = new TellMeAboutYourselfResolver();

        ufoCallResolver.setNextResolver(teleportResolver);
        teleportResolver.setNextResolver(tellMeAboutYourselfResolver);

        setResolver(session, questionNumber, ufoCallResolver);
        session.setAttribute("resolver", resolver);

        setRedirect(request, response, session);
    }

    User getUserWithName(HttpServletRequest request, User user) {
        if (user == null) {
            String name = request.getParameter("name");
            user = new User(name);
        }
        return user;
    }

    Integer getQuestionNumber(Integer questionNumber) {
        if (questionNumber == null) {
            questionNumber = 1;
        } else {
            questionNumber += 1;
        }
        return questionNumber;
    }

    void setResolver(HttpSession session, Integer questionNumber, Resolver ufoCallResolver) {
        if (questionNumber == Step.UFO_CALL.getStepNumber()) {
            resolver = ufoCallResolver;
        } else {
            resolver = (Resolver) session.getAttribute("resolver");
            resolver = resolver.getNextResolver();
        }
    }

    private void setRedirect(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        if (resolver != null) {
            request.getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
        } else {
            String answer = "true";
            session.setAttribute("answer", answer);
            request.getServletContext().getRequestDispatcher("/questResult").forward(request, response);
        }
    }
}