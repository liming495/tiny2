package com.guppy.auth.utils;

/**
 * TODO
 *
 * @author Guppy
 */
public class UUID {
    public static String uuid32 () {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}
