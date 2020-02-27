package com.codegym.task.task32.task3211;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Data integrity

*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); // true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        byte[] bytes = byteArrayOutputStream.toByteArray();

        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        String myChecksum = DatatypeConverter.printHexBinary(digest).toLowerCase();

        if(myChecksum.equals(md5))
            return true;
        else return false;
    }
}
