package com.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constant.SystemConstant;
import com.library.model.UserModel;
import com.library.utils.SessionUtil;

@WebFilter(urlPatterns = {"/*"})
public class AuthorizationFilter implements Filter {
	
	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		String url = req.getRequestURI();
		
		if(url.startsWith("/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if (model != null) {
				if (model.getRoleModel().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(req.getContextPath() + "/login?action=login");
				} else if (model.getRoleModel().getCode().equals(SystemConstant.PUBLISHER)) {
					resp.sendRedirect(req.getContextPath() + "/login?action=login");
				} else if (model.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
					filterChain.doFilter(servletRequest, servletResponse);
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login");
			}
		} else if(url.startsWith("/publisher"))  {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if (model != null) {
				if (model.getRoleModel().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(req.getContextPath() + "/login?action=login");
				} else if (model.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
					resp.sendRedirect(req.getContextPath() + "/login?action=login");
				} else if (model.getRoleModel().getCode().equals(SystemConstant.PUBLISHER)) {
					filterChain.doFilter(servletRequest, servletResponse);
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login");
			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	@Override
	public void destroy() {
	}
	
}
