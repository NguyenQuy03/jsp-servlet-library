package com.library.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constant.SystemConstant;
import com.library.model.UserModel;
import com.library.service.IUserService;
import com.library.utils.FormUtil;
import com.library.utils.SessionUtil;

@WebServlet(urlPatterns = {"/home", "/login"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/home.jsp");
			rd.forward(req, resp);
		}
    }

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String action = req.getParameter("action");
    	
    	if (action != null && action.equals("login")) {
    		UserModel model = FormUtil.toModel(UserModel.class, req);
    		model = userService.findByUserNameAndPassWordAndStatus(model.getUserName(), model.getPassword(), true);
    		SessionUtil.getInstance().putValue(req, "USERMODEL", model);
    		
    		if (model != null) {
    			if (model.getRoleModel().getCode().equals(SystemConstant.USER)) {
    				resp.sendRedirect(req.getContextPath() + "/home");
    			} else if (model.getRoleModel().getCode().equals(SystemConstant.PUBLISHER)) {
    				resp.sendRedirect(req.getContextPath() + "/publisher-home");
    			} else if (model.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
    				resp.sendRedirect(req.getContextPath() +"/admin-home");
    			}
    		} else {
    			resp.sendRedirect(req.getContextPath() + "/login?action=login");
    		}
    	}
    }
}
