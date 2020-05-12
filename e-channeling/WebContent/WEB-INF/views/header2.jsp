<header >
     <%
    response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxiy
    session.getAttribute("id");
           if(session.getAttribute("email") == null)
               response.sendRedirect("patientLogin.jsp");
    %>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <!--Navbar -->
        <nav class="mb-1 navbar navbar-expand-lg navbar-dark info-color " style="background-color: rgb(0, 0, 0);font-size: 18px;">
            <a class="navbar-brand" href="doctorDashbord.jsp"><img src="images/logo.png" alt=""></a>
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
              <a href ="updateDoctor.jsp">
                  <div class="img" style="background-image: url(images/logo.jpg);"></div></a>
                  <h3>${email}</h3>
              </div>
          </div>
    <ul class="list-unstyled components mb-5">
      <li class="active">
        <a href="doctorDashbord.jsp"><span class="fa fa-home mr-3"></span> Dashbord</a>
      </li>
      <li>
          <a href="approveReject.jsp"><span class="fa fa-download mr-3 notif"><small class="d-flex align-items-center justify-content-center">5</small></span>Approve Pending Request</a>
      </li>
      <li>
        <a href="addShedule.jsp"><span class="fa fa-gift mr-3"></span>Add Schedule</a>
      </li>
      <li>
        <a href="updateSchedule.jsp"><span class="fa fa-trophy mr-3"></span>Update Schedule</a>
      </li>
      <li>
        <a href="addTreatment.jsp"><span class="fa fa-cog mr-3"></span>Add Treatment Details</a>
      </li>
      <li>
      <li>
        <a href="viewAllAppointment.jsp"><span class="fa fa-cog mr-3"></span>View All Appointment</a>
      </li>
      <li>
        <a href="viewPatientDetails.jsp"><span class="fa fa-support mr-3"></span>View Patient Details</a>
      </li>
      <li>
        <a href="viewFeedback.jsp"><span class="fa fa-support mr-3"></span>View FeedBack</a>
      </li>
    </ul>

    </nav>