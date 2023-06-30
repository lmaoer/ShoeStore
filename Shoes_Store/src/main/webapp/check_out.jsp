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
	<div class="my-modal-orders" style="display:${requestScope.orders_msg eq null?"none":""}">
		<div class="success-orders" >
			<p style="text-align: center; padding: 30px 0;">
				<i style="font-size:160px;color:green" class="fas fa-check-circle"></i>
			</p>
			<p style="color: green; font-size: 25px; text-align: center;">${requestScope.orders_msg }</p>
			<div class="success-orders-back" onclick="window.location.href='product'">Quay về trang mua
				hàng</div>
		</div>
	</div>

	<div class="main">
		<div class="header"></div>
		<div class="header2">
			<div class="header2-title">
				SẢN PHẨM CHÍNH HÃNG 100% | Hotline: <span>0362957746</span>
			</div>
			<div class="login-register">
				<i class="far fa-user"></i><a style="margin-left: 10px"
					href="info.jsp">${sessionScope.user==null?"":sessionScope.user.name}</a>
				<span style="display:${sessionScope.user==null?"":"none"}"><a
					href="login">Đăng nhập</a> | <a href="register.jsp">Đăng ký</a> <a
					href="cart" style="margin-left: 20px;"></span><i
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

		<div class="subnav" style="margin-bottom: 0">
			<p>
				<a href="index.jsp">Trang chủ</a> <i
					class="fas fa-angle-double-right"></i> <a href="cart">Giỏ hàng</a>
				<i class="fas fa-angle-double-right"></i> Thanh toán
			</p>
		</div>

		<div class="checkout-container">
			<div class="checkout-info-user">
				<h2>Thông tin giao hàng</h2>
				<ul class="checkout-ul">
					<li><label>Họ và tên</label><span>${sessionScope.user.name}</span></li>
					<li><label>Số điện thoại</label><span>${sessionScope.user.phone}</span></li>
					<li><input
						style="width: 90%; border: 1px solid #ccc; padding: 4px 20px;"
						type="text" placeholder="Địa chỉ"></li>
				</ul>



				<h2>Phương thức vận chuyển</h2>
				<div class="shipping-box">
					<div>
						<i style="font-size: 112px; opacity: 0.9; padding: 10px 100px;"
							class="fas fa-archive"></i>
						<p>Vui lòng chọn phương thức vận chuyển</p>
					</div>
				</div>
				<h2 style="margin: 16px 0 8px 0">Phương thức thanh toán</h2>
				<div style="padding: 10px 0">
					<input name="rd" id="radio-btn1" type="radio"><label
						for="radio-btn1">Thanh toán bằng thẻ ATM/Visa/Master/JCB</label>
				</div>
				<div style="padding: 10px 0">
					<input name="rd" id="radio-btn2" type="radio"><label
						for="radio-btn1">Thanh toán khi nhận hàng</label>
				</div>

				<div class="wrap-checkout">
					<div class="cart-check" onclick="window.location.href='cart'">
						<i class="fas fa-angle-left"></i> Giỏ hàng
					</div>
					<div class="confirm-checkout"
						onclick="window.location.href='orders'">Hoàn tất đơn hàng</div>
				</div>
			</div>
			<div class="checkout-summary">
				<c:forEach var="i" items="${sessionScope.list_orders }">
					<div class="checkout-item">
						<span class="quantity-summary">${i.quantity}</span> <img
							style="width: 64px; height: 64px; border-radius: 8px" alt=""
							src="img/products_img/${i.product.image}">
						<p style="width: 300px;">${i.product.name}| ${i.product.id}</p>
						<p>
							<fmt:formatNumber type="number" maxFractionDigits="3"
								value="${i.quantity*(i.product.cost-i.product.cost*i.product.discount/100)}" />
							đ
						</p>
					</div>
				</c:forEach>
				<div class="cost-summary">
					<p>Tổng cộng</p>
					<p>
						<fmt:formatNumber type="number" maxFractionDigits="3"
							value="${sessionScope.total}" />
						đ
					</p>
				</div>
			</div>
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


		<div class="contact">
			<i class="fab fa-facebook-messenger"></i>

		</div>

	</div>

	<script type="text/javascript">
		const modal = document.querySelector('.my-modal-orders');
		const back = document.querySelector('.success-orders-back');

		modal.addEventListener('click', function() {
			modal.classList.add('hidden');
		});
		
		back.addEventListener('click', function(e) {
			e.stopPropagation();
		});
	</script>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

</body>

</html>