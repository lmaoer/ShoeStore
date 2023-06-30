<%@page import="dal.BrandDAO"%>
<%@page import="model.Brand"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>

<head>
<link type="text/css" rel="stylesheet" href="css/add-product-style.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

</head>

<%
BrandDAO b = new BrandDAO();
List<Brand> list = b.list();
%>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Add Product Form</h2>
		</div>
	</div>
	
	<div id="container">
		
		<form action="product" method="GET">
		<h3>Add Product</h3>
			<input type="hidden" name="command" value="ADD" />
			<table>
				<tbody>
					<tr>
						<td>ID:</td>
						<td><input required type="text" name="id" /></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><input required type="text" name="name" /></td>
					</tr>
					<tr>
						<td>Cost:</td>
						<td><input required type="text" name="cost" /></td>
					</tr>
					<tr>
						<td>Discount:</td>
						<td><input type="text" name="discount" /></td>
					</tr>
					<tr>
						<td>Quantity:</td>
						<td><input required type="text" name="quantity" /></td>
					</tr>
					<tr>
						<td>Image:</td>
						<td><input type="text" name="image" /></td>
					</tr>
					<tr>
						<td>Status:</td>
						<td><input type="text" name="status" /></td>
					</tr>
					<tr>
						<td>Image Detail:</td>
						<td><input type="text" name="imageDetail" /></td>
					</tr>
					<tr>
						<td>Brand ID:</td>
						<td><input required type="text" name="brandId" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>

			</table>
			<p>${msg}</p>
		</form>
	
	<div>
		<h3>Brands Information</h3>
		<table border="1px">
		<tr>
			<th>id</th>
			<th>name</th>
			
		</tr>
		<% for(Brand br: list){
			out.println("<tr>");
			out.println("<td>"+br.getId()+"</td>");
			out.println("<td>"+br.getName()+"</td>");
			out.println("</td>");
		}
		%>
	</table>	
	</div>

	</div>

	<p>
		<a href="product">Back to List</a>
	</p>
</body>

</html>