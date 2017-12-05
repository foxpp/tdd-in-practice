package com.foxlearn.tdd.chapter4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Calculator Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>十月 25, 2017</pre>
 */
public class CalculatorTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    //faking it  + triangulation
    @Test
    public void testAdd(){
        Assert.assertEquals(2, new Calculator().add(1,1));
        Assert.assertEquals(10, new Calculator().add(5,5));
    }

} 
