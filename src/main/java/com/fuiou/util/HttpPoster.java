package com.fuiou.util;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;



/**
 * Http Post
 * 
 * @author Aillans
 * 
 */
public class HttpPoster {

	public HttpPoster() {
	}

	private String url;

	private String charset = "UTF-8";

	public void setUrl(String url) {
		this.url = url;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public HttpPoster(String url, String charset) {
		super();
		this.url = url;
		this.charset = charset;
	}

	public HttpPoster(String url) {
		super();
		this.url = url;
		this.charset = Charset.defaultCharset().name();
	}

	/**
	 * 发送参数包
	 * 
	 * @param parameters
	 * @return
	 * @throws IOException
	 */
	public String post(final Map<String, String> parameters) throws Exception {
		return post(new PostMethodCallback() {

			@Override
			public void doInPostMethod(PostMethod postMethod) {
				NameValuePair[] nameValuePairs = new NameValuePair[parameters.size()];
				Set<Entry<String, String>> set = parameters.entrySet();
				int i = 0;
				// 设置查询参数
				for (Entry<String, String> entry : set) {
					NameValuePair pair = new NameValuePair(entry.getKey(), entry.getValue());
					nameValuePairs[i] = pair;
					i++;
				}
				// 发送参数包
				postMethod.setRequestBody(nameValuePairs);

			}
		});
	}

	/**
	 * 使用http协议发送xmltext到url
	 * 
	 * @param url
	 *            将要发送的地址
	 * @param xmltext
	 *            将要发送的内容
	 * @return http返回码
	 */
	public String post(final String body) throws Exception {
		return post(new PostMethodCallback() {

			@Override
			public void doInPostMethod(PostMethod postMethod) {

				try {
					InputStream instream = new ByteArrayInputStream(body.getBytes(charset));
					postMethod.setRequestEntity(new InputStreamRequestEntity(instream, body.getBytes(charset).length));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 使用http协议发送xmltext到url
	 * 
	 * @param url
	 *            将要发送的地址
	 * @param xmltext
	 *            将要发送的内容
	 * @return http返回码
	 * @throws Exception
	 */
	private String post(PostMethodCallback callback) throws Exception {
		HttpClient httpclient = new HttpClient();
		PostMethod xmlpost = new PostMethod(url);
		try {
			System.out.println("发送数据 url:"+url);
			// https设置
			if (url.indexOf("https://") != -1) {
				// 创建SSL连接
				@SuppressWarnings("deprecation")
				Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
				Protocol.registerProtocol("https", myhttps);
			}
			httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(60*1000);
			httpclient.getHttpConnectionManager().getParams().setSoTimeout(60*1000);
			httpclient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
			httpclient.getParams().setContentCharset(charset);
			// xmlpost.setRequestHeader("content-type", "text/xml; charset=" +
			// charset);

			// 内部回调，发送数据，设置参数用
			callback.doInPostMethod(xmlpost);
			// 执行请求
			httpclient.executeMethod(xmlpost);

			// 获取返回信息
			InputStream ips = xmlpost.getResponseBodyAsStream();
			List<Byte> byteList = new ArrayList<Byte>();

			int is = 0;
			while ((is = ips.read()) != -1)
				byteList.add((byte) is);

			byte[] allb = new byte[byteList.size()];
			for (int j = 0; j < byteList.size(); j++)
				allb[j] = byteList.get(j);
			String responseString = new String(allb, charset);
			// LogWriter.debug(this, "HTTP返回码=" + responseStatCode);
			System.out.println( "应答数据=" + responseString);

			if (url.indexOf("https://") != -1)
				Protocol.unregisterProtocol("https");
			return responseString;
		} catch (IOException ex2) {
			ex2.printStackTrace();
			throw ex2;
		} finally {
			try {
				xmlpost.releaseConnection();
				httpclient.getHttpConnectionManager().closeIdleConnections(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * PostMethod回调处理
	 * 
	 */
	public interface PostMethodCallback {
		public void doInPostMethod(PostMethod postMethod);
	}

}
