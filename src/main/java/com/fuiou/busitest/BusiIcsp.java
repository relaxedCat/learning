package com.fuiou.busitest;

import java.net.URLEncoder;

import com.fuiou.util.AesUtil;
import com.fuiou.util.MD5;

public class BusiIcsp {

	public static void main(String[] args) throws Exception {
//		测试环境
		System.out.println("http://192.168.8.29:29084/icsp/interface/vtflogin.do"+"?loginId="+URLEncoder.encode(AesUtil.Encrypt("hehuan12", "46a0032448e74b4e"))+
				"&roleNo="+URLEncoder.encode(AesUtil.Encrypt("01", "46a0032448e74b4e"))+
				"&firmUserId="+URLEncoder.encode((AesUtil.Encrypt("100000000002", "46a0032448e74b4e")))+
				"&firmInsNm="+URLEncoder.encode((AesUtil.Encrypt("一姐企业", "46a0032448e74b4e")))+
				"&firmNo=pei"+
				"&userNm="+URLEncoder.encode((AesUtil.Encrypt("测试代理", "46a0032448e74b4e")))+
				"&token="+URLEncoder.encode(MD5.MD5Encode("bcede71d82995de1211b19623fb1a638|hehuan12|测试代理|pei|01|100000000002|一姐企业", "UTF-8")));
//		生产环境
//		System.out.println("https://icsp.fuligold.com/interface/vtflogin.do"+"?loginId="+URLEncoder.encode(AesUtil.Encrypt("guzq", "4399958029fa4f07"))+
//				"&roleNo="+URLEncoder.encode(AesUtil.Encrypt("01", "4399958029fa4f07"))+
//				"&firmUserId="+URLEncoder.encode((AesUtil.Encrypt("100000000002", "4399958029fa4f07")))+
//				"&firmInsNm="+URLEncoder.encode((AesUtil.Encrypt("测试企业", "4399958029fa4f07")))+
//				"&firmNo=score2"+
//				"&userNm="+URLEncoder.encode((AesUtil.Encrypt("测试代理", "4399958029fa4f07")))+
//				"&token="+URLEncoder.encode(MD5.MD5Encode("2e2cbec5b3f768ad4668028b5bee740d|guzq|测试代理|score2|01|100000000002|测试企业", "UTF-8")));
//	
	}
}