package com.camping.dev.util;

public interface BCryptUtil {

    public String encrypt(String password);

    public boolean isMatch(String password, String hashed);

}
