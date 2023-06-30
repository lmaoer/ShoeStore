<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="ISO-8859-1">
<title>Trang quản lý</title>

<style type="text/css">
table {
	width: 90%;
	margin: 30px auto;
	border-collapse: collapse;
	text-align: center;
	vertical-align: center;
}

th {
	text-transform: uppercase;
}

a {
	display: inline-block;
	text-decoration: none;
	padding: 7px 10px;
	color: #fff;
	background-color: #000;
}

.pagination {
	width: 90%;
	margin: 30px auto;
} 


.pagination a {
	
	font-size: 22px;
	
	padding: 8px 16px;
	text-decoration: none;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
}

.pagination a:hover:not(.active) {
	background-color: chocolate;
}

.nav{
	display: flex;
	justify-content: space-between;
}
</style>

</head>
<body>
	<div class="nav">
		<h1>Products Information</h1>
		<form action="product">
		<input type="text" name="key" placeholder="search">
		<input type="submit" value="search">
		</form>
	</div>
	
	<hr>
	<a href="add_product.jsp" style="margin-bottom:30px">Add Product</a>
	<br>
	<c:set var="k" value="${requestScope.key}"/>
	<c:set var="page" value="${requestScope.page}"></c:set>
	<div class="pagination">
		<c:forEach begin="${1 }" end="${requestScope.num }" var="i">
			<a class="${i==page?" active":""}" href="product?page=${i}&key=${key}">${i }</a>
		</c:forEach>
	</div>
	<table border="1px">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>cost</th>
			<th>discount</th>
			<th>quantity</th>
			<th>image</th>
			<th>status</th>
			<th>image Detail</th>
			<th>brand</th>
			<th>action</th>
		</tr>
		<c:forEach var="p" items="${requestScope.products_list}">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.cost}</td>
				<td>${p.discount}</td>
				<td>${p.quantity}</td>
				<td><img src="img/products_img/${p.image}" alt="product image"
					width="80px" height="80px" /></td>
				<td>${p.status==1?"Còn hàng":"Hết hàng"}</td>
				<td><img src="img/products_img/${p.imageDetail}"
					alt="product detail" width="80px" height="80px" /></td>
				<td>${p.brand.name}</td>
				<td><a href="product?id=${p.id}&command=DELETE"
					onclick="if(!(confirm('Are you sure you want to delete this student?'))) return false">DELETE</a>
					| <a href="product?id=${p.id}&command=LOAD">UPDATE</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>