package com.foxlearn.tdd.chapter3;

import java.util.Map;

/**
 * Created by zhaochao on 17/10/25.
 */
public class PlainText implements Segment{

    String text;
    public PlainText(String text) {
        this.text = text;
    }

    public void appendTo(StringBuilder result, Map valMap) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlainText plainText = (PlainText) o;

        return !(text != null ? !text.equals(plainText.text) : plainText.text != null);

    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    public String evaluate(Map<String, String> variables) {
        return text;
    }
}
