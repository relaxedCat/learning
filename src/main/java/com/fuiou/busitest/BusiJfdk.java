package com.fuiou.busitest;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import com.fuiou.annotation.Apple;
import com.fuiou.util.AesUtil;
import com.fuiou.util.HttpPoster;
import com.fuiou.util.MD5;

public class BusiJfdk {

	
	public static void main(String[] args) throws Exception {
//		HttpPoster post = new HttpPoster();
//		String refundUrl = "http://192.168.8.31:11402/mflg/reReq!refundReq?"+"orderNo="+URLEncoder.encode(AesUtil.Encrypt("112402573995", "7dcde9cf9fbb4497"))+
//				"&firmNo=jfdk"+
//				"&busiCd="+URLEncoder.encode(AesUtil.Encrypt("FL01", "7dcde9cf9fbb4497"))+
//				"&serialNumber="+URLEncoder.encode(AesUtil.Encrypt("JG171117133928435239", "7dcde9cf9fbb4497"))+
//				"&token="+URLEncoder.encode(MD5.MD5Encode("112402573995|FL01|JG171117133928435239|bcede71d82995de1211b19623fb1a638", "UTF-8"));
//		System.out.println(refundUrl);
//		post.setUrl(refundUrl);
//		post.setCharset("utf-8");
//		String msg = post.post("");
//		JSONObject js = JSONObject.fromObject(msg);
//		System.out.println(msg);
		
		System.out.println("https://jrwxp.fuiou.com/pro.html?appid=wx17f1e00c26885047&scope=snsapi_base&state=STATE&redirect_uri="+URLEncoder.encode("https://cfc.fuiou.com/jump/login.do?qrCode=00000001"));
	}
}
