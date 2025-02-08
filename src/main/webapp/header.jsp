<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
<link rel="icon" type="image/*" href="images/logo.png"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
 
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">


<script src="js/jquery-3.3.1.slim.min.js" ></script>
<script src="js/popper.min.js" ></script>
<script src="js/bootstrap.min.js" ></script>
<script src="js/jquery.min.js"></script>

			<!-- JS Code -->
			
		<script type="text/javascript">
		$(function(){
			$("li.nav-item").click(function(){
				 $('li.nav-item').removeClass('active'); 
				 $(this).addClass('active'); 
			});
		})
		</script>
</head>

<body>
<!-- Navigation -->
<div class="fixed-top">
<nav class="navbar navbar-expand-lg navbar-dark mx-background-top-linear ">
<div class="container">
	<a class="navbar-brand" rel="nofollow" target="_blank"
		href="#" style="font-weight:bold;font-variant: small-caps;color: black;">
		Book <span class="ticket"> Your </span> Show.COM
	</a>
		
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarResponsive" aria-controls="navbarResponsive"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarResponsive">

		<ul class="navbar-nav ml-auto">
			
			<li class="nav-item"><a class="nav-link" href="MovieController?action=ShowMovielist">Movies</a>
			</li>
			
			
			<li class="nav-item"><a class="nav-link" href="#">About</a>
			</li>
			
			<core:if test="${admin!=null}">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						Admin
					</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="AddMovie.jsp">Add New Movie</a>
						    <a class="dropdown-item" href="showforms.jsp">Add  New Show</a>
						    <a class="dropdown-item" href="CustomerController?action=showcustlist">Customers</a>
						    <a class="dropdown-item" href="ShowController?action=showshowlist">Shows</a>
						    <a class="dropdown-item" href="BookingController?action=allbookings">Bookings</a>
						    
						    <div class="dropdown-divider"></div>
						    
					    	<a class="dropdown-item" href="#">Change password</a>
					    	<a class="dropdown-item" href="LoginController?action=logout">Logout</a>
									
						</div>
				</li>
			</core:if>
			
			
			<core:if test="${customer!=null}">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<b><i><u><span style="font-variant:small-caps;">${user.firstName} ${user.lastName}</span></u></i></b>
					</a>
					
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="CustomerProfile.jsp">Profile</a>
						<a class="dropdown-item" href="BookingController?action=mybookings">Bookings</a>

						<div class="dropdown-divider"></div>
						
						<a class="dropdown-item" href="#">Change password</a>
						<a class="dropdown-item" href="LoginController?action=logout">Logout</a>			
					</div>
				</li>
			</core:if>
			
			<core:if test="${admin==null && customer==null}">
				<li class="nav-item">
					<a class="nav-link" href="login.jsp">Login</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link" href="CustomerForm.jsp">Signup</a>
				</li>
				
				<li class="nav-item"><a class="nav-link" href="#">Contact Us</a></li>
			</core:if>
			
			
		</ul>
</div>
</div>
</nav>
</div>
</body>
</html>