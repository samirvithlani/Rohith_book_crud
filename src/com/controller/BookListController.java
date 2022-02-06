package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;

/**
 * Servlet implementation class BookListController
 */
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDao bookDao = new BookDao();
		List<BookBean> books = bookDao.bookList();
		// we need to print data in jsp... so need to send books object to jsp using
		// request Dispatcher..

		request.setAttribute("books", books);
		request.getRequestDispatcher("bookList.jsp").forward(request, response);

	}

}
