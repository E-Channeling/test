<!DOCTYPE html>
<html lang="en">
<head>
<title>Welcome</title>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Swiper CSS -->
<link rel="stylesheet" href="css/swiper.min.css">

<!-- Styles -->
<link rel="stylesheet" href="style.css">
<script src="js/custom.js"></script>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<header class="site-header">
		<div class="nav-bar">
			<div class="container">
				<div class="row">
					<div
						class="col-12 d-flex flex-wrap justify-content-between align-items-center">
						<div class="site-branding d-flex align-items-center">
							<a class="d-block" href="index.jsp" rel="home"><img
								class="d-block" src="images/logo.png" alt="logo"></a>
						</div>
						<div class="hamburger-menu d-lg-none">
							<span></span> <span></span> <span></span> <span></span>
						</div>
						<!-- .hamburger-menu -->
					</div>
					<!-- .col -->
				</div>
				<!-- .row -->
			</div>
			<!-- .container -->
		</div>
		<!-- .nav-bar -->

		<div class="swiper-container hero-slider">
			<div class="swiper-wrapper">
				<div class="swiper-slide hero-content-wrap"
					style="background-image: url('images/hero.jpg')">
					<div class="hero-content-overlay position-absolute w-100 h-100">
						<div class="container h-100">
							<div class="row h-100">
								<div
									class="col-12 col-lg-6 d-flex flex-column justify-content-center align-items-start">
									<header class="entry-header">
										<h1>
											Admin Login
										</h1>
									</header>
										<form  class="form-signin" target="_self" action="LoginAdminServlet" method="post"> 
									        <label style="color:red">
									        <% 
									        	if(request.getAttribute("error") != null) {
									            	out.println(request.getAttribute("error"));
									        	}
									        %>
									        </label>
									        <label for="inputEmail" class="sr-only">Email address</label>
									        <input type="text" id="inputEmail" class="form-control" placeholder="userId" required autofocus name="userID">
									        <label for="inputPassword" class="sr-only">Password</label></br>
									        <input type="password" id="inputPassword" class="form-control" placeholder="Password"  name= "password" required>
									        <div class="checkbox mb-3">
									        <label>
									            <a id="fpwd" href="#">forget password</a>
									        </label>
									      </div>
									      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button></br>
									    </form>
									    
									<div class="text-center"></div>
									<!--div class="entry-content mt-4">
                                        <p>fast way appoiment doctor</p>
                                    </div-->
									<!-- .entry-content -->
									<footer class="entry-footer d-flex flex-wrap align-items-center mt-4">
										
									</footer>
									<!-- .entry-footer -->
								</div>
								<!-- .col -->
							</div>
							<!-- .row -->
						</div>
						<!-- .container -->
					</div>
					<!-- .hero-content-overlay -->
				</div>
				<!-- .hero-content-wrap -->
				<div class="pagination-wrap position-absolute w-100">
					<div class="swiper-pagination d-flex flex-row flex-md-column"></div>
				</div>
				<!-- .pagination-wrap -->
			</div>
			<!-- .hero-slider -->
	</header>
	<!-- .site-header -->

	<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Sign in</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body mx-3">
					<div class="md-form mb-5">
						<i class="fas fa-envelope prefix grey-text"></i> <input
							type="email" id="defaultForm-email" class="form-control validate">
						<label data-error="wrong" data-success="right"
							for="defaultForm-email">Your email</label>
					</div>

					<div class="md-form mb-4">
						<i class="fas fa-lock prefix grey-text"></i> <input
							type="password" id="defaultForm-pass"
							class="form-control validate"> <label data-error="wrong"
							data-success="right" for="defaultForm-pass">Your password</label>
					</div>

				</div>
				<div class="modal-footer d-flex justify-content-center">
					<button class="btn btn-default">Login</button>
				</div>
			</div>
		</div>
	</div>


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