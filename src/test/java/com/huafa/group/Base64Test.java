package com.huafa.group;

import java.util.Base64;

/**
 * @author: lhw
 * @date: 2021/6/30 下午4:54
 **/
public class Base64Test {

    public static void main(String[] args) throws Exception {
        String a = "23asdsdasdsw22@#";
        String b = new String(Base64.getEncoder().encode(a.getBytes("UTF-8")), "utf-8");
        System.out.println("base64 加密后内容: " + b);
        String c = new String(Base64.getDecoder().decode(b.getBytes("utf-8")), "utf-8");
        System.out.println("base64 解密后内容: " + c);

    }
}
