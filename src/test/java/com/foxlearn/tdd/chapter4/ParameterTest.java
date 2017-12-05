package com.foxlearn.tdd.chapter4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhaochao on 17/10/25.
 */
@RunWith(Parameterized.class)
public class ParameterTest {

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        Object[][] data = new Object[][]{

                {0,0,0}
        };
        return Arrays.asList(data);
    }


    public int excepted, input1, input2;

    public ParameterTest(int excepted, int input1, int input2) {
        this.excepted = excepted;
        this.input1 = input1;
        this.input2 = input2;
    }


    @Test
    public void exceuteParaTest(){
        assertEquals(excepted, new Calculator().add(input1, input2));
    }
}
