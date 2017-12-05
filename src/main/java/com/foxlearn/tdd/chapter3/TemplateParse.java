package com.foxlearn.tdd.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhaochao on 17/10/24.
 */
public class TemplateParse {

    static String variablePattern = "\\$\\{[^.*]\\}";

    public List<Segment> parseSegments(String template){
        List<Segment> segments = new ArrayList<Segment>();
        List<String> strings = parse(template);
        for (String s: strings) {
            if(Template.isVariable(s)){
                String name = s.substring(2, s.length()-1);
                segments.add(new Variable(name));
            }else{
                segments.add(new PlainText(s));
            }
        }
        return segments;
    }

    public List<String> parse(String template){
        if(template.isEmpty()){
            return Collections.singletonList("");
        }

        List<String> segs = new ArrayList<String>();
        Matcher m = Pattern.compile(variablePattern).matcher(template);
        int plainWordIndex = 0;
        while (m.find()){
            if(plainWordIndex != m.start() ) {
                segs.add(template.substring(plainWordIndex, m.start())); //normal word
            }

            segs.add(template.substring(m.start(),m.end()));

            plainWordIndex = m.end();
        }

        if(plainWordIndex < template.length()){
            segs.add(template.substring(plainWordIndex));
        }
        return segs;
    }

}
