<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="com.movie.Pojo.Show" %>
    <%@page import="com.movie.Pojo.Movie" %>

    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
	
	
<!-- main Content if any --> 
<section class="py-5"> 
<div class="container bg-white"> 
<div class="moviecontainer"> 
	<div class="container"> 
	
	<div class="row">
	  <h1>Booking List</h1>
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
		<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th>Id</th>
				<core:if test="${admin!=null}">
				<th>Customer Email Id</th>
				</core:if>
				<th>Movie Name</th>
				<th>Show Date</th>
				<th>Show Time</th>
				<th>Seats</th>
				<th>Date</th>
				<th>Amount</th>
			</tr>
		</thead>
		<core:forEach  var="booking" items="${bookinglist}">
			<tr>
				<td>${booking.bookingId}</td>
				<core:if test="${admin!=null}">
					<td>${booking.email}</td>
				</core:if>
				<td>
					${booking.s.showMoive.movieName}
				</td>
				<td>
					<fmt:parseDate var="date" value="${booking.s.showDate}" pattern="yyyy-MM-dd"/>
					<fmt:formatDate value="${date}" type="date" dateStyle="medium"/>  
				</td>
				<td><b>From</b>
				
					<fmt:parseDate var="start" value="${booking.s.startTime}" pattern="HH:mm"/>
					<fmt:formatDate value="${start}" type="time" timeStyle="short"/>
					
					<br/><b>To&nbsp;&nbsp;</b>
					
					<fmt:parseDate var="end" value="${booking.s.endTime}" pattern="HH:mm"/>
					<fmt:formatDate value="${end}" type="time" timeStyle="short" />
					
				</td>
				<td>
					${booking.bookingSeats}
				</td>
				<td>
					<fmt:parseDate var="bdate" value="${booking.bookingDateTime}" pattern="yyyy-MM-dd'T'HH:mm:ss"/>
					<fmt:formatDate value="${bdate}" type="both" dateStyle="medium" timeStyle="short"/>
				</td>
				<td>
					${booking.totalbills}
				</td>
			</tr>
		</core:forEach>
		</table>
		<core:if test="${bookinglist.isEmpty() }"> 
  		<h4>No Bookings Found for this movie....!!</h4> 
  		</core:if> 
	  </div> 
	  
</div>
</div>
</div>
</section>	
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>