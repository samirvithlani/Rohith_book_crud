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
</body>
</html>