package com.foxlearn.tdd.chapter3;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by zhaochao on 17/10/24.
 */
public class LearnRegexTest {


    @Test
    public void testFindStartAndEnd(){

        String line = "fox is foxse";
        String reg = "(fox)";
        Matcher m = Pattern.compile(reg).matcher(line);
        assertTrue(m.find());

        assertEquals("Wrong start", 0, m.start());
        assertEquals("Wrong end", 3, m.end());

        assertTrue(m.find());

        assertEquals("Wrong start", 7, m.start());
        assertEquals("Wrong end", 10, m.end());

        assertFalse(m.find());

    }
}
