package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.BookBean;
import com.dao.BookDao;
import com.util.ValidationUtil;

/**
 * Servlet implementation class BookInsertController
 */
public class BookInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bName = request.getParameter("txtBookName");
		// if price ot qty is null it will throw and exception

		String price = request.getParameter("txtBookPrice");
		String qty = request.getParameter("txtBookQty");

		int bPrice = 0;
		int bQty = 0;
		boolean isvalid = false;
		
		if (!price.equals("")) {

			bPrice = Integer.parseInt(price);
			
			if(bPrice >100000) {
				
				isvalid  = true;
				request.setAttribute("bPricegreter", "book price should not greater thn 100000");
			}

		} else {

			isvalid = true;
			request.setAttribute("bPriceerror", "book price is required..");

		}
		
		if (!qty.equals("")) {

			bQty = Integer.parseInt(qty);
		} else {
			isvalid = true;
			request.setAttribute("bQtyerror", "book qty is required...");
		}

		if (ValidationUtil.isEmpty(bName)) {

			isvalid = true;
			request.setAttribute("bNameerror", "Book Name is Required..");

		}
		if (ValidationUtil.isEmpty(Integer.toString(bPrice))) {

			isvalid = true;
			request.setAttribute("bPriceerror", "book Price is required..");
		}
		if (ValidationUtil.isEmpty(Integer.toString(bQty))) {

			isvalid = true;
			request.setAttribute("bQtyerror", "book Qty is required..");
		}

		if (isvalid == true) {

			request.getRequestDispatcher("insertBook.jsp").forward(request, response);
		} else {

			// to database.. we need to pass these values to DAO using bean class
			BookBean bookBean = new BookBean();
			bookBean.setbName(bName);
			bookBean.setbPrice(bPrice);
			bookBean.setbQty(bQty);

			BookDao bookDao = new BookDao();
			boolean flag = bookDao.insertBook(bookBean);
			if (flag == true) {

				response.sendRedirect("booklistcontroller");
			} else {

				response.sendError(401);
			}

		}
	}

}
