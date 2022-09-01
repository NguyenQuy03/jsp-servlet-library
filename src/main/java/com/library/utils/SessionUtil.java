package com.library.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
	public static SessionUtil sessionUtil = null;
	
	public static SessionUtil getInstance() {
		if (sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		
		return sessionUtil;
	}
	
	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
	}
	
	public void deleteValue(HttpServletRequest req, String key) {
		req.getSession().removeAttribute(key);
	}
}
