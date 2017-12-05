package com.foxlearn.tdd.chapter5;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhaochao on 17/10/25.
 */
public class TestEchoServlet {

    @Test
    public void testEchoingParametersWithMulitpleVals() throws IOException {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        request.addParameter("p1","v1");
        request.addParameter("p2","v2");
        request.addParameter("p3","v3");
        request.addParameter("p4", "v4");


        new EchoServlet().doGet(request, response);

        String[] lines = response.getContentAsString().split("\n");

        assertEquals("Excepted lines is 3", 4, lines.length);
        assertEquals("p1=v1",lines[0]);
        assertEquals("p2=v2",lines[1]);
        assertEquals("p3=v3",lines[2]);
        assertEquals("p4=v4",lines[3]);

    }
}
