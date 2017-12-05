package com.foxlearn.tdd.chapter5;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaochao on 17/10/25.
 */
public class LoginServlet extends HttpServlet{

    protected AuthService getAuthService(){
        return null;
    }

    @Override
    protected void service(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {

        String user = request.getParameter("username");
        String pwd = request.getParameter("password");

        if(getAuthService().isValidLogin(user,pwd)){
            response.sendRedirect("/frontpage");
            request.getSession().setAttribute("username", user);
        }else{
            response.sendRedirect("/invalidlogin");
        }
    }
}
