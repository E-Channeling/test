<!DOCTYPE html>
<html lang="en">
<head>
    <title>Welcome</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body style="background-image: url(images/hero.jpg);">
	
    <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<div class="col-12" style="padding: 0px; margin: 0px">
	<!-- img src="images/elements-bg.png" alt="" style="float: right;"-->
		<div class="col-7">	
			<h1 style="margin: 7%">Channel Doctor</h1>
			<form action="" class="form-signin" style="border-radius: 10px; padding: 30px;background-color: white;box-shadow: 2px 2px 2px 2px rgb(194, 194, 194);margin: 10% 10px 10px 10px;">
				<center>
				<img alt="" src="images/doctors.png" style="margin-right: 8%">
				<img alt="" src="images/specialities.png" style="margin-right: 8%">
				<img alt="" src="images/heart-beat.png" style="margin-right: 8%">
				<img alt="" src="images/stomach.png" style="margin-right: 8%;">
				<img alt="" src="images/blood-sample.png" style="margin-right: 8%;">
				<img alt="" src="images/blood-donation.png" style="margin-right: 8%;">
				</center><br>
			    <label for="">Hospital</label>
			    <select name="" id="" class="form-control">
			        <option value="">Colombo</option>
			        <option value="">Nevil</option>
			    </select>
			    <label for="">Doctor</label>
			    <select name="" id="" class="form-control">
			        <option value="">D.r Menuka</option>
			    </select>
			    <label for="">Date</label>
			    <input class="form-control" type="datetime-local" name="" id=""> </br>
			    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Book">
			</form>
		</div>	
	</div>

</body>
</html>