package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;

/**
 * Servlet implementation class BookUpdateController
 */
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bName = request.getParameter("txtBookName");
		// if price ot qty is null it will throw and exception
		int bPrice = Integer.parseInt(request.getParameter("txtBookPrice"));
		int bQty = Integer.parseInt(request.getParameter("txtBookQty"));
		int bId = Integer.parseInt(request.getParameter("bId"));

		// to database.. we need to pass these values to DAO using bean class
		BookBean bookBean = new BookBean();
		bookBean.setbName(bName);
		bookBean.setbPrice(bPrice);
		bookBean.setbQty(bQty);
		bookBean.setbId(bId);

		BookDao bookDao = new BookDao();
		boolean flag = bookDao.updateBook(bookBean);
		if (flag == true) {

			response.sendRedirect("booklistcontroller");
		} else {
			response.sendRedirect("booklistcontroller");
		}

	}

}
