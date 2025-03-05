package com.startjava.lession2.method.naming;

public class MethodName {
    public static String getCurrent() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}