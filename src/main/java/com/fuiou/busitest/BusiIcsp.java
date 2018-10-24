package com.fuiou.busitest;

import java.net.URLEncoder;

import com.fuiou.util.AesUtil;
import com.fuiou.util.MD5;

public class BusiIcsp {

	public static void main(String[] args) throws Exception {
		
//		开发环境 02 代理人
		System.out.println("http://192.168.52.51:8080/icsp/interface/vtflogin.do"+"?loginId="+URLEncoder.encode(AesUtil.Encrypt("shenkang5", "46a0032448e74b4e"))+
				"&roleNo="+URLEncoder.encode(AesUtil.Encrypt("02", "46a0032448e74b4e"))+
				"&firmUserId="+URLEncoder.encode((AesUtil.Encrypt("100000000002", "46a0032448e74b4e")))+
				"&firmInsNm="+URLEncoder.encode((AesUtil.Encrypt("一姐企业", "46a0032448e74b4e")))+
				"&firmNo=pei"+
				"&userNm="+URLEncoder.encode((AesUtil.Encrypt("林殊", "46a0032448e74b4e")))+
				"&token="+URLEncoder.encode(MD5.MD5Encode("bcede71d82995de1211b19623fb1a638|shenkang5|林殊|pei|02|100000000002|一姐企业", "UTF-8")));
//		开发环境 01 业务员
		System.out.println("http://192.168.52.51:8080/icsp/interface/vtflogin.do"+"?loginId="+URLEncoder.encode(AesUtil.Encrypt("hehuan12", "46a0032448e74b4e"))+
				"&roleNo="+URLEncoder.encode(AesUtil.Encrypt("01", "46a0032448e74b4e"))+
				"&firmUserId="+URLEncoder.encode((AesUtil.Encrypt("100000000002", "46a0032448e74b4e")))+
				"&firmInsNm="+URLEncoder.encode((AesUtil.Encrypt("一姐企业", "46a0032448e74b4e")))+
				"&firmNo=pei"+
				"&userNm="+URLEncoder.encode((AesUtil.Encrypt("测试代理", "46a0032448e74b4e")))+
				"&token="+URLEncoder.encode(MD5.MD5Encode("bcede71d82995de1211b19623fb1a638|hehuan12|测试代理|pei|01|100000000002|一姐企业", "UTF-8")));
	
//		测试环境 01 业务员
		System.out.println("http://192.168.8.29:29084/icsp/interface/vtflogin.do"+"?loginId="+URLEncoder.encode(AesUtil.Encrypt("hehuan12", "46a0032448e74b4e"))+
				"&roleNo="+URLEncoder.encode(AesUtil.Encrypt("01", "46a0032448e74b4e"))+
				"&firmUserId="+URLEncoder.encode((AesUtil.Encrypt("100000000002", "46a0032448e74b4e")))+
				"&firmInsNm="+URLEncoder.encode((AesUtil.Encrypt("一姐企业", "46a0032448e74b4e")))+
				"&firmNo=pei"+
				"&userNm="+URLEncoder.encode((AesUtil.Encrypt("测试代理", "46a0032448e74b4e")))+
				"&token="+URLEncoder.encode(MD5.MD5Encode("bcede71d82995de1211b19623fb1a638|hehuan12|测试代理|pei|01|100000000002|一姐企业", "UTF-8")));
//		测试环境 02 代理人
		System.out.println("http://192.168.8.29:29084/icsp/interface/vtflogin.do"+"?loginId="+URLEncoder.encode(AesUtil.Encrypt("shenkang5", "46a0032448e74b4e"))+
				"&roleNo="+URLEncoder.encode(AesUtil.Encrypt("02", "46a0032448e74b4e"))+
				"&firmUserId="+URLEncoder.encode((AesUtil.Encrypt("100000000002", "46a0032448e74b4e")))+
				"&firmInsNm="+URLEncoder.encode((AesUtil.Encrypt("一姐企业", "46a0032448e74b4e")))+
				"&firmNo=pei"+
				"&userNm="+URLEncoder.encode((AesUtil.Encrypt("林殊", "46a0032448e74b4e")))+
				"&token="+URLEncoder.encode(MD5.MD5Encode("bcede71d82995de1211b19623fb1a638|shenkang5|林殊|pei|02|100000000002|一姐企业", "UTF-8")));

	}
}
