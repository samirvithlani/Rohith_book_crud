package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;

/**
 * Servlet implementation class DeleteBookController
 */
public class DeleteBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//

		int bId = Integer.parseInt(request.getParameter("bid"));
		// this id need to pass Dao inside book delete method

		BookDao bookDao = new BookDao();
		boolean flag = bookDao.deleteBook(bId);
		if (flag == true) {

			response.sendRedirect("booklistcontroller");
		} else {

			response.sendRedirect("booklistcontroller");
		}

	}

}
