<%@page import="com.bean.BookBean"%>
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
		BookBean bookBean = (BookBean) request.getAttribute("bookBean");
	%>

	<form action="bookupdatecontroller">
		<input type="hidden" value="<%=bookBean.getbId()%>" name="bId">

		<table border="3">
			<tr>
				<td>Enter Book Name</td>
				<td><input type="text" name="txtBookName"
					value="${bookBean.bName }"></td>
			</tr>
			<tr>
				<td>Enter Book PRICE</td>
				<td><input type="text" name="txtBookPrice"
					value="<%=bookBean.getbPrice()%>"></td>
			</tr>
			<tr>
				<td>Enter Book QTY</td>
				<td><input type="text" name="txtBookQty"
					value="<%=bookBean.getbQty()%>"></td>
			</tr>
			<tr>

				<td><input type="submit" value="UPDATE BOOK"></td>
			</tr>
		</table>
	</form>
</body>
</html>