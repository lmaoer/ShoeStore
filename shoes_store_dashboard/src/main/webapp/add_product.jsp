<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin page</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>Quản lý sản phẩm</h1>
	<main class="container">
		<a href="admin.jsp" class="btn-back">Hủy</a>
		<form action="productDAO" method="post" class="add-product">
			<input type="hidden" name="command" value="add">
			<div>
				<label>Id:</label> <input type="text" placeholder="ID" name="id"
					required>
			</div>
			<div>
				<label>Name:</label> <input type="text" placeholder="Name"
					name="name" required>
			</div>
			<div>
				<label>Cost:</label> <input type="text" placeholder="Cost"
					name="cost" required>
			</div>
			<div>
				<label>Discount:</label> <input type="text" placeholder="Discount"
					name="discount">
			</div>
			<div>
				<label>Image:</label> <input type="text" placeholder="Base64 Image"
					name="image">
			</div>
			<div>
				<label>Image Detail:</label> <input type="text"
					placeholder="Base 64 Image Detail" name="imageDetail">
			</div>
			<div>
				<label>Brand Id:</label> <input type="text" placeholder="Brand Id"
					name="brandId" required>
			</div>
			<div>

				<input type="submit" value="Thêm">
			</div>

		</form>

	</main>




</body>

</html>