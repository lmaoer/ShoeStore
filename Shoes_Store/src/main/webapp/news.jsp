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

        <div class="news-container">
            <h2>Tin tức</h2>
            <div class="news-row">
            	<a href="https://authentic-shoes.com/blogs/news/mua-he-di-gi-diem-mat-cac-phoi-mau-sieu-hot-cua-yeezy-slide">       
                <div class="news-item">
                    <div class="img-news">
                        <img src="img/news1.jpg" alt="">
                    </div>
                    <div class="news-content">
                        <h4><a
                                href="https://authentic-shoes.com/blogs/news/mua-he-di-gi-diem-mat-cac-phoi-mau-sieu-hot-cua-yeezy-slide">Mùa
                                hè đi gì? Điểm mặt các phối màu siêu hot của Yeezy Slide</a></h4>
                        <p>Mùa hè - mùa của những kỳ nghỉ, những chuyến du lịch đã đến. Năm nay, mùa hè có vẻ như sẽ rộn
                            ràng hơn khi ngành du lịch được mở cửa trở lại...</p>
                    </div>
                </div>
                </a>
                <a href="https://authentic-shoes.com/blogs/news/run-star-motion-lieu-co-la-dong-giay-lon-nhat-cua-converse">
                <div class="news-item">
                    <div class="img-news">
                        <img src="img/new2.jpg" alt="">
                    </div>
                    <div class="news-content">
                        <h4><a
                                href="https://authentic-shoes.com/blogs/news/run-star-motion-lieu-co-la-dong-giay-lon-nhat-cua-converse">Run
                                Star Motion liệu có là dòng giày "lớn nhất" của Converse ?</a></h4>
                        <p>Khi bạn nghĩ về các bản phát hành giày nổi tiếng, gây xôn xao cộng đồng sneaker head, nhiều
                            khả năng bạn sẽ có một bản cộng tác độc quyền hoặc một phiên bản giới hạn. Bạn sẽ nhận...
                        </p>
                    </div>
                </div>
                </a>
                <a href="https://authentic-shoes.com/blogs/news/legitcheck-cach-phan-biet-cactus-jack-dunk-real-va-fake">
                <div class="news-item">
                    <div class="img-news">
                        <img src="img/news3.jpg" alt="">
                    </div>
                    <div class="news-content">
                        <h4><a
                                href="https://authentic-shoes.com/blogs/news/legitcheck-cach-phan-biet-cactus-jack-dunk-real-va-fake">Legitcheck:
                                Cách phân biệt đôi giày Nike SB Dunk Low Travis Scottreal va fake</a></h4>
                        <p>Dunk và SB Dunk đã là một trong những mẫu bán chạy nhất trong shoes game. Nike và Travis
                            Scott đã cho ra mắt một phiên bản collab đươc ra mắt chính thức vào ngày 22/02/2020. Và...
                        </p>
                    </div>
                </div>
                </a>
            </div>
            <div class="news-row">
            	<a href="https://authentic-shoes.com/blogs/news/fear-of-god-ong-hoang-cua-de-che-thoi-trang-duong-dai">
                <div class="news-item">
                    <div class="img-news">
                        <img src="img/news4.jpg" alt="">
                    </div>
                    <div class="news-content">
                        <h4><a
                                href="https://authentic-shoes.com/blogs/news/fear-of-god-ong-hoang-cua-de-che-thoi-trang-duong-dai">Fear
                                Of God ông hoàng của đế chế thời trang đương đại</a></h4>
                        <p>Fear of God là một trong những cái tên khá quen thuộc trong làng Underground với những thiết
                            kế mang đậm tính chất đường phố. Nó trở thành một trong những thương hiệu vô cùng sáng...
                        </p>
                    </div>
                </div>
                </a>
                <a href="https://authentic-shoes.com/blogs/news/10-doi-yeezys-dep-nhat-co-the-di-vao-mua-he">
                <div class="news-item">
                    <div class="img-news">
                        <img src="img/news5.jpg" alt="">
                    </div>
                    <div class="news-content">
                        <h4><a
                                href="https://authentic-shoes.com/blogs/news/10-doi-yeezys-dep-nhat-co-the-di-vao-mua-he">Những
                                hình ảnh đầu tiên của phiên bản adidas UltraBOOST 23</a></h4>
                        <p>UltraBoost của Adidas là một trong những đôi giày chạy bộ nổi tiếng nhất thế giới. Dòng giày
                            này luôn được Adidas tích hợp những công nghệ tốt nhất trong lĩnh vực sản xuất giày ...
                        </p>
                    </div>
                </div>
                </a>
                <a href="https://authentic-shoes.com/blogs/news/dj-khaled-gioi-thieu-bst-air-jordan-5-we-the-best-sap-ra-mat-cua-anh-ay">
                <div class="news-item">
                    <div class="img-news">
                        <img src="img/news6.jpg" alt="">
                    </div>
                    <div class="news-content">
                        <h4><a
                                href="https://authentic-shoes.com/blogs/news/dj-khaled-gioi-thieu-bst-air-jordan-5-we-the-best-sap-ra-mat-cua-anh-ay">DJ
                                Khaled giới thiệu BST Air Jordan 5 "We The Best" sắp ra mắt của anh ấy</a></h4>
                        <p>DJ Khaled là một trong những nghệ sĩ hip-hop nổi tiếng nhất hiện nay. Anh ấy đã trở nên nổi
                            tiếng và hiện đang có được những thành công vang dội. Nhà sản xuất nổi tiếng, nhân vật......
                        </p>
                    </div>
                </div>
                </a>
            </div>


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


        <div class="contact">
            <i class="fab fa-facebook-messenger"></i>
        </div>

    </div>

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="js/script.js"></script>
</body>

</html>