package ru.zakusilov.quest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.zakusilov.quest.User;
import ru.zakusilov.quest.resolvers.ResultResolver;

import java.io.IOException;

public class QuestResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        boolean answer = Boolean.parseBoolean((String) session.getAttribute("answer"));

        ResultResolver resultResolver = new ResultResolver();
        String result = resultResolver.getResult(user.getName(), answer);
        session.setAttribute("result", result);
        request.getServletContext().getRequestDispatcher("/questResult.jsp").forward(request, response);
    }
}