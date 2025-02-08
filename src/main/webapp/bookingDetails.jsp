<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<%@page import="java.util.List" %> 

	<%@page import="com.movie.Pojo.Show" %>
    <%@page import="com.movie.Pojo.Movie" %> 

  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/seatingcss.css">

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<section class="py-5"> 
<div class="container bg-white"> 
<div class="moviecontainer"> 
<div class="container"> 

	<div class="row">
		<h1>Booking Details</h1>
	</div>
	<div class="row"> 
		<h5>
			<core:if test="${msg!=null}">
				<span class="success">${msg}</span>
			</core:if>
			<core:if test="${errormsg!=null}">
				<span class="success">${errormsg}</span>
			</core:if>
		</h5>
	</div> 
	
	<div class="row">
		<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th colspan="2">Check Details</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>Booking Id</th>
					<td>${booking.bookingId}</td>
				</tr>
				<tr>
					<th>Movie Name</th>
					<td>${booking.s.showMoive.movieName}</td>
				</tr>
				<tr>
					<th>Theater Name</th>
					<td>${booking.s.theaterName_loc}</td>
				</tr>
				<tr>
					<th>Screen No:</th>
					<td>${booking.s.screen}</td>
				</tr>
				<tr>
					<th>Show Date</th>
					<td>
						<fmt:parseDate  var="date" value="${booking.s.showDate}" pattern="yyyy-MM-dd"/>
						<fmt:formatDate value="${date}" type="date" dateStyle="medium"/>
					</td>
				</tr>
				<tr>
					<th>Show Time</th>
					<td>
						<fmt:parseDate var="start" value="${bookng.s.startTime}" pattern="HH:mm"/>
						<fmt:formatDate value="${start}"  type="time" timeStyle="short"/>
						To
						<fmt:parseDate var="end" value="${booking.s.endTime}" pattern="HH:mm"/>
					    <fmt:formatDate value="${end}"  type="time" timeStyle="short"/> 
					</td>
				</tr>
				<tr>
					<th>Book Seates</th>
					<td>${booking.bookingSeats}</td>
				</tr>
				<tr>
					<th>Payment Amount</th>
					<td>&#8377; ${booking.totalbills}</td>
				</tr>
				<tr>
					<th>Booking Date</th>
					<td>
						<fmt:parseDate var="bdate" value="${booking.bookingDateTime}" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
					<fmt:formatDate value="${bdate}" type="both" dateStyle="medium" timeStyle="medium"/>
					</td>
				</tr>
			</tbody> 
			<tfoot>
			<tr>
				<td>
					<h3>Enjoy Your Show..!!</h3>
				</td>
			</tr>
			</tfoot>
		</table>
		</div>
	</div>
	
</div>
</div>
</div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>