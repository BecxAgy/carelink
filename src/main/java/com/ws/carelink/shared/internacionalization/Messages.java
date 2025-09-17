package com.ws.carelink.shared.internacionalization;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public final class Messages {

    private static final ResourceBundle MSGS = ResourceBundle.getBundle("mensagens");

    private Messages() {
    }

    public static String get(String key) {
        return MSGS.getString(key);
    }

    public static String get(String key, Object... args) {
        return MessageFormat.format(get(key), args);
    }
}