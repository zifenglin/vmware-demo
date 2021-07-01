package com.huafa.group;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author: lhw
 * @date: 2021/6/30 下午5:18
 **/
public class RSATest {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        String priKey = new String(Base64.getEncoder().encode(privateKey.getEncoded()), "UTF-8");
        String pubKey = new String(Base64.getEncoder().encode(publicKey.getEncoded()), "UTF-8");

//        System.out.println("公钥:  " + pubKey);
//        System.out.println("私钥:  " + priKey);
//
//        testEncode();
//        testDencode();
        sign();
        verify();

    }

    public static void testEncode() throws Exception {
        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjNkmJ4e/0YNsDSRZVqPEqY2F7n3HReRIz8+/p+/w/4AASg5w0NE6SLJNlA2TMZTwMHew9CnoDBRDh70qQIkft2252++RqjOqnj+C+cBxjiMW6Zykz8/1rbexFVJJ2tVjn/mNhkXORAtt+lMHv8bK+qf5U2dMoTJ/JIhGIfjSIAwIDAQAB";
        String str = "aabbccddee123";

        RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(pubKey)));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        String encodeStr = new String(Base64.getEncoder().encode(cipher.doFinal(str.getBytes("utf-8"))), "utf-8");
        System.out.println(encodeStr);
    }

    public static void testDencode() throws Exception {
        String priKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKM2SYnh7/Rg2wNJFlWo8SpjYXufcdF5EjPz7+n7/D/gABKDnDQ0TpIsk2UDZMxlPAwd7D0KegMFEOHvSpAiR+3bbnb75GqM6qeP4L5wHGOIxbpnKTPz/Wtt7EVUkna1WOf+Y2GRc5EC236Uwe/xsr6p/lTZ0yhMn8kiEYh+NIgDAgMBAAECgYBh0xsWws5hKmB7QqZZZ25NWs3GHBZLWIb5jr+A/mD+JBPHBQ1uGN/zKzaZOASFojPwi0rad1oUT0gEM7n8VB/J0vDHeIVZkkSFkhOmeaafkrYsIjHbHQKbGUU0fC1FIcwx0jhOO/itzD3++JQjDbv7aHb26QmXrpS9DGDpECTq2QJBANf8LImdfZ/ISp6XWSjUFIiKt7B+uyorLMpmuk7fOVZ6HDGNMUFFCIV4yQAR55JQCdjd3UdQ/dkcs0FN/Sph8McCQQDBcyypPMBqrGQHfuXVbWIYDWXqRnbXMj9/9KLLWOP5dh0ZTTBYD8K9lLAaSCoyinXBC+3aGkBztG+KRMATrKrlAkA73/SY0cgZm3TUMjDNWL24fHwfuYI5Vm68TW4on0lN59wZAIM/DNwn5CwUkOIZdYbFT/wf4Rv+LC6lU/Fy5mPRAkBC9TaULW78fUbyQT4ULZQydxC7kkA4JDBOfcKLV+0wv207ALinAm2JaRm7Pxc7/yja9OITB9sfMWkaFsnVBYLxAkAmC52JP3AuTPaWKjtkjWH7TjpEqwZyrMBBVR7D+aQMrKW2gyv78XYA1Cg/e84MoPPmE25uPL9XOy43TM1ZSrX+";
        String str = "gODNpOLenRW/epudzHEkyPPM4fxSkO3ivWolQxERjiA1aT2hpgKkDZ2kjYqPc7qlmAxoWlO4rHDRzWeZh1GF73nTnIOCpDDb4DU0i7I7uAhUWZ1x6wNdlR7P0M2O0wugqUlGS5D+e2MR08WT5FV0ss14XpMZu54xIFhDZuc76Q0=";

        RSAPrivateKey privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(priKey)));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        String dencode = new String(cipher.doFinal(Base64.getDecoder().decode(str)));
        System.out.println(dencode);
    }

    public static void sign() throws Exception {
        String priKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAKM2SYnh7/Rg2wNJFlWo8SpjYXufcdF5EjPz7+n7/D/gABKDnDQ0TpIsk2UDZMxlPAwd7D0KegMFEOHvSpAiR+3bbnb75GqM6qeP4L5wHGOIxbpnKTPz/Wtt7EVUkna1WOf+Y2GRc5EC236Uwe/xsr6p/lTZ0yhMn8kiEYh+NIgDAgMBAAECgYBh0xsWws5hKmB7QqZZZ25NWs3GHBZLWIb5jr+A/mD+JBPHBQ1uGN/zKzaZOASFojPwi0rad1oUT0gEM7n8VB/J0vDHeIVZkkSFkhOmeaafkrYsIjHbHQKbGUU0fC1FIcwx0jhOO/itzD3++JQjDbv7aHb26QmXrpS9DGDpECTq2QJBANf8LImdfZ/ISp6XWSjUFIiKt7B+uyorLMpmuk7fOVZ6HDGNMUFFCIV4yQAR55JQCdjd3UdQ/dkcs0FN/Sph8McCQQDBcyypPMBqrGQHfuXVbWIYDWXqRnbXMj9/9KLLWOP5dh0ZTTBYD8K9lLAaSCoyinXBC+3aGkBztG+KRMATrKrlAkA73/SY0cgZm3TUMjDNWL24fHwfuYI5Vm68TW4on0lN59wZAIM/DNwn5CwUkOIZdYbFT/wf4Rv+LC6lU/Fy5mPRAkBC9TaULW78fUbyQT4ULZQydxC7kkA4JDBOfcKLV+0wv207ALinAm2JaRm7Pxc7/yja9OITB9sfMWkaFsnVBYLxAkAmC52JP3AuTPaWKjtkjWH7TjpEqwZyrMBBVR7D+aQMrKW2gyv78XYA1Cg/e84MoPPmE25uPL9XOy43TM1ZSrX+";
        String str = "aadfdfbb123";

        RSAPrivateKey privateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(priKey)));

        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(str.getBytes("utf-8"));
        String sign = new String(Base64.getEncoder().encode(signature.sign()), "utf-8");
        System.out.println(sign);
    }

    public static void verify() throws Exception {
        String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjNkmJ4e/0YNsDSRZVqPEqY2F7n3HReRIz8+/p+/w/4AASg5w0NE6SLJNlA2TMZTwMHew9CnoDBRDh70qQIkft2252++RqjOqnj+C+cBxjiMW6Zykz8/1rbexFVJJ2tVjn/mNhkXORAtt+lMHv8bK+qf5U2dMoTJ/JIhGIfjSIAwIDAQAB";
        String sign = "AfoeHTUwidcdE/xN16yP8Q6oe1nbqA6gcGrxyQ+C0/hNnEV6MCFx6E70FKRCN6yLJjn/zLAtWLuD6hDpStzWYn5Fy3bmZL47ZL6nAWzIwukiSAyVdzbCd2ggjNV2ouO+GpELOJU4totLFdcNsMuP8Pa3y+KCpW+nZ1Tx3OS7u24=";
        String str = "aadfdfbb123";

        RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(pubKey)));
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.update(str.getBytes("utf-8"));
        boolean blag = signature.verify(Base64.getDecoder().decode(sign));
        System.out.println(blag);
    }
}
