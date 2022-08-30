package com.library.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.service.IBookService;
import com.library.service.ICategoryService;

@WebServlet(urlPatterns = {"/home", "/login"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IBookService bookService;
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/login/login.jsp");
			rd.forward(req, resp);
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/home.jsp");
			rd.forward(req, resp);
			System.out.println("HomeS");
			System.out.println("Check");
		}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
