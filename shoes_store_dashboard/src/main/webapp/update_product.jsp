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
        	<input type="hidden" name="command" value="update">
            <div>
                <label>Id:</label>
                <input type="text" value="${p.id}" name="id" readonly="readonly">
            </div>
            <div>
                <label>Name:</label>
                <input type="text" value="${p.name}" name="name" required>
            </div>
            <div>
                <label>Cost:</label>
                <input type="text" value="${p.cost}" name="cost" required>
            </div>
            <div>
                <label>Discount:</label>
                <input type="text" value="${p.discount}" name="discount">
            </div>
            <div>
                <label>Image:</label>
                
                <input type="text" placeholder="Base64 Image" name="image" value="${p.image}">
            </div>
            <div>
            	<img alt="" src="data:image/jpg;base64,${p.image}">
            </div>
            <div>
                <label>Image Detail:</label>
                <input type="text" placeholder="Base 64 Image Detail" name="imageDetail" value="${p.imageDetail}">
            </div>
            <div>
            	<img alt="" src="data:image/jpg;base64,${p.imageDetail}">
            </div>
            <div>
                <label>Brand Id:</label>
                <input type="text" value="${p.brand.id}" name="brandId" required>
            </div>
            <div>

                <input type="submit" value="Cập nhật">
            </div>

        </form>

    </main>




</body>

</html>