<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="bookinsertcontroller">

		<table border="3">
			<tr>
				<td>Enter Book Name</td>
				<td><input type="text" name="txtBookName"></td>
			</tr>
			<tr>
				<td>Enter Book PRICE</td>
				<td><input type="text" name="txtBookPrice"></td>
			</tr>
			<tr>
				<td>Enter Book QTY</td>
				<td><input type="text" name="txtBookQty"></td>
			</tr>
			<tr>

				<td><input type="submit" value="ADD BOOK"></td>
			</tr>
		</table>
	</form>
</body>
</html>