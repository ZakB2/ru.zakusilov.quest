package ru.zakusilov.quest.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zakusilov.quest.User;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestartServletTest {

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

    private RestartServlet restartServlet;

    @Test
    @DisplayName("Should test that the username is got before the session is invalidated, and that all methods " +
            "are executed")
    void doGet_UserNameIsGotBeforeSessionInvalidation() throws ServletException, IOException {
        restartServlet = new RestartServlet();

        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("user")).thenReturn(user);
        when(user.getName()).thenReturn("userName");

        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/quest?name=userName")).thenReturn(requestDispatcher);

        restartServlet.doGet(request, response);

        verify(user).getName();
        assertEquals("userName", user.getName());

        verify(session).invalidate();
        verify(requestDispatcher).forward(request, response);
        assertEquals(request.getServletContext().getRequestDispatcher("/quest?name=userName"), requestDispatcher);
    }
}