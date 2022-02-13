package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String searchName = request.getParameter("txtSearchName");
		List<BookBean> searchBooks = new ArrayList<BookBean>();

		BookDao bookDao = new BookDao();
		searchBooks = bookDao.searchData(searchName);
		request.setAttribute("searchBooks", searchBooks);
		request.getRequestDispatcher("booklistcontroller").forward(request, response);
	}

}
