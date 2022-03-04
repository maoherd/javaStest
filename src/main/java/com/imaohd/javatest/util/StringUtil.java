package com.imaohd.javatest.util;

public class StringUtil {

    public static String repeat(String str, int times) {

        if (times < 0) {
            throw new IllegalArgumentException("negative times not allowed");
        }

        return String.valueOf(str).repeat(times);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
