package com.fuiou.busitest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fuiou.util.HttpPoster;

public class BusiLfq {
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		
		HttpPoster post = new HttpPoster();
		
		String orderPayUrl = "http://192.168.52.51:8080/lfqpay/card/pay.do";
		String smsUrl = "http://192.168.52.51:8080/lfqpay/card/smscode.do";
		Scanner s = new Scanner(System.in);
		System.out.println("请输入订单号：");
		String orderNo = s.nextLine();
		System.out.println("请输入手机号：");
		String bankMobile = s.nextLine();
		String smsUlr=smsUrl+"?orderNo="+orderNo+"&bankMobile="+bankMobile;
		post.setUrl(smsUlr);
		post.setCharset("utf-8");
		String smsmsg = post.post("");
		System.out.println(smsmsg);
		System.out.println("请输入验证码：");
		String smsCode = s.nextLine();
		System.out.println("请输入支付金额：");
		String payAmt = s.nextLine();
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("cardholder", "王丹");
		paramMap.put("identityNo", "330901198808018886");
		paramMap.put("creditCardNo", "370248192322610");
		paramMap.put("validMonthYear", "2022-08");
		paramMap.put("cvn", "167");
		paramMap.put("bankMobile", bankMobile);
		paramMap.put("orderNo", orderNo);
		paramMap.put("smsCode", smsCode);
		paramMap.put("payAmt", payAmt);
		paramMap.put("applyUser", "合欢");
		post.setUrl(orderPayUrl);
		post.setCharset("utf-8");
		String paymsg = post.post(paramMap);
		System.out.println(paymsg);
		
	}

}
