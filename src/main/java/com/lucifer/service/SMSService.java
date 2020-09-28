//package com.lucifer.service;
//
//import java.io.IOException;
//
//import org.apache.commons.httpclient.Header;
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.NameValuePair;
//import org.apache.commons.httpclient.methods.PostMethod;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//
//
//public class SMSService {
//
//	private static  Log log = LogFactory.getLog(SMSService.class);
//
//	private String smschinese_uid;
//
//
//	private String smschinese_key;
//
//
//	public String getSmschinese_uid() {
//		return smschinese_uid;
//	}
//
//
//	public void setSmschinese_uid(String smschinese_uid) {
//		this.smschinese_uid = smschinese_uid;
//	}
//
//
//	public String getSmschinese_key() {
//		return smschinese_key;
//	}
//
//
//	public void setSmschinese_key(String smschinese_key) {
//		this.smschinese_key = smschinese_key;
//	}
//
//
//	public void sendMessage(String telephone,String message) throws HttpException, IOException{
//		log.info("smschinese_uid: "+smschinese_uid);
//		log.info("smschinese_key: "+smschinese_key);
//		log.info(message);
//		HttpClient httpClient = new HttpClient();
//		PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");
//		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");//在头文件中设置转码
//		NameValuePair[] data ={ new NameValuePair("Uid", smschinese_uid),
//				new NameValuePair("Key", smschinese_key),
//				new NameValuePair("smsMob",telephone),
//				new NameValuePair("smsText",message)};
//		post.setRequestBody(data);
//		httpClient.executeMethod(post);
//		Header[] headers = post.getResponseHeaders();
//		int statusCode = post.getStatusCode();
//		log.info("statusCode:"+statusCode);
//		for(Header h : headers){
//			//log.info(h);
//		}
//		String result = new String(post.getResponseBodyAsString().getBytes("utf8"));
//		log.info("send message result: "+result);
//		//System.out.println(result);
//
//
//		post.releaseConnection();
//	}
//}
