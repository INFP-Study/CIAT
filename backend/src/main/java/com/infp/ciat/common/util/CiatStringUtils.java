package com.infp.ciat.common.util;

import org.springframework.stereotype.Component;

@Component
public class CiatStringUtils {

    public static String StringNullToEmpty(String str) {
        if(str == null || str.trim().isEmpty()) {
            return "";
        }
        return str;
    }

}
