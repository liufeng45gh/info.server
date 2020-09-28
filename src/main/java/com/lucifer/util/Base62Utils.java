package com.lucifer.util;

public class Base62Utils {
	
	public static char [] encTable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 
										'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 
										'W', 'X', 'Y',   'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g',
										'h', 'i', 'j', 'k', 'l', 'm',  'n', 'o', 'p', 'q', 'r',
										's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',  '1', '2', 
										'3', '4', '5', '6', '7', '8', '9', '+', '/'};
	
	public static char [] decTable = new char [256];
	
	static{
		for (int i = 0; i < encTable.length; i++) {  
		    decTable[encTable[i]] = (char) i;  
		}  
	}
	
	public static String encode(String str) {  
	    String value = "";  
	    int pos = 0, val = 0;  
	    for (int i = 0; i < str.length(); i++) {  
	        val = (val << 8) | (str.charAt(i) & 0xFF);  
	        pos += 8;  
	        while (pos > 5) {  
	            char c = encTable[val >> (pos -= 6)];  
	            value += c == 'i' ? "ia" : c == '+' ? "ib" : c == '/' ? "ic" : c;  
	            val &= ((1 << pos) - 1);  
	        }  
	    }  
	    if (pos > 0) {  
	        value += encTable[val << (6 - pos)];  
	        if (pos == 2) {  
	            value += "==";  
	        } else if (pos == 4) {  
	            value += "=";  
	        }  
	    }  
	    return value;  
	}  
	
	public static String  decode(String str) {  
		  
	    int pos = 0, val = 0;  
	    String value = "";  
	    for ( int i = 0; i < str.length(); i++) {  
	        char c = str.charAt(i);  
	        if (c == '=') {  
	            break;  
	        }  
	        if (c == 'i') {  
	            c = str.charAt(++i);  
	            c = c == 'a' ? 'i' : c == 'b' ? '+' : c == 'c' ? '/' : str.charAt(--i);  
	        }  
	        val = (val << 6) | decTable[c];  
	        pos += 6;  
	        while (pos > 7) {  
	            value += (char)((val >> (pos -= 8)) & 0xFF);  
	            val &= ((1 << pos) - 1);  
	        }  
	    }  
	    return value;  
	}  

}
