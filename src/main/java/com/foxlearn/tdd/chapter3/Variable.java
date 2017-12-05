package com.foxlearn.tdd.chapter3;

import java.util.Map;

/**
 * Created by zhaochao on 17/10/25.
 */
public class Variable implements Segment{

    String name;
    public Variable(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variable variable = (Variable) o;

        return !(name != null ? !name.equals(variable.name) : variable.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String evaluate(Map<String, String> variables) {

        if(!variables.containsKey(name)){
            throw new MissingValException("No value for ${" + name + "}");
        }
        return variables.get(name);
    }
}
