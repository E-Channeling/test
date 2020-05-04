<header >
	<%
		response.setHeader("Cache-Controle", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxiy
		session.getAttribute("id");
       		if(session.getAttribute("email") == null)
    	   		response.sendRedirect("patientLogin.jsp");
    %>
    <!--Navbar -->
    <nav class="mb-1 navbar navbar-expand-lg navbar-dark info-color " style="background-color: rgb(0, 0, 0);font-size: 18px;">
        <a class="navbar-brand" href="patientHome.jsp"><img src="images/logo.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-555"
        aria-controls="navbarSupportedContent-555" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-555">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
            <a class="nav-link" href="#">Channel Doctor
                <span class="sr-only">(current)</span>
            </a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="viewBooking.jsp">View Booking</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="cancelBook.jsp">Cancel Book</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="searchDoctor.jsp">Search Doctor</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="feedback.jsp">FeedBack</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="index.jsp">Logout</a>
            </li>
        </ul>
        <ul class="navbar-nav ml-auto nav-flex-icons">
        	<li class="nav-item" style="color: white">Welcome ${email}</li><pre>  </pre>
            <li class="nav-item avatar">
            <a class="nav-link p-0" href="#">
                <img src="https://mdbootstrap.com/img/Photos/Avatars/avatar-5.jpg" class="rounded-circle z-depth-0"
                alt="avatar image" height="35">
            </a>
            </li>
        </ul>
        </div>
    </nav>
    <!--/.Navbar -->
    <!-- div>
        <img src="images/header_img4.jpg" alt="" style="height: 400px;height=auto">
    </div-->
</header>