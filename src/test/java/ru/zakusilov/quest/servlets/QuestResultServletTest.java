package ru.zakusilov.quest.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zakusilov.quest.User;
import ru.zakusilov.quest.resolvers.ResultResolver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuestResultServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletContext servletContext;
    @Mock
    private RequestDispatcher requestDispatcher;
    @Mock
    private User user;
    private QuestResultServlet questResultServlet;
    private ResultResolver resultResolver;
    private Boolean answer;

    @Test
    void doGet_PassedValidAttribute() throws ServletException, IOException {
        questResultServlet = new QuestResultServlet();
        resultResolver = new ResultResolver();

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("user")).thenReturn(user);
        when(session.getAttribute("answer")).thenReturn(answer);

        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/questResult.jsp")).thenReturn(requestDispatcher);

        questResultServlet.doGet(request, response);

        verify(session).getAttribute("user");
        assertEquals(user, session.getAttribute("user"));
        verify(session).getAttribute("answer");
        assertEquals(answer, session.getAttribute("answer"));
        String result = resultResolver.getResult(user.getName(), answer);
        verify(session).setAttribute("result", result);

        verify(requestDispatcher).forward(request, response);
        assertEquals(request.getServletContext().getRequestDispatcher("/questResult.jsp"), requestDispatcher);
    }
}