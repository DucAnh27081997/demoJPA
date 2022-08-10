package com.example.demojpa.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    public static String hash(String value) throws NoSuchAlgorithmException {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        MD5.update(value.getBytes());
        byte[] digest = MD5.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

}
