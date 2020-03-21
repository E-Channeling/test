<!DOCTYPE html>
<html lang="en">
<head>
    <title>Hello World</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Swiper CSS -->
    <link rel="stylesheet" href="css/swiper.min.css">

    <!-- Styles -->
    <link rel="stylesheet" href="style.css">
    <script src="js/custom.js"></script>
    
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <header class="site-header">
        <div class="nav-bar">
            <div class="container">
                <div class="row">
                    <div class="col-12 d-flex flex-wrap justify-content-between align-items-center">
                        <div class="site-branding d-flex align-items-center">
                           <a class="d-block" href="index.jsp" rel="home"><img class="d-block" src="images/logo.png" alt="logo"></a>
                        </div><!-- .site-branding -->

                        <nav class="site-navigation d-flex justify-content-end align-items-center">
                            <ul class="d-flex flex-column flex-lg-row justify-content-lg-end align-items-center">
                                <li class="current-menu-item"><a href="index.jsp">Home</a></li>
                                <li><a href="#">About us</a></li>
                                <li><a href="#">Services</a></li>
                                <li><a href="#">News</a></li>
                                <li><a href="#">Contact</a></li>

                                <!--  class="call-btn button gradient-bg mt-3 mt-md-0">
                                    <a class="d-flex justify-content-center align-items-center" href="#"><img src="images/emergency-call.png"> +34 586 778 8892</a>
                                </li-->
                            </ul>
                        </nav><!-- .site-navigation -->

                        <div class="hamburger-menu d-lg-none">
                            <span></span>
                            <span></span>
                            <span></span>
                            <span></span>
                        </div><!-- .hamburger-menu -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .nav-bar -->

        <div class="swiper-container hero-slider">
            <div class="swiper-wrapper">
                <div class="swiper-slide hero-content-wrap" style="background-image: url('images/hero.jpg')">
                    <div class="hero-content-overlay position-absolute w-100 h-100">
                        <div class="container h-100">
                            <div class="row h-100">
                                <div class="col-12 col-lg-6 d-flex flex-column justify-content-center align-items-start">
                                    <header class="entry-header">
                                        <h1>The Best Way<br>Appoiment Doctor</h1>
                                    </header><!-- .entry-header -->
												
												
<div class="text-center">
  
</div>								
												
												
												
                                    <!--div class="entry-content mt-4">
                                        <p>fast way appoiment doctor</p>
                                    </div--><!-- .entry-content -->

                                    <footer class="entry-footer d-flex flex-wrap align-items-center mt-4">
                                        <a href="#" class="button gradient-bg" data-toggle="modal" data-target="#modalLoginForm">Admin Login</a>
                                        <a href="#" class="button gradient-bg" data-toggle="modal" data-target="#modalLoginForm">Doctor Login</a> 
                                        <a href="#" class="button gradient-bg" data-toggle="modal" data-target="#modalLoginForm">Patient Login</a>
                                    </footer><!-- .entry-footer -->
                                </div><!-- .col -->
                            </div><!-- .row -->
                        </div><!-- .container -->
                    </div><!-- .hero-content-overlay -->
                </div><!-- .hero-content-wrap -->



                

            <div class="pagination-wrap position-absolute w-100">
                <div class="swiper-pagination d-flex flex-row flex-md-column"></div>
            </div><!-- .pagination-wrap -->
        </div><!-- .hero-slider -->
    </header><!-- .site-header -->

			<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
			  aria-hidden="true">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header text-center">
			        <h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
			          <span aria-hidden="true">&times;</span>
			        </button>
			      </div>
			      <div class="modal-body mx-3">
			        <div class="md-form mb-5">
			          <i class="fas fa-envelope prefix grey-text"></i>
			          <input type="email" id="defaultForm-email" class="form-control validate">
			          <label data-error="wrong" data-success="right" for="defaultForm-email">Your email</label>
			        </div>
			
			        <div class="md-form mb-4">
			          <i class="fas fa-lock prefix grey-text"></i>
			          <input type="password" id="defaultForm-pass" class="form-control validate">
			          <label data-error="wrong" data-success="right" for="defaultForm-pass">Your password</label>
			        </div>
			
			      </div>
			      <div class="modal-footer d-flex justify-content-center">
			        <button class="btn btn-default">Login</button>
			      </div>
			    </div>
			  </div>
			</div>

    <footer class="site-footer">
        <div class="footer-widgets">
            <div class="container">
                <div class="row">
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="foot-about">
                            <h2><a href="#"><img src="images/logo.png" alt=""></a></h2>

                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris scelerisque, at rutrum nulla dictum. Ut ac ligula sapien.</p>

                            <p class="copyright"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                        </div><!-- .foot-about -->
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-4 mt-5 mt-md-0">
                        <div class="foot-contact">
                            <h2>Contact</h2>

                            <ul class="p-0 m-0">
                                <li><span>Addtress:</span>Mitlton Str. 26-27 London UK</li>
                                <li><span>Phone:</span>+53 345 7953 32453</li>
                                <li><span>Email:</span>yourmail@gmail.com</li>
                            </ul>
                        </div>
                    </div><!-- .col -->

                    <div class="col-12 col-md-6 col-lg-4 mt-5 mt-md-0">
                        <div class="foot-links">
                            <h2>Usefull Links</h2>

                            <ul class="p-0 m-0">
                                <li><a href="index.jsp">Home</a></li>
                                <li><a href="about.html">About us</a></li>
                                <li><a href="#">Departments</a></li>
                                <li><a href="contact.html">Contact</a></li>
                                <li><a href="news.html">FAQ</a></li>
                                <li><a href="services.html">Testimonials</a></li>
                            </ul>
                        </div><!-- .foot-links -->
                    </div><!-- .col -->
                </div><!-- .row -->
            </div><!-- .container -->
        </div><!-- .footer-widgets -->
    </footer><!-- .site-footer -->

    <script type='text/javascript' src='js/jquery.js'></script>
    <script type='text/javascript' src='js/jquery.collapsible.min.js'></script>
    <script type='text/javascript' src='js/swiper.min.js'></script>
    <script type='text/javascript' src='js/jquery.countdown.min.js'></script>
    <script type='text/javascript' src='js/circle-progress.min.js'></script>
    <script type='text/javascript' src='js/jquery.countTo.min.js'></script>
    <script type='text/javascript' src='js/jquery.barfiller.js'></script>
    <script type='text/javascript' src='js/custom.js'></script>
</body>
</html>