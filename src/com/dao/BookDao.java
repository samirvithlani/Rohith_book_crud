package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.BookBean;
import com.util.DBConnection;

public class BookDao {

	// for insert create one method named insertBook with boolean return type and
	// bean param

	public boolean insertBook(BookBean bookBean) {

		boolean flag = false;

		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String insertSQL = "insert into books(bname,bprice,bqty)values(?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQL);
				pstmt.setString(1, bookBean.getbName());
				pstmt.setInt(2, bookBean.getbPrice());
				pstmt.setInt(3, bookBean.getbQty());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public List<BookBean> bookList() {

		List<BookBean> books = new ArrayList<BookBean>();

		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String SELECTSQL = "select * from books";
			try {
				PreparedStatement pstmt = conn.prepareStatement(SELECTSQL);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					BookBean bookBean = new BookBean();
					bookBean.setbId(rs.getInt("bid"));
					bookBean.setbName(rs.getString("bname"));
					bookBean.setbPrice(rs.getInt("bprice"));
					bookBean.setbQty(rs.getInt("bqty"));
					books.add(bookBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return books;

	}

	public boolean deleteBook(int bId) {

		boolean flag = false;
		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String deleteSQL = "delete from books where bid =?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, bId);

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;

	}

	public BookBean getBookById(int bId) {

		BookBean bookBean = null;
		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String selectSQL = "select * from books where bid =?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, bId);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					bookBean = new BookBean();
					bookBean.setbId(rs.getInt("bid"));
					bookBean.setbName(rs.getString("bname"));
					bookBean.setbPrice(rs.getInt("bprice"));
					bookBean.setbQty(rs.getInt("bqty"));

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return bookBean;
	}

	public boolean updateBook(BookBean bookBean) {
		boolean flag = false;

		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String updateSQL = "update books set bname =?,bprice=?,bqty=? where bid= ?";

			try {
				PreparedStatement pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, bookBean.getbName());
				pstmt.setInt(2, bookBean.getbPrice());
				pstmt.setInt(3, bookBean.getbQty());
				pstmt.setInt(4, bookBean.getbId());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return flag;

	}

	public List<BookBean> searchData(String bName) {
		List<BookBean> books = new ArrayList<BookBean>();

		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String SELECTSQL = "select * from books where bname LIKE ? ";
			try {
				PreparedStatement pstmt = conn.prepareStatement(SELECTSQL);
				pstmt.setString(1, bName+"%");
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					BookBean bookBean = new BookBean();
					bookBean.setbId(rs.getInt("bid"));
					bookBean.setbName(rs.getString("bname"));
					bookBean.setbPrice(rs.getInt("bprice"));
					bookBean.setbQty(rs.getInt("bqty"));
					books.add(bookBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return books;
	}
	

}
