package com.ardakaplan.rdalibrary.helpers;

import org.apache.commons.codec.binary.Base64;

public class RDABase64CoderHelper {

    private RDABase64CoderHelper() {
    }

    public static String encode(String text) {

        return new String(Base64.encodeBase64(text.getBytes()));
    }

    public static String decode(String encodedText) {

        return new String(Base64.decodeBase64(encodedText.getBytes()));
    }
}