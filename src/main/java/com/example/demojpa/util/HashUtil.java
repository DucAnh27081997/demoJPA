package com.example.demojpa.util;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HashUtil {

    public static String hash(String value) throws NoSuchAlgorithmException {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        MD5.update(value.getBytes());
        byte[] digest = MD5.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public static String hashWithDate(String value) throws NoSuchAlgorithmException {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyy_HHmmss.SSS");
        return hash(value + sdf.format(new Date()));
    }

    public static String hashWithDate() throws NoSuchAlgorithmException {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyy_HHmmss.SSS");
        return hash(sdf.format(new Date()));
    }

}
