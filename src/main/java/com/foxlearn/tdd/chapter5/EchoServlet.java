package com.foxlearn.tdd.chapter5;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by zhaochao on 17/10/25.
 */
public class EchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type","text/plain");

        PrintWriter w = response.getWriter();

        Enumeration e = request.getParameterNames();

        while (e.hasMoreElements()){
           String para = String.valueOf(e.nextElement());
            String[] vals = request.getParameterValues(para);

            for (int i = 0; i < vals.length; i++) {
                w.write(para + "=" + vals[i]);
                w.write("\n");
            }
        }

        w.close();
    }
}
