<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						
					</ul></li>
				<li><a href="news.jsp">tin tức</a></li>
				<li><a href="contact.jsp">liên hệ</a></li>
			</ul>
		</div>

		<div class="banner-about">
			<div>
				<h2>Người bạn đồng hành hoàn hảo</h2>
				<strong>Sứ mệnh của chúng tôi là kết hợp hài hòa giữa ý
					tưởng và mong muốn của khách hàng, đem lại những trải nghiệm tuyệt
					vời !</strong>
			</div>
		</div>
		<div class="introduce-box">
			<h2>THÀNH LẬP & PHÁT TRIỂN</h2>
			<div class="row-introduce-box">
				<div>
					<img src="img/introduce_img1.jpg" alt="">
				</div>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
					Libero hic alias omnis ratione eius sint obcaecati aliquam
					quibusdam, amet maxime, dolore dolor, sunt eligendi consequatur
					delectus quis reprehenderit nisi repellendus. Lorem ipsum dolor sit
					amet consectetur adipisicing elit. Nemo velit nulla dolore culpa
					sequi laboriosam qui ipsam modi sapiente iusto delectus odit
					architecto suscipit provident id blanditiis, eius tenetur facere!</p>
			</div>
		</div>
		<div class="introduce-box">
			<h2>TẦM NHÌN</h2>
			<div class="row-introduce-box">
				<div>
					<img src="img/jogging-2343558_1280.jpg" alt="">
				</div>
				<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
					Libero hic alias omnis ratione eius sint obcaecati aliquam
					quibusdam, amet maxime, dolore dolor, sunt eligendi consequatur
					delectus quis reprehenderit nisi repellendus. Lorem ipsum dolor sit
					amet consectetur adipisicing elit. Nemo velit nulla dolore culpa
					sequi laboriosam qui ipsam modi sapiente iusto delectus odit
					architecto suscipit provident id blanditiis, eius tenetur facere!</p>
			</div>
		</div>

		<div class="duty">
			<div class="duty-item">
				<div>
					<img src="img/voi-xa-hoi.png" alt="">
				</div>

				<div class="duty-content">
					<h4>VỚI XÃ HỘI</h4>
					<p>Hài hòa lợi ích doanh nghiệp với lợi ích xã hội sống bền
						vững.</p>
				</div>
			</div>
			<div class="duty-item">
				<div>
					<img src="img/voi-nhan-vien.jpg" alt="">
				</div>
				<div class="duty-content">
					<h4>VỚI NHÂN VIÊN</h4>
					<p>Xây dựng môi trường làm việc chuyên nghiệp, năng động, sáng
						tạo và nhân văn.</p>
				</div>
			</div>
			<div class="duty-item">
				<div>
					<img src="img/voi-doi-tac.jpg" alt="">
				</div>
				<div class="duty-content">
					<h4>VỚI ĐỐI TÁC</h4>
					<p>Xây dựng môi trường làm việc chuyên nghiệp, năng động, sáng
						tạo và nhân văn.</p>
				</div>
			</div>
			<div class="duty-item">
				<div>
					<img src="img/voi-thi-truong.png" alt="">
				</div>
				<div class="duty-content">
					<h4>VỚI THỊ TRƯỜNG</h4>
					<p>Cung cấp các sản phẩm với chất lượng quốc tế và phù hợp với
						con người Việt Nam.</p>
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


		

	</div>

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script type="text/javascript" src="js/script.js"></script>
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