<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<%@ page errorPage="401.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>FitnessCamp</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="" />

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,700,900" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="css/icomoon.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="css/bootstrap.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!-- Flexslider  -->
        <link rel="stylesheet" href="css/flexslider.css">

        <!-- Owl Carousel -->
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">

        <!-- Flaticons  -->
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="css/style.css">

        <!-- Modernizr JS -->
        <script src="js/modernizr-2.6.2.min.js"></script>
        <!-- FOR IE9 below -->
        <!--[if lt IE 9]>
        <script src="js/respond.min.js"></script>
        <![endif]-->

    </head>
<body>

<div class="colorlib-loader"></div>

<div id="page">
    <nav class="colorlib-nav" role="navigation">
        <div class="top-menu">
            <div class="container">
                <div class="row">
                    <div class="col-md-2">
                        <div id="colorlib-logo"><a href="index.jsp">FitnessCamp</a></div>
                    </div>
                    <div class="col-md-10 text-right menu-1">
                        <ul>
                            <li class="active"><a href="index.jsp">Главная</a></li>
                            <li class="has-dropdown">
                                <a href="classes.html">Группы</a>
                                <ul class="dropdown">
                                    <li><a href="classes-single.html">Индивидуальные занаятия</a></li>
                                    <li><a href="#">Кроссфит группа</a></li>
                                    <li><a href="#">Группа бокса</a></li>
                                    <li><a href="#">Фитнес группа</a></li>
                                    <li><a href="#">Бодибилдинг</a></li>
                                    <li><a href="#">Силовой экстрим</a></li>
                                    <li><a href="#">Йога</a></li>
                                    <li><a href="#">Степ-аэробика</a></li>
                                </ul>
                            </li>
                            <li><a href="schedule.html">Расписание</a></li>
                            <li><a href="about.html">Тренеры</a></li>
                            <li><a href="event.html">События</a></li>
                            <li><a href="blog.html">Блог</a></li>
                            <li><a href="contact.html">Контакты</a></li>
                            <c:if test="${sessionScope.statusAdmin == true || sessionScope.statusTrainer == true}">
                                <li><a href="trainerPage.jsp">Тренерская</a></li>
                            </c:if>
                            <c:if test="${sessionScope.statusAdmin == true}">
                                <li><a href=administration.jsp>Администрирование</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userId == null}">
                                <li><a href="login.html">Войти</a></li>
                            </c:if>
                            <c:if test="${sessionScope.userId != null}">
                                <li><a href="logout">Выйти</a></li>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <aside id="colorlib-hero">
        <div class="flexslider">
            <ul class="slides">
                <li style="background-image: url(images/img_bg_2.jpg);">
                    <div class="overlay"></div>
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-6 col-sm-12 col-md-offset-3 slider-text">
                                <div class="slider-text-inner text-center">
                                    <h1>Тренерская</h1>
                                    <h2><span><a href="index.jsp">Главная</a> | Тренерская</span></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </aside>

    <div class="colorlib-classes">
        <div class="container">
            <div class="row">
                <div class="col-md-4 animate-box">
                    <div class="classes">
                        <div class="classes-img" style="background-image: url(images/client.jpg);">
                        </div>
                        <div class="desc">
                            <h3><a href="createWorkoutPersonal.jsp">Записать клиента на индивидуальное занятие</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 animate-box">
                    <div class="classes">
                        <div class="classes-img" style="background-image: url(images/trainer.jpeg);">
                        </div>
                        <div class="desc">
                            <h3><a href="addClientToGroupWorkout.jsp">Добавить клиента в группу</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 animate-box">
                    <div class="classes">
                        <div class="classes-img" style="background-image: url(images/admin.jpg);">
                        </div>
                        <div class="desc">
                            <h3><a href="createWorkoutGroup.jsp">Создать групповую тренировку</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 animate-box">
                    <div class="classes">
                        <div class="classes-img" style="background-image: url(images/admin.jpg);">
                        </div>
                        <div class="desc">
                            <h3><a href="registrationAdmin.jsp">Посмотреть список клиентов занимающихся в группе</a></h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 animate-box">
                    <div class="classes">
                        <div class="classes-img" style="background-image: url(images/classes-1.jpg);">
                        </div>
                        <div class="desc">
                            <h3><a href="clientsView.jsp">Посмотреть список индивидуальных занятий</a></h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="colorlib-subscribe" class="subs-img" style="background-image: url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-8 col-md-offset-2 text-center colorlib-heading animate-box">
                    <h2>Subscribe Newsletter</h2>
                    <p>Subscribe our newsletter and get latest update</p>
                </div>
            </div>
            <div class="row animate-box">
                <div class="col-md-6 col-md-offset-3">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="form-inline qbstp-header-subscribe">
                                <div class="col-three-forth">
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="email" placeholder="Enter your email">
                                    </div>
                                </div>
                                <div class="col-one-third">
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary">Subscribe Now</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer id="colorlib-footer">
        <div class="container">
            <div class="row row-pb-md">
                <div class="col-md-3 colorlib-widget">
                    <h4>About Robust Gym</h4>
                    <p>Far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics</p>
                    <p>
                    <ul class="colorlib-social-icons">
                        <li><a href="#"><i class="icon-twitter"></i></a></li>
                        <li><a href="#"><i class="icon-facebook"></i></a></li>
                        <li><a href="#"><i class="icon-linkedin"></i></a></li>
                        <li><a href="#"><i class="icon-dribbble"></i></a></li>
                    </ul>
                    </p>
                </div>
                <div class="col-md-3 colorlib-widget">
                    <h4>Quick Links</h4>
                    <p>
                    <ul class="colorlib-footer-links">
                        <li><a href="#"><i class="icon-check"></i> About Us</a></li>
                        <li><a href="#"><i class="icon-check"></i> Testimonials</a></li>
                        <li><a href="#"><i class="icon-check"></i> Classes</a></li>
                        <li><a href="#"><i class="icon-check"></i> Blog</a></li>
                        <li><a href="#"><i class="icon-check"></i> Blog</a></li>
                        <li><a href="#"><i class="icon-check"></i> Contact</a></li>
                    </ul>
                    </p>
                </div>

                <div class="col-md-3 colorlib-widget">
                    <h4>Recent Post</h4>
                    <div class="f-blog">
                        <a href="blog.jsp" class="blog-img" style="background-image: url(images/blog-1.jpg);">
                        </a>
                        <div class="desc">
                            <h2><a href="blog.jsp">Tips for sexy body</a></h2>
                            <p class="admin"><span>18 April 2018</span></p>
                        </div>
                    </div>
                    <div class="f-blog">
                        <a href="blog.jsp" class="blog-img" style="background-image: url(images/blog-2.jpg);">
                        </a>
                        <div class="desc">
                            <h2><a href="blog.jsp">Tips for sexy body</a></h2>
                            <p class="admin"><span>18 April 2018</span></p>
                        </div>
                    </div>
                    <div class="f-blog">
                        <a href="blog.jsp" class="blog-img" style="background-image: url(images/blog-3.jpg);">
                        </a>
                        <div class="desc">
                            <h2><a href="blog.jsp">Tips for sexy body</a></h2>
                            <p class="admin"><span>18 April 2018</span></p>
                        </div>
                    </div>
                </div>

                <div class="col-md-3 colorlib-widget">
                    <h4>Contact Info</h4>
                    <ul class="colorlib-footer-links">
                        <li>291 South 21th Street, <br> Suite 721 New York NY 10016</li>
                        <li><a href="tel://1234567920"><i class="icon-phone"></i> + 1235 2355 98</a></li>
                        <li><a href="mailto:info@yoursite.com"><i class="icon-envelope"></i> info@yoursite.com</a></li>
                        <li><a href="http://luxehotel.com"><i class="icon-location4"></i> yourwebsite.com</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="copy">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p>
                            <small class="block">&copy; <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart" aria-hidden="true"></i> by <a  target="_blank">VictorPetrakov</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></small><br>
                            <small class="block">Demo Images: <a href="http://unsplash.co/" target="_blank">Unsplash</a>, <a href="http://pexels.com/" target="_blank">Pexels</a></small>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>

<div class="gototop js-top">
    <a href="#" class="js-gotop"><i class="icon-arrow-up2"></i></a>
</div>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="js/jquery.stellar.min.js"></script>
<!-- Flexslider -->
<script src="js/jquery.flexslider-min.js"></script>
<!-- Owl carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- Magnific Popup -->
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/magnific-popup-options.js"></script>
<!-- Counters -->
<script src="js/jquery.countTo.js"></script>
<!-- Main -->
<script src="js/main.js"></script>

</body>
</html>
