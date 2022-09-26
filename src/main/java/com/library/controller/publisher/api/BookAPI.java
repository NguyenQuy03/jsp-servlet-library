package com.library.controller.publisher.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.BookModel;
import com.library.model.RoleModel;
import com.library.model.UserModel;
import com.library.service.IBookService;
import com.library.service.IRoleService;
import com.library.service.IUserService;
import com.library.utils.HttpUtil;
import com.library.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-publisher-book"})
public class BookAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IBookService bookService;
	
	@Inject
	private IUserService userService;
	
	@Inject 
	private IRoleService roleService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		BookModel bookModel = HttpUtil.of(req.getReader()).toModel(BookModel.class);
		
		bookModel.setCreatedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		bookModel = bookService.save(bookModel);
		
		mapper.writeValue(resp.getOutputStream(), bookModel);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		BookModel updatedBook = HttpUtil.of(req.getReader()).toModel(BookModel.class);
		
		updatedBook.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getUserName());
		updatedBook = bookService.update(updatedBook);
		
		mapper.writeValue(resp.getOutputStream(), updatedBook);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		BookModel bookModel = HttpUtil.of(req.getReader()).toModel(BookModel.class);
		bookService.delete(bookModel.getIds());
		
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}

