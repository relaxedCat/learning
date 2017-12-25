package com.fuiou.util;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class AesUtil {
    private static BASE64Encoder base64Encoder;
    private static BASE64Decoder base64Decoder;
    private static IvParameterSpec iv;
    private static String CipherType = "AES/CBC/PKCS5Padding"; //"算法/模式/补码方式

    static {
        base64Decoder = new BASE64Decoder();
        base64Encoder = new BASE64Encoder();
        iv = new IvParameterSpec("0102030405060708".getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
    }

    // 加密
    public  static  synchronized String Encrypt(String sSrc,String sKey) throws Exception {
        if (sKey == null) {
            System.out.print("Key为空null");
            return null;
        }
//        判断Key是否为16位
        if (sKey.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(CipherType);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));

        return base64Encoder.encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    
    // 解密
    public static synchronized String Decrypt(String sSrc,String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(CipherType);

            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = base64Decoder.decodeBuffer(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return  new String(original,"UTF-8");
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
    
    public static void main(String[] args) throws Exception {
		System.out.println(Encrypt("447","11asd11111111111"));
		//System.out.println(Encrypt("888888","1111111111111111"));
		//System.out.println(MD5.encode("test_b@mj|11111111111111111111111111111111|888888","utf-8"));
		System.out.println(Decrypt("SWAz9Zr9aV/w3SDwx6crWQ==","cae83c67780b48b1"));
//		System.out.println(Decrypt(String.valueOf("YeXpbeRaASu8qRW9qiEZ/A=="),"01131a27ce1045b8"));
		//System.out.println(URLEncoder.encode("eJ+d2JY/zeCAIi1fKWmnZw=="));
	}
}