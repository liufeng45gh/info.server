package com.lucifer.util;

public class CommonUtil {
	
	private static Integer idIndex = 1;
	/**
	 * 生成唯一性id
	 * <p>
	 * 当前时间秒值加3位同步数字，使用秒值避免long型越界
	 * </p>
	 * 
	 * @return
	 */
	public static synchronized long nextId() {
		if (idIndex > 999)
			idIndex = 1;
		return Long.parseLong(System.currentTimeMillis() + String.valueOf(idIndex++));
	}

}
