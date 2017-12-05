package com.foxlearn.tdd.chapter3;

import com.foxlearn.tdd.chapter3.PlainText;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaochao on 17/10/25.
 */
public class TestPlainTextSegment {

    @Test
    public void plainTextEvaluatesAsIs(){
        Map<String,String> vars = new HashMap<>();
        String text = "hi abc";
        Assert.assertEquals(text, new PlainText(text).evaluate(vars));
    }
}
