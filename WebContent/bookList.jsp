<%@page import="com.bean.BookBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<BookBean> books = (List<BookBean>) request.getAttribute("books");
	%>
	<table border="3">
		<tr>
			<th>BOOK ID</th>
			<th>BOOK NAME</th>
			<th>BOOK PRICE</th>
			<th>BOOK QTY</th>
			<th>ACTION</th>
		</tr>

		<%
			for (int i = 0; i < books.size(); i++) {

			BookBean bookBean = books.get(i);
		%>

		<tr>
			<td><%=bookBean.getbId()%></td>
			<td><%=bookBean.getbName()%></td>
			<td><%=bookBean.getbPrice()%></td>
			<td><%=bookBean.getbQty()%></td>
			<td><a href="deletebookcontroller?bid=<%=bookBean.getbId()%>">DELETE</a></td>
			<td><a href="editbookcontroller?bid=<%=bookBean.getbId()%>">UPDATE</a></td>
		</tr>

		<%
			}
		%>
	</table>
	<form action="searchcontroller">
		<table border="2px">
			<tr>
				<td><input type="text" name="txtSearchName"></td>
				<td><input type="submit" value="SEARCH"></td>
			</tr>



			<%
				List<BookBean> searchBooks = (List<BookBean>) request.getAttribute("searchBooks");
			if (searchBooks != null) {
			%>
			<table border="3">
				<tr>
					<th>BOOK ID</th>
					<th>BOOK NAME</th>
					<th>BOOK PRICE</th>
					<th>BOOK QTY</th>

				</tr>

				<%
					for (int i = 0; i < searchBooks.size(); i++) {

					BookBean bookBean = searchBooks.get(i);
				%>

				<tr>
					<td><%=bookBean.getbId()%></td>
					<td><%=bookBean.getbName()%></td>
					<td><%=bookBean.getbPrice()%></td>
					<td><%=bookBean.getbQty()%></td>

				</tr>

				<%
					}
				} else {

				}
				%>
			</table>



		</table>
	</form>
</body>
</html>