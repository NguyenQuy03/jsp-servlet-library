package com.library.controller.admin;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constant.SystemConstant;
import com.library.model.BookModel;
import com.library.paging.Pageable;
import com.library.paging.Paging;
import com.library.service.IBookService;
import com.library.service.ICategoryService;
import com.library.sort.Sorter;
import com.library.utils.FormUtil;

@WebServlet(urlPatterns = {"/admin-book"})
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IBookService bookService;
	
	@Inject
	private ICategoryService categoryService;
	
	ResourceBundle bundle = ResourceBundle.getBundle("message");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BookModel model = FormUtil.toModel(BookModel.class, req);
		String views = "";
		
		String alertType = req.getParameter("alertType");
		String alertMessage = req.getParameter("alertMessage");
		//SHOW MESSAGE WHEN ACTION WITH BOOKS
		if (alertType != null && alertMessage != null) {
			req.setAttribute("alertType", alertType);
			req.setAttribute("alertMessage", bundle.getString(alertMessage));
		}
		
		//CONTRONLLER VIEWS
		if (model.getType().equals(SystemConstant.LIST)) {
			views = "/views/admin/book/list.jsp";
			
			Pageable pageable = new Paging(model.getPage(), model.getMaxPageItem(),
					new Sorter(model.getSortName(), model.getSortBy()));
			
			model.setListResult(bookService.findAll(pageable));
			model.setTotalItem(bookService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem() ));
			
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId() != null) {
				model = bookService.findOne(model.getId());
			}
			views = "/views/admin/book/edit.jsp";
			req.setAttribute("categories", categoryService.findAll());
		}
		
		
		req.setAttribute(SystemConstant.MODEL, model);
		RequestDispatcher rd = req.getRequestDispatcher(views);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
