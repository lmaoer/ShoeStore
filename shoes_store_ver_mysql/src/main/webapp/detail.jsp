<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Thế giới giày</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style.css"> 
<link rel="stylesheet" href="css/global.css">
<link rel="icon" href="img/icon_title.png" type="image/icon type">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

</head>



<body>
	<div class="main">
		<div class="header"></div>
		<div class="header2">
			<div class="header2-title">
				SẢN PHẨM CHÍNH HÃNG 100% | Hotline: <span>0362957746</span>
			</div>
			<div class="login-register">
				<i class="far fa-user"></i><a style="margin-left:10px" href="info.jsp">${sessionScope.user==null?"":sessionScope.user.name}</a>  <span style="display:${sessionScope.user==null?"":"none"}"><a href="login">Đăng nhập</a> | <a href="register.jsp">Đăng
					ký</a> <a href="cart" style="margin-left: 20px;"></span><i
					class="fas fa-shopping-cart"></i> <span class="cart-quantity">${sessionScope.list_orders.size()>0?sessionScope.list_orders.size():"0"}</span></a>
			</div>
		</div>
		<div class="nav">
			<div class="logo">
				<a href="index.jsp"><img src="img/shop_logo.jpg" alt=""></a>
			</div>
			<ul class="menu">
				<li><a href="index.jsp">trang chủ</a></li>
				<li><a href="about.jsp">giới thiệu</a></li>
				<li><a href="product">sản phẩm <i class="fa fa-angle-down"></i></a>
					<ul class="product-menu">

						<c:forEach var="b" items="${list_brands}">
							<li><a href="product?brand=${b.id}">${b.name}</a></li>
						</c:forEach>

					</ul></li>
				<li><a href="news.jsp">tin tức</a></li>
				<li><a href="contact.jsp">liên hệ</a></li>
			</ul>
		</div>

		<div class="subnav">
			<p>
				<a href="index.jsp">Trang chủ</a> <i
					class="fas fa-angle-double-right"></i> <a href="product">Tất cả
					sản phẩm</a> <i class="fas fa-angle-double-right"></i> <span>${item.name}
					| ${item.id}</span>
			</p>
		</div>

		<p style="color: red">${msg}</p>

		<div class="container-detail">
			<div class="product-detail">
				<img src="img/products_img/${item.image}" alt="">
				<div class="product-information">
					<h3 class="product-name-id">${item.name} | ${item.id}</h3>
					<ul class="describe-list">
						<li><label>Hãng:</label> ${item.brand.name}</li>
						<li><label>Mã: </label> ${item.id}</li>
						<li><label>Tình trạng:</label> ${item.status=='1'?"Còn hàng":"Hết hàng"}</li>
						<ul>
							<li>Sản phẩm chính hãng 100%</li>
							<li>Hỗ trợ đổi size, đổi mẫu, (yêu cầu sản phẩm còn mới
								100%)</li>
							<li>Giá sản phẩm sẽ thay đổi theo thời gian</li>
							<li>Liên hệ fanpage Facebook để được tự vấn <a href=""
								style="color: #337ab7">Tại đây</a>
							</li>
							<li>Liên hệ qua Zalo để được tự vấn <a href=""
								style="color: #337ab7">Tại đây</a></li>
						</ul>
					</ul>
					<span
						style="color: #3dc8f6; font-size: 38px; padding: 10px 8px 10px 0"><fmt:formatNumber
							type="number" maxFractionDigits="3"
							value="${item.cost-item.cost*item.discount/100}" /> đ</span> <span
						style="text-decoration: line-through; color: #8e8e8e"><fmt:formatNumber
							type="number" maxFractionDigits="3" value="${item.cost}" /> đ</span>
					<form class="add-cart-form" action="cart" method="post">
						<input type="hidden" name="item_id" value="${item.id}">
						<label style="margin-right: 50px;">Số lượng</label>
						<button class="btn-quantity decrease">-</button>
						<input type="text" readonly value="1" name="quantity"
							id="quantity">
						<button class="btn-quantity increase">+</button>
						<button class="add-to-cart-btn">
							<i class="fas fa-cart-plus"></i> Thêm vào giỏ
						</button>
					</form>
				</div>
			</div>

			<div>
				<div class="heading-detail" style="color: #3dc8f6; font-size: 18px;">
					<i class="fas fa-info-circle"></i> chi tiết sản phẩm
				</div>
				<div>
					<img src="img/products_img/${item.imageDetail}" alt="">
				</div>
			</div>
			<div class="heading-detail" style="margin: 8px 0">
				<i class="fas fa-shopping-bag"></i> Hướng dẫn mua hàng
			</div>
			<div class="heading-detail">
				<i class="fas fa-star-half-alt"></i> Đánh giá
			</div>

			<div style="margin-top: 40px">
				<div class="heading-detail">
					<a href="product">Sản phẩm liên quan</a>
				</div>
				<div class="related-product">
					<c:forEach var="i" items="${products_list}">
						<div class="related-item"
							onclick="window.location.href = 'detail?id=${i.id}'">
							<img src="img/products_img/${i.image}" alt="">
							<p style="min-height: 100px" class="product-name">${i.name } | ${i.id }</p>
							<span class="product-price"><fmt:formatNumber
									type="number" maxFractionDigits="3"
									value="${i.cost-item.cost*item.discount/100}" /> đ</span><br>
							<span class="product-cost"><fmt:formatNumber type="number"
									maxFractionDigits="3" value="${i.cost}" /> đ</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="ship-title">
			<i class="fas fa-truck icon-ship"></i> <label>VẬN CHUYỂN:</label> Hỗ
			trợ ship COD toàn quốc
		</div>

		<div class="footer">
			<div class="footer-container">
				<div class="about">
					<div class="logo">
						<a href="index.jsp"><img src="img/shop_logo.jpg" alt=""></a>
					</div>
					<h4 style="padding-top: 40px;">Về chúng tôi</h4>
					<ul class="footer-menu">
						<li><a href="about.jsp">Giới thiệu</a></li>
						<li><a href="product">Sản phẩm</a></li>
						<li><a href="news.jsp">Tin tức</a></li>
						<li><a href="#">Đối tác</a></li>
						<li><a href="contact.jsp">Liên hệ</a></li>
					</ul>
				</div>
				<div class="address">
					<h4>THẾ GIỚI GIÀY - 100% AUTHENTIC</h4>
					<ul>
						<li><span>96A Trần Phú, P. Mộ Lao, Hà Đông, Hà Nội</span></li>
						<li><span>Hotline: 0362957746</span></li>
						<li><span>Email: longdq.ptit@gmail.com</span></li>
					</ul>
				</div>
				<div>
					<h4>Kết nối với chúng tôi</h4>
					<div class="row-footer">
						<div>
							<i class="fab fa-facebook-f"></i>
						</div>
						<div>
							<i class="fab fa-twitter"></i>
						</div>
						<div>
							<i class="fab fa-instagram"></i>
						</div>
						<div>
							<i class="fas fa-envelope"></i>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- test cart -->
	<%-- <br>
	${sessionScope.list_orders.size()}
	<br>
	<ul>
	<c:forEach var="temp" items="${sessionScope.list_orders}">
		<li>${temp.product.name} | ${temp.quantity}</li>
	</c:forEach>
	</ul> --%>
	
	<script type="text/javascript">
	const decreaseBtn = document.querySelector('.decrease');
	const increaseBtn = document.querySelector('.increase');
	const quantity = document.querySelector('#quantity');
	
	decreaseBtn.addEventListener('click', function(e){
		e.preventDefault();
		if(quantity.value > 1){
			quantity.value -= 1;
		}
	})

	increaseBtn.addEventListener('click', function(e){
		e.preventDefault();
		quantity.value = parseInt(quantity.value)+1;
	})
	</script>
	
	<script type="text/javascript" src="js/script.js"></script>
	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	
	
	<!-- Messenger Plugin chat Code -->
    <div id="fb-root"></div>

    <!-- Your Plugin chat code -->
    <div id="fb-customer-chat" class="fb-customerchat">
    </div>

    <script>
      var chatbox = document.getElementById('fb-customer-chat');
      chatbox.setAttribute("page_id", "107839248588620");
      chatbox.setAttribute("attribution", "biz_inbox");
    </script>

    <!-- Your SDK code -->
    <script>
      window.fbAsyncInit = function() {
        FB.init({
          xfbml            : true,
          version          : 'v13.0'
        });
      };

      (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
        fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));
    </script>
</body>

</html>