package ru.zakusilov.quest.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zakusilov.quest.User;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestServletTest {

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
    private QuestServlet questServlet;
    private Integer questionNumber;

    @BeforeEach
    void setUp() {
        questServlet = new QuestServlet();
    }

    @Test
    @DisplayName("Should test that a valid attributes are passed and set to the session, and that all methods " +
            "are executed")
    void doGet_PassedValidAttribute() throws ServletException, IOException {
        when(request.getSession()).thenReturn(session);

        when(session.getAttribute("user")).thenReturn(user);
        when(session.getAttribute("questionNumber")).thenReturn(questionNumber);

        when(request.getServletContext()).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher("/quest.jsp")).thenReturn(requestDispatcher);

        questServlet.doGet(request, response);

        verify(session).getAttribute("user");
        assertEquals(user, session.getAttribute("user"));
        verify(session).setAttribute("user", questServlet.getUserByName(request, user));

        verify(session).getAttribute("questionNumber");
        assertEquals(questionNumber, session.getAttribute("questionNumber"));
        verify(session).setAttribute("questionNumber", questServlet.getQuestionNumber(questionNumber));

        verify(requestDispatcher).forward(request, response);
    }

    @ParameterizedTest(name = "Should test that new user will be created with passed name")
    @NullSource
    void getUserWithName_PassedNullUser(User user) {
        assertNull(user);

        when(request.getParameter("name")).thenReturn("userName");
        String actualName = request.getParameter("name");
        User actualUser = new User(actualName);
        assertNotEquals(user, actualUser);

        User expectedUser = new User("userName");
        assertEquals(expectedUser, actualUser);
    }

    @ParameterizedTest(name = "Should test correct question number {0}")
    @MethodSource("provideCorrectNumberForNewQuestion")
    void getQuestionNumber_PassedDifferentQuestionsNumbers(Integer questionNumber, Integer expected) {
        int actual = questServlet.getQuestionNumber(questionNumber);
        assertEquals(expected, actual);
    }

    private static List<Arguments> provideCorrectNumberForNewQuestion() {
        return List.of(
                Arguments.of(null, 1),
                Arguments.of(1, 2),
                Arguments.of(2, 3)
        );
    }
}