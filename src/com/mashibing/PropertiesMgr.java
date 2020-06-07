package com.mashibing;

import java.io.IOException;
import java.util.Properties;

public class PropertiesMgr {
    static Properties props = new Properties();

    static {
        try {
            props.load(PropertiesMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }
}
