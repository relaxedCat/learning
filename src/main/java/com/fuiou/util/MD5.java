package com.fuiou.util;
import java.security.MessageDigest;

public class MD5 {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	public static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * J 转换byte到16进制
	 * 
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0) {
			n = 256 + n;
		}
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * J 编码
	 * 
	 * @param origin
	 * @return
	 */

	// MessageDigest 为 JDK 提供的加密类
	public static String MD5Encode(String origin) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes("UTF-8")));
		} catch (Exception ex) {
		}
		return resultString;
	}
	
	// MessageDigest 为 JDK 提供的加密类
	public static String MD5Encode(byte[] bytes) {
		String resultString = null;
		try {
//			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(bytes));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return resultString;
	}
	
	public static String MD5Encode(String origin,String charsetName) {
		origin =origin.trim();
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteArrayToHexString(md.digest(resultString
					.getBytes(charsetName)));
		} catch (Exception ex) {
		}
		return resultString;
	}

	public static void main(String[] args) {
//		System.err.println(MD5Encode("luo|447@luo|031500579235|Fl01|http://192.168.8.29:27026/etickets/index.action?loginid=447@luo|4545565655","UTF-8"));
//		System.err.println(MD5Encode("luo|447@luo|031500579235|FL01|http://192.168.8.29:27026/etickets/index.action?loginid=447@luo|4545565655","UTF-8"));
//		LogWriter.info("luo|447@luo|031500579235|Fl01|http://192.168.8.29:27026/etickets/index.action?loginid=447@luo|4545565655"=="luo|447@luo|031500579235|FL01|http://192.168.8.29:27026/etickets/index.action?loginid=447@luo|4545565655");
	}
}
