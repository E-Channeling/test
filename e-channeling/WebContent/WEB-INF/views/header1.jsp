<header>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!--Navbar -->
        <nav class="mb-1 navbar navbar-expand-lg navbar-dark info-color " style="background-color: black;font-size: 16px; box-shadow:black;">
            <a class="navbar-brand" href="patientDashbord.jsp"><img src="images/logo.png" alt=""></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
            aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
            <ul class="navbar-nav ml-auto nav-flex-icons">
              <li class="nav-item">
              <form method="post" action="LogoutServlat">
                <input type="submit" value="Logout">
                <!-- a class="nav-link" href="index.jsp" style="color: black;font-weight:bold;">Logout</a-->
                </li>
              </form>
                <li class="nav-item avatar">
                </li>
            </ul>
            </div>
        </nav>
    </header>

    <div class="wrapper d-flex align-items-stretch">
        <nav id="sidebar" style="background-color: blue;">
            <div class="custom-menu">
                <button type="button" id="sidebarCollapse" class="btn btn-primary">
        </button>
    </div>
          <div class="img bg-wrap text-center py-4" style="background-image: url(images/bg_1.jpg);">
              <div class="user-logo">
                  <a href="updatePatient.jsp"><div class="img" style="background-image: url(images/logo.jpg);"></div></a>
                  <h3>${email}</h3>
              </div>
          </div>
    <ul class="list-unstyled components mb-5">
      <li class="active">
        <a href="patientDashbord.jsp"><span class="fa fa-home mr-3"></span> Dashbord</a>
      </li>
      <li>
          <a href="patientHome.jsp"><span class="fa fa-download mr-3 notif"><small class="d-flex align-items-center justify-content-center">5</small></span> Channel Doctor</a>
      </li>
      <li>
        <a href="viewBooking.jsp"><span class="fa fa-gift mr-3"></span> View Booking</a>
      </li>
      <li>
        <a href="cancelBook.jsp"><span class="fa fa-trophy mr-3"></span> Cancel Book</a>
      </li>
      <li>
        <a href="searchDoctor.jsp"><span class="fa fa-cog mr-3"></span> Search Doctor</a>
      </li>
      <li>
        <a href="feedback.jsp"><span class="fa fa-support mr-3"></span> FeedBack</a>
      </li>
    </ul>

    </nav>