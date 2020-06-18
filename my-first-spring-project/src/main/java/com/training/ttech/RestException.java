package com.training.ttech;


public class RestException extends Exception {

    private final String msg;

    public RestException(final String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
