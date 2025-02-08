<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
<section class="py-5"> 
<div class="container bg-white"> 
<div class="moviecontainer"> 
<div class="container"> 
	<div class="row">
		<h1>Show List</h1>
	</div>
	<div class="row">
	  	<h3>
	  		<!-- Using expresssion language -->
	  		<span class="success">${msg}</span>
	  		<span class="error">${errormsg}</span>
	  	</h3>
  	</div>
	<div>
	<c:if test="${!showlist.isEmpty()}">
	<table class="table table-stripped">
		<thead class="thead-dark">
		<tr>
			<th>Id</th>
			<th>Movie Name</th>
			<th>TheaterName&Locn</th>
			<th>ScreenTime</th>
			<th>Type</th>
			<th>Date</th>
			<th>Time</th>
			<th>Price</th>
			<th colspan="3">Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="show" items="${showlist}">
		<tr>
			<td>${show.showId}</td>
			<td>${show.showMoive.movieName}</td>
			<td>${show.theaterName_loc}</td>
			<td>${show.screen}</td>
			<td>${show.showtype}</td>
			<td><fmt:parseDate var="date" value="${show.showDate}" pattern="yyyy-MM-dd"/>
				<fmt:formatDate value="${date}" type="date" dateStyle="medium"/>
			</td>
			<td><b>from</b>
			<fmt:parseDate var="start" value="${show.startTime}" pattern="HH:mm"/>
			<fmt:formatDate value="${start}" type="time" timeStyle="short"/> 
			<br/><b>To&nbsp;&nbsp;</b>
			<fmt:parseDate var="end" value="${show.endTime}" pattern="HH:mm"/> 
  			<fmt:formatDate value="${end}" type="time" timeStyle="short"/> 
			</td>
			<td>${show.price}</td>
			
			<c:if test="${customer!=null}"> 
 		 	<td><a class="btn btn-primary" href="BookingController?action=bookyourshow&showId=${show.showId}">Book 
  				</a>
  			</td>
  			</c:if> 
			
			<c:if test="${admin!=null}"> 
			  <td> 
				  <a class="btn btn-danger" onclick="return confirm('do you really want to delete')"  
				  href="ShowController?action=delete&showid=${show.showId}">delete
				  </a>
			  </td> 
			  <td> 
				  <a class="btn btn-info" 
				  href="ShowController?action=edit&showid=${show.showId}">edit
				  </a>
			  </td> 
		   </c:if> 
		   
  			<c:if test="${admin==null && customer==null}"> 
  				<td><a class="btn btn-info" href="login.jsp">login</a>
  				</td> 
  			</c:if> 
  			
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</c:if> 
  	<c:if test="${showlist.isEmpty() }"> 
  		<h4>No show founds for this movie</h4> 
  	</c:if> 
	
	</div>
</div>
</div>
</div>
</section>


<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>