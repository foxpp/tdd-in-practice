package com.foxlearn.tdd.chapter3;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by zhaochao on 17/10/17.
 */
public class TestTemplate {

    private Template template;


    @Before
    public void setUp() {

        template = new Template("${a},${b},${c}");

        template.set("a", "1");
        template.set("b", "2");
        template.set("c", "3");



    }



    @Test
    public void testRepeatRender() throws Exception {
        template.set("a","${b}");
        template.set("b","${a}");
        template.set("c","${c}");

        assertEquals("${b},${a},${c}", template.evaluate());
    }


    @Test
    public void multiVals() throws Exception {

        assertEqualsToExcepted("1,2,3");
    }


    @Test
    public void unkonwValTest() throws Exception {
        template.set("unknowed", "111");

        assertEqualsToExcepted("1,2,3");
    }


    private void assertEqualsToExcepted(String excepted) throws Exception {
        assertEquals(excepted, template.evaluate());
    }

    @Test
    public void missingValueRaiseException() throws Exception {
        try {

            new Template("${abc}").evaluate();
            fail("evaluate() should throw a exception if a variable was left without a value");
        } catch (MissingValException e) {

            assertEquals("No value for ${abc}", e.getMessage());
        }
    }


    @Test
    public void templateWith100WordsAnd30Vals() throws Exception {

        long excepted = 200L;
        long time = System.currentTimeMillis();
        template.evaluate();
        time = System.currentTimeMillis() - time;

        assertTrue("templateWith100WordsAnd30Vals less than " + excepted,
                time <= excepted);

    }
}
