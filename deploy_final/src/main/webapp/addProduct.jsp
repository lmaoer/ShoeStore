<html>

<body>

<form action="addProductBase64" method="POST">
<!-- (id,name,cost,discount,image:base64,imageDetail:base64,brandId) -->
<input type="text" placeholder="id" name="id"><br>
<input type="text" placeholder="name" name="name"><br>
<input type="text" placeholder="cost" name="cost"><br>
<input type="text" placeholder="discount" name="discount"><br>
<input type="text" placeholder="image" name="image"><br>
<input type="text" placeholder="imageDetail" name="imageDetail"><br>
<input type="text" placeholder="brandId" name="brandId"><br>
<input type="submit" value="submit">
</form>
<p style="color:red">${success }</p>
</body>

</html>