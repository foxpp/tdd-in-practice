package com.foxlearn.tdd.chapter3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhaochao on 17/10/17.
 */
public class Template {
    String template;
    Map<String, String> valMaps = new HashMap<String, String>();

    TemplateParse templateParse = new TemplateParse();

    public Template(String template) {
        this.template = template;
    }

    public void set(String key, String val) {
        valMaps.put(key, val);
    }

    public String evaluate() throws Exception {
        String res = replaceVariables();
        return res;
    }

    private String replaceVariables() {

        List<Segment> segs = templateParse.parseSegments(template);
        return concatenate(segs);
    }

    private String concatenate(List<Segment> segs) {
        StringBuilder result = new StringBuilder();
        for (Segment seg : segs) {
            result.append(seg.evaluate(valMaps));
        }
        return result.toString();
    }


     static public boolean isVariable(String  seg) {
        return seg.startsWith("${") && seg.endsWith("}");
    }


}
