package com.fuiou.util;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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
	
	public String sendPost(String param,byte[] body_data,String fileNm) throws Exception {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			// out = new PrintWriter(conn.getOutputStream());
			out = new PrintWriter(new OutputStreamWriter(
					conn.getOutputStream(), "utf-8"));
			// 发送请求参数
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			out.print(param);
			dos.writeBytes("Content-Disposition:form-data;name=file;filename=" + fileNm);
			dos.write(body_data);
			// flush输出流的缓冲
			out.flush();
			dos.flush();
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
	
	public String post(String url, Map<String, String> map,
            String fileNm, byte[] body_data, String charset) {
        // 设置三个常用字符串常量：换行、前缀、分界线（NEWLINE、PREFIX、BOUNDARY）；
        final String NEWLINE = "\r\n"; 
        final String PREFIX = "--"; 
        final String BOUNDARY = "WebKitFormBoundarypYRWtizPCHGvvWu3"; 
        HttpURLConnection httpConn = null;
        BufferedInputStream bis = null;
        DataOutputStream dos = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL urlObj = new URL(url);
            httpConn = (HttpURLConnection) urlObj.openConnection();
            httpConn.setDoInput(true);
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            httpConn.setUseCaches(false);
            httpConn.setRequestProperty("Connection", "Keep-Alive");
            httpConn.setRequestProperty("Accept", "*/*");
            httpConn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            httpConn.setRequestProperty("Cache-Control", "no-cache");
            httpConn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);
            httpConn.setRequestProperty(
                    "User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30)");
            httpConn.connect();
            dos = new DataOutputStream(httpConn.getOutputStream());
            if (map != null && !map.isEmpty()) { 
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey(); 
                    String value = map.get(key); 
                    dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);
                    dos.writeBytes("Content-Disposition: form-data; "
                            + "name=\"" + key + "\"" + NEWLINE); 
                    dos.writeBytes(NEWLINE);
                    dos.writeBytes(value.toString());
                    dos.writeBytes(NEWLINE); // 换行
                } 
            }

            if (body_data != null && body_data.length > 0) {
                dos.writeBytes(PREFIX + BOUNDARY + NEWLINE);// 像请求体中写分割线，就是前缀+分界线+换行
                dos.writeBytes("Content-Disposition: form-data; " + "name=\""
                        + "refundImg" + "\"" + "; filename=\"" + fileNm
                        + "\"" + NEWLINE);
                dos.writeBytes(NEWLINE);
                dos.write(body_data); 
                dos.writeBytes(NEWLINE); 
            }
            dos.writeBytes(PREFIX + BOUNDARY + PREFIX + NEWLINE); 
            dos.flush();

            byte[] buffer = new byte[8 * 1024];
            int c = 0;
            if (httpConn.getResponseCode() == 200) {
                bis = new BufferedInputStream(httpConn.getInputStream());
                while ((c = bis.read(buffer)) != -1) {
                    baos.write(buffer, 0, c);
                    baos.flush();
                }
            }
            return new String(baos.toByteArray(), charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dos != null)
                    dos.close();
                if (bis != null)
                    bis.close();
                if (baos != null)
                    baos.close();
                httpConn.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
