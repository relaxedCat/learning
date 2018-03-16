package com.fuiou.busitest;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fuiou.util.AesUtil;
import com.fuiou.util.HttpPoster;
import com.fuiou.util.MD5;

public class BusiLfq {
	
	
	public static void main(String[] args) throws Exception {
		HttpPoster post = new HttpPoster();
		String uploadUrl = "https://www-1.fuiou.com:23456/lfqpay/refund/upload.do";
		post.setUrl(uploadUrl);
		post.setCharset("utf-8");
		byte[] buffer = null;
		File file = new File("F:\\timg (3).jpg");
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        buffer = bos.toByteArray();
        Map<String, String> map = new HashMap<String, String>();
        map.put("firmNo", "SHFYJRWL001");
        map.put("orderNo", AesUtil.Encrypt("120802574512", "dd7ddd137dde4367"));
        map.put("mchntSsn", AesUtil.Encrypt("1512701704254", "dd7ddd137dde4367"));
        String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        map.put("time", AesUtil.Encrypt(date, "dd7ddd137dde4367"));
        map.put("token", getToken(date));
		String paymsg = post.post(uploadUrl,map,file.getName(),buffer,"utf-8");
		System.out.println(paymsg);
		
	}
//	firmNo|mchntSsn|orderNo|md5key|time
	private static String getToken(String date){
		return MD5.MD5Encode("SHFYJRWL001|1512701704254|120802574512|236ff6ad90e78c6175e00ec61fe0560d|"+date, "utf-8");
	}

}
