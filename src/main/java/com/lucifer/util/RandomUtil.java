package com.lucifer.util;

import java.util.Random;

public class RandomUtil {

	public static String getNextCheckCode(){
		// 创建一个随机数生成器类。   
        Random random = new Random();   
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。   
        StringBuffer randomCode = new StringBuffer();   
		// 设置默认生成4个验证码   
        int length = 4;   
        // 设置备选验证码:包括"a-z"和数字"0-9"   
        String base = "0123456789";   
  
        int size = base.length();   
  
        // 随机产生4位数字的验证码。   
        for (int i = 0; i < length; i++) {   
            // 得到随机产生的验证码数字。   
            int start = random.nextInt(size);   
            String strRand = base.substring(start, start + 1);     
            // 将产生的四个随机数组合在一起。   
            randomCode.append(strRand);   
        }   
        return randomCode.toString();
	}
	
	public static String getNextCityId(String parentId){
		// 创建一个随机数生成器类。   
        Random random = new Random();   
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。   
        StringBuffer randomCode = new StringBuffer();   
		// 设置默认生成4个验证码   
        int length = 4;   
        // 设置备选验证码:包括"a-z"和数字"0-9"   
        String base = "abcdefghigklmnopqrstuvwxyz0123456789";   
  
        int size = base.length();   
  
        // 随机产生4位数字的验证码。   
        for (int i = 0; i < length; i++) {   
            // 得到随机产生的验证码数字。   
            int start = random.nextInt(size);   
            String strRand = base.substring(start, start + 1);     
            // 将产生的四个随机数组合在一起。   
            randomCode.append(strRand);   
        }   
        if("0".equals(parentId)){
        	return randomCode.toString();
        }
        return parentId+randomCode.toString();
	}
}
