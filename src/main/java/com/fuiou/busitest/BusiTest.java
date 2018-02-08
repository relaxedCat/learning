package com.fuiou.busitest;

import java.net.URLEncoder;

import net.sf.json.JSONObject;

import com.fuiou.util.AesUtil;
import com.fuiou.util.HttpPoster;
import com.fuiou.util.MD5;

public class BusiTest {

	@SuppressWarnings({ "deprecation" })
	public static void main(String[] args) throws Exception {
		
	int seqNo = 268;
		String consumeSn = "JG171117133928435" + seqNo;
		String refundSn = "JG171117133928435" +(seqNo+1);
		System.out.println(AesUtil.Encrypt("1", "46a0032448e74b4e"));
		String consumeUrl = "http://192.168.8.34:11402/mflg/flgmsrv!payDispatch"+"?productNum="+URLEncoder.encode(AesUtil.Encrypt("1", "46a0032448e74b4e"))+
//				System.out.println("http://192.168.52.51:8083/mflg/flgmsrv!payDispatch"+"?productNum="+URLEncoder.encode(AesUtil.Encrypt("1", "46a0032448e74b4e"))+
				"&productCd="+URLEncoder.encode(AesUtil.Encrypt("etickets", "46a0032448e74b4e"))+
				"&loginId="+URLEncoder.encode(AesUtil.Encrypt("guzhiqi1", "46a0032448e74b4e"))+
				"&userNm="+URLEncoder.encode(AesUtil.Encrypt("沈康", "46a0032448e74b4e"))+
				"&productSp="+URLEncoder.encode(AesUtil.Encrypt("BD", "46a0032448e74b4e"))+
				"&productNos="+URLEncoder.encode(AesUtil.Encrypt("BX", "46a0032448e74b4e"))+
				"&busiAmt="+URLEncoder.encode(AesUtil.Encrypt("100000", "46a0032448e74b4e"))+
				"&taxAmt="+URLEncoder.encode(AesUtil.Encrypt("99400", "46a0032448e74b4e"))+
				"&firmNo=pei"+
				"&serialNumber="+URLEncoder.encode(AesUtil.Encrypt(consumeSn, "46a0032448e74b4e"))+
				"&token="+URLEncoder.encode(MD5.MD5Encode("1|etickets|bcede71d82995de1211b19623fb1a638|guzhiqi1|沈康|pei|"+consumeSn, "UTF-8"));
		System.out.println(consumeUrl);
		
		
		System.out.println("=====================分隔符===========================");
		HttpPoster post = new HttpPoster();
		post.setUrl(consumeUrl);
		post.setCharset("utf-8");
		String retmsg = post.post("");
		
		JSONObject json = JSONObject.fromObject(retmsg);
		if("0000".equals(AesUtil.Decrypt(json.getString("result"),"46a0032448e74b4e"))){
			String orderNo = AesUtil.Decrypt(json.getString("orderNo"),"46a0032448e74b4e");
			System.out.println(orderNo);
			String refundUrl = "http://192.168.8.34:11402/mflg/reReq!refundReq?"+"orderNo="+URLEncoder.encode(AesUtil.Encrypt(orderNo, "46a0032448e74b4e"))+
					"&firmNo=pei"+
					"&busiCd="+URLEncoder.encode(AesUtil.Encrypt("FL01", "46a0032448e74b4e"))+
					"&serialNumber="+URLEncoder.encode(AesUtil.Encrypt(refundSn, "46a0032448e74b4e"))+
					"&token="+URLEncoder.encode(MD5.MD5Encode("112302573960|FL01|"+refundSn+"|bcede71d82995de1211b19623fb1a638", "UTF-8"));
			System.out.println(refundUrl);
			post.setUrl(refundUrl);
			post.setCharset("utf-8");
			String msg = post.post("");
			JSONObject js = JSONObject.fromObject(msg);
			System.out.println("code:"+AesUtil.Decrypt(js.getString("rvsRspCd"),"46a0032448e74b4e"));
			System.out.println("msg:"+AesUtil.Decrypt(js.getString("rvsRspDesc"),"46a0032448e74b4e"));
		}else{
			System.out.println("code:"+AesUtil.Decrypt(json.getString("result"),"46a0032448e74b4e"));
			System.out.println("msg:"+AesUtil.Decrypt(json.getString("resultMsg"),"46a0032448e74b4e"));
		}
		
	}
	
	
	
}
