<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Thế giới giày</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/global.css">
    <link rel="icon" href="img/icon_title.png" type="image/icon type">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
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
            <div class="logo"><a href="index.jsp"><img src="img/shop_logo.jpg" alt=""></a></div>
            <ul class="menu">
                <li><a href="index.jsp">trang chủ</a></li>
                <li><a href="about.jsp">giới thiệu</a></li>
                <li>
                    <a href="product">sản phẩm <i class="fa fa-angle-down"></i></a>
                    <ul class="product-menu">
                        <c:forEach var="b" items="${list_brands}">
							<li><a href="product?brand=${b.id}">${b.name }</a></li>
						</c:forEach>
                    </ul>
                </li>
                <li><a href="news.jsp">tin tức</a></li>
                <li><a href="contact.jsp">liên hệ</a></li>
            </ul>
        </div>
        
        <div class="subnav">
			<p>
				<a href="index.jsp">Trang chủ</a> <i
					class="fas fa-angle-double-right"></i> Hồ sơ
			</p>
		</div>

        <div class="info-user">
        	<h1>Hồ sơ của tôi <a class="edit-btn" href="update_user.jsp"><i class="fas fa-edit"></a></i></h1>
        	
        	<div><label>Tên Đăng Nhập</label> <span>${sessionScope.user.username}</span></div>
        	<div><label>Tên </label> <span>${sessionScope.user.name}</span></div>
        	<div><label>Số điện thoại</label> <span>${sessionScope.user.phone}</span></div>
        	<div><label>Thành phố</label> <span>${sessionScope.user.city}</span></div>
        	<div><label>Mật khẩu</label> <a title="Đổi mật khẩu" href="change_password.jsp"><span>******</span></a></div>
        	
        	<div class="logout" onclick="window.location.href='user?command=logout'">Đăng xuất</div>
        </div>

        <div class="footer">
            <div class="footer-container">
                <div class="about">
                    <div class="logo"><a href="index.jsp"><img src="img/shop_logo.jpg" alt=""></a></div>
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
                        <div><i class="fab fa-facebook-f"></i></div>
                        <div><i class="fab fa-twitter"></i></div>
                        <div><i class="fab fa-instagram"></i></div>
                        <div><i class="fas fa-envelope"></i></div>
                    </div>
                </div>
            </div>
        </div>


       

    </div>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
    
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