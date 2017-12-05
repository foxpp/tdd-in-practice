package com.foxlearn.tdd.chapter3;

import com.foxlearn.tdd.chapter3.Variable;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaochao on 17/10/25.
 */
public class TestVariableSeg {

    @Test
    public  void testEvaluatesToItsValue(){
        Map<String,String> vars = new HashMap<>();
        vars.put("testname","testval");

        Assert.assertEquals("testval", new Variable("testname").evaluate(vars));
    }
}
