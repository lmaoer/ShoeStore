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
		<div class="main-nav">
			<a href="add_product.jsp" class="btn">Thêm sản phẩm</a> <input
				type="text" placeholder="Search" search>
		</div>

		<table class="grid">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Cost</th>
					<th>Discount</th>
					<th>Image</th>
					<th>Image Detail</th>
					<th>Brand</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody class="products">
				<!-- <tr>
					<td>159816</td>
					<td>One Star Ox</td>
					<td>1750000</td>
					<td>12</td>
					<td><img src="img/products/product-img-test-1.jpg" alt=""></td>
					<td><img src="img/products/product-img-test-2.jpg" alt=""></td>
					<td>4</td>
					<td><a href="#"
						onclick="if (!(confirm('Are you sure you want to delete this product?'))) return false">XÓA</a>
						<span>|</span> <a href="#">SỬA</a></td>
				</tr> -->
			</tbody>

		</table>
		<p class="more">
			<a href="#" class="loadmore-btn">Xem thêm...</a>
		</p>


	</main>

	<script type="text/javascript">
		console.log("${message}");
		
		const list=[];
		fetch("/shoes_store_dashboard/load/"+0)
		  .then((response) => {
		    console.log(response);
		    if (!response.ok) throw new Error(`Request failed`);
		    return response.json();
		  })
		  .then((data) => {
		    const keys = Object.keys(data);

		    keys.forEach((key) => {
		      list.push(data[key]);
		    });

		    for (p of list) {
		      let html =
		        "<tr product><td>" +
		        p["id"] +
		        "</td><td>" +
		        p["name"] +
		        "</td><td>" +
		        p["cost"] +
		        "</td><td>" +
		        p["discount"] +
		        '</td><td><img src="data:image/jpg;base64,' +
		        p["image"] +
		        '" alt=""></td><td><img src="data:image/jpg;base64,' +
		        p["imageDetail"] +
		        '" alt=""></td><td>' +
		        p["brand"]["id"] +
		        '</td><td><a href="productDAO?command=delete&id=' +
		        p["id"] +
		        '" onclick="if (!(confirm(\'Are you sure you want to delete this product?\'))) return false">XÓA</a><span>|</span> <a href="productDAO?command=load&id=' +
		        p["id"] +
		        '">SỬA</a></td></tr>';

		      document.querySelector(".products").insertAdjacentHTML("beforeend", html);
		    }
		  });
		
		document.querySelector('.loadmore-btn').addEventListener('click', function (e) {
            e.preventDefault();
            console.log(document.querySelectorAll('tr[product]').length);
            
            const list = [];
            fetch("/shoes_store_dashboard/load/"+document.querySelectorAll('tr[product]').length)
                .then((response) => {
                    console.log(response);
                    if (!response.ok) throw new Error(`Request failed`);
                    return response.json();
                })
                .then((data) => {
                    const keys = Object.keys(data);

                    keys.forEach((key) => {
                        list.push(data[key]);
                    });

                    for (p of list) {
                        let html =
                            "<tr product><td>" +
                            p["id"] +
                            "</td><td>" +
                            p["name"] +
                            "</td><td>" +
                            p["cost"] +
                            "</td><td>" +
                            p["discount"] +
                            '</td><td><img src="data:image/jpg;base64,' +
                            p["image"] +
                            '" alt=""></td><td><img src="data:image/jpg;base64,' +
                            p["imageDetail"] +
                            '" alt=""></td><td>' +
                            p["brand"]["id"] +
                            '</td><td><a href="productDAO?command=delete&id=' +
                            p["id"] +
                            '" onclick="if (!(confirm(\'Are you sure you want to delete this product?\'))) return false">XÓA</a><span>|</span> <a href="productDAO?command=load&id=' +
                            p["id"] +
                            '">SỬA</a></td></tr>';

                        document.querySelector(".products").insertAdjacentHTML("beforeend", html);
                    }
                });
        })
		
		    
	</script>
</body>

</html>