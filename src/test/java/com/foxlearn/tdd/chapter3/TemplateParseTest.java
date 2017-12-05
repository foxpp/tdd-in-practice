package com.foxlearn.tdd.chapter3;

import com.foxlearn.tdd.chapter3.TemplateParse;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by zhaochao on 17/10/24.
 */
public class TemplateParseTest {

    private List<String> parse(String line) {
        return new TemplateParse().parse(line);
    }


    @Test
    public void testEmptyParse() {

        List<String> segs = parse("");

        assertSegs(segs,"");

    }


    @Test
    public void testPlainText() {
        List<String> segs = parse("Test Plain Text");
        assertSegs(segs, "Test Plain Text");
    }



    @Test
    public void testMultiVariables(){
        List<String> segs = parse("${a},${b},${c},${d}");
        assertSegs(segs, "${a}", ",", "${b}",",","${c}",",","${d}");
    }


    void assertSegs(List  actual, Object ... excepteds){
        assertEquals("Number of segs don't match", excepteds.length,actual.size());
        assertEquals(Arrays.asList(excepteds), actual);
    }
}
