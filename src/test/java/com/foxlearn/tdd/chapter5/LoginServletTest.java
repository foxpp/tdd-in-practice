package com.foxlearn.tdd.chapter5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * LoginServlet Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十月 25, 2017</pre>
 */
public class LoginServletTest {

    private static final String CORRECT_USERNAME = "validuser";
    private static final String CORRECT_PWD = "correctpassword";


    LoginServlet servlet;
    FakeAuthService authService;

    MockHttpServletRequest request;
    MockHttpServletResponse response;


    @Before
    public void before() throws Exception {

        authService = new FakeAuthService();
        authService.addUser(CORRECT_USERNAME, CORRECT_PWD);


        servlet = new LoginServlet() {
            @Override
            protected AuthService getAuthService() {
                return authService;
            }
        };

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void validLoginTest() throws ServletException, IOException {

        request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("username", CORRECT_USERNAME);
        request.addParameter("password", CORRECT_PWD);



        servlet.service(request, response);

        Assert.assertEquals("/frontpage", response.getRedirectedUrl());
        Assert.assertEquals("validuser", request.getSession().getAttribute("username"));
    }

    @Test
    public void wrongPwdShouldRedirectToErrorPage() throws ServletException, IOException {

        request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("username", "fox");
        request.addParameter("password", "fox");


        servlet.service(request, response);

        Assert.assertEquals("/invalidlogin", response.getRedirectedUrl());
    }

} 
