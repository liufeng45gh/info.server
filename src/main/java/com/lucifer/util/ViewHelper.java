package com.lucifer.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.lucifer.dao.AdminUserDao;
import com.lucifer.dao.UserDao;

import com.lucifer.model.AdminUser;
import com.lucifer.model.User;

@Service
public class ViewHelper {

	@Resource
	private AdminUserDao adminUserDao;

	@Resource
	private UserDao userDao;

	private static ViewHelper instance;

	private Log log = LogFactory.getLog(ViewHelper.class);

	protected String getWebUserToken(HttpServletRequest request) {
		String token = request.getParameter(CommonConstant.USER_ACCESS_TOKEN);
		if (!StringUtil.isEmpty(token)) {
			return token;
		}
		Cookie[] cookies = request.getCookies();

		if (null == cookies) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(CommonConstant.USER_ACCESS_TOKEN)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();

		if (null == cookies) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public User getWebTokenUser(HttpServletRequest request) {
		String token = getWebUserToken(request);
		if (token != null) {
			User user = userDao.findByToken(token);
			return user;
		}
		return null;
	}

	protected String getAdminUserToken(HttpServletRequest request) {
		String token = request.getParameter(CommonConstant.ADMIN_USER_ACCESS_TOKEN);
		if (!StringUtil.isEmpty(token)) {
			return token;
		}
		Cookie[] cookies = request.getCookies();

		if (null == cookies) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(CommonConstant.ADMIN_USER_ACCESS_TOKEN)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public AdminUser getAdminTokenUser(HttpServletRequest request) {
		String token = getWebUserToken(request);
		if (token != null) {
			AdminUser user = adminUserDao.findByToken(token);
			return user;
		}
		return null;
	}

	public static ViewHelper getInstance() {

		return instance;

	}

	@PostConstruct
	public void init() {
		log.info("DataLocator init has been called");
		// WebApplicationContext
		// ctx=WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		// instance = ctx.getBean(ViewHelper.class);
		instance = this;
	}

	public String selectTag(String name, Object value, Map htmlOptions, List objects, String textKey, String valueKey,
			String blankText) throws Exception {
		StringBuffer buffer = new StringBuffer();
		htmlOptions = map(htmlOptions, "id", name, "name", name, "value", value);
		buffer.append(startTag("select", htmlOptions));
		if (blankText != null) {
			buffer.append(startTag("option", map("value", -1)));
			buffer.append(blankText);
			buffer.append(endTag("option"));
		}
		for (Object object : objects) {
			Object objectValue = -1;
			String objectText = null;

			if (object instanceof Map) {
				Map map = (Map) object;
				objectValue = map.get(valueKey);
				objectText = (String) map.get(textKey);
			} else {
				try {
					objectValue = ReflectionHelper.getPropertyByGeterMethod(object, valueKey);
					objectText = ReflectionHelper.getPropertyByGeterMethod(object, textKey).toString();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (objectValue.equals(value)) {
				buffer.append(startTag("option", map("value", objectValue, "selected", "selected")));
			} else {
				buffer.append(startTag("option", map("value", objectValue)));
			}
			buffer.append(objectText);
			buffer.append(endTag("option"));
		}
		buffer.append(endTag("select"));
		return buffer.toString();
	}

	public static Map map(Map map, Object... arrays) throws Exception {
		Map maps = new HashMap();
		if (map != null) {
			maps.putAll(map);
		}
		maps.putAll(map(arrays));
		return maps;
	}

	public static Map map(Object... arrays) throws Exception {
		Map maps = new HashMap();
		if (arrays.length % 2 != 0)
			throw new Exception("arrays 长度 必须为偶数");
		for (int i = 0; i < arrays.length; i++) {
			maps.put(arrays[i], arrays[++i]);
		}
		return maps;
	}

	public String startTag(String tag, Map htmlOptions) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<" + tag);
		for (Object key : htmlOptions.keySet()) {
			buffer.append(" " + key + "='" + htmlOptions.get(key) + "'");
		}
		buffer.append(">");
		return buffer.toString();
	}

	public String endTag(String tag) {
		return "</" + tag + ">";
	}

	/**
	 * 分页标签
	 * @param request
	 * @param total
	 * @param offset
	 * @param pageparas
	 * @return
	 */
	public static String willPaginate(HttpServletRequest request, long totalCount, int perPageCount, String[] pageparas) {

		if (null == pageparas) {
			pageparas = new String[] { "page" };
		}
		String requestParameterStrings = getRequestParameterStrings(request, pageparas);

		StringBuffer buffer = new StringBuffer();

		int currentPage = paramAsInt(request, "page", "1");

		long pageCount = 1L;
		if (totalCount % perPageCount == 0) {
			pageCount = totalCount / perPageCount;
		} else {
			pageCount = totalCount / perPageCount + 1;
		}
		if (pageCount > 1) {
			buffer.append(String.format("<div >"));
			if (currentPage > 1) {
				buffer.append(
						String.format("<a href='?page=%d" + requestParameterStrings + "'>上一页</a>", currentPage - 1));
			}

			boolean dotAddedLeft = false;
			boolean dotAddedRight = false;
			for (int i = 0; i < pageCount; i++) {

				if (Math.abs((currentPage - 1) - i) >= 5 && i != 0 && i != pageCount - 1) {
					if (!dotAddedLeft && (currentPage - 1) - i >= 5) {
						buffer.append("...");
						dotAddedLeft = true;
					} else if (!dotAddedRight && i - (currentPage - 1) >= 5) {
						buffer.append("...");
						dotAddedRight = true;
					}
					continue;
				}

				buffer.append(String.format("<a href='?page=%d" + requestParameterStrings + "' class='%s'>%d</a>",
						i + 1, currentPage == (i + 1) ? "current" : "number", i + 1));
			}

			if (currentPage < pageCount) {
				buffer.append(
						String.format("<a href='?page=%d" + requestParameterStrings + "' >下一页</a>", currentPage + 1));
			}

			buffer.append("</div>");
		}

		return buffer.toString();
	}

	/**
	 * 取出parameter
	 * @param request
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static String param(HttpServletRequest request, String name, String defaultValue) {
		String value = request.getParameter(name);
		if (value == null) {
			return defaultValue;
		}

		return value;
	}

	/**
	 * param转成int
	 * @param request
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	public static int paramAsInt(HttpServletRequest request, String name, String defaultValue) {
		return Integer.parseInt(param(request, name, defaultValue));
	}

	/**
	 * 去除exclude 后的参数
	 * @param request
	 * @param excludes
	 * @return
	 */
	private static String getRequestParameterStrings(HttpServletRequest request, String[] excludes) {
		StringBuffer parameterBuffer = new StringBuffer();
		Map<String, String[]> requestParameterMap = request.getParameterMap();
		Set<String> keySet = requestParameterMap.keySet();
		for (String key : keySet) {
			boolean flag = isContain(excludes, key);
			if (flag) {
				continue;
			}
			String[] values = requestParameterMap.get(key);
			for (String value : values) {
				parameterBuffer.append("&" + key + "=" + value);
			}
		}
		return parameterBuffer.toString();
	}

	/**
	 * 是否存在
	 * @param strArray
	 * @param str
	 * @return
	 */
	private static boolean isContain(String[] strArray, String str) {
		for (String _str : strArray) {
			if (_str.equals(str)) {
				return true;
			}
		}
		return false;
	}

}
