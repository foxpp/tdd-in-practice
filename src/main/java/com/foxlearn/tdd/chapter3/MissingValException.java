package com.foxlearn.tdd.chapter3;

/**
 * Created by zhaochao on 17/10/24.
 */
public class MissingValException extends  RuntimeException{
    public MissingValException(String msg) {
        super(msg);
    }
}
