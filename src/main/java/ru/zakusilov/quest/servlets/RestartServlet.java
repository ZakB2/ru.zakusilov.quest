package ru.zakusilov.quest.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.zakusilov.quest.User;

import java.io.IOException;

public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        String name = user.getName();

        session.invalidate();
        request.getServletContext().getRequestDispatcher("/quest?name=" + name).forward(request, response);
    }
}