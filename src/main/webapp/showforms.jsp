<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %> 
    
    <%@page import="java.util.List"%> 
    <%@page import="com.movie.Pojo.Movie"%> 
    <%@page import="com.movie.Pojo.Show"%>
    <%@page import="com.movie.Dao.MovieDaoImpl"%>
     
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
  	<h1>Add Show Of Moive</h1>
  </div>
  <div class="row">
  	<h3>
  		<!-- Using expresssion language -->
  		<span class="success">${msg}</span>
  		<span class="error">${errormsg}</span>
  	</h3>
  </div>
  
  <div>
  	<form class="showform" action="ShowController" method="post">
  		<core:if test="${requestScope.action=='update'}">
  			<input type="hidden" name="action" value="update">
  		</core:if>
  		<core:if test="${requestScope.action==null}">
  			<input type="hidden" name="action" value="add">
  		</core:if>
  		
  		<fieldset>
  			<core:if test="${requestScope.action=='update'}">
				<legend><strong>Update Show</strong></legend>
			</core:if>
			<core:if test="${requestScope.action == null }">
				<legend><strong>New Show</strong></legend>
			</core:if>
		
		<table class="table">
			<!-- instead of this we can use jstl core tag -->
			<%if(request.getAttribute("action")!=null && request.getAttribute("action").equals("update")) {%>
		
			<tr>
				<th><label>Id</label></th>
				<td><input class="form-control form-control-sm" type="text" name="showId" value="${showObj.showId}" readonly></td>
				<td><span class="error">*</span></td>
			</tr>
			<%} %>
			
			<tr>
				<th><label>Movie</label></th>
				<td>
				<%
					List<Movie> movielist = new MovieDaoImpl().getAllMovie();
				%>
				<select class="form-control form-control-sm" id="movieid" name="movieId">
					<option value="">Select</option>
					<core:forEach var="movie" items="<%=movielist%>">
						<option value="${movie.movieId}" 
							<core:if test="${movie.movieId == showObj.show_MovieId}">Selected</core:if>>
							${movie.movieName}						
						</option>
					</core:forEach>
				</select>
				</td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>Theater Name & Location</label></th>
				<td><input class="form-control form-control-sm" type="text" name="theaterName_loc" value="${showObj.theaterName_loc}"></td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>Screen Name</label></th>
				<td><input class="form-control form-control-sm" type="text" name="screen" value="${showObj.screen}"></td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>Type</label></th>
				<td><input class="form-control form-control-sm" type="text" name="type" value="${showObj.showtype}"></td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>Date</label></th>
				<td><input class="form-control form-control-sm" type="date" name="date" value="${showObj.showDate}"></td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>Start Time</label></th>
				<td><input class="form-control form-control-sm" type="time" name="startTime" value="${showobj.startTime}"></td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>end Time</label></th>
				<td><input class="form-control form-control-sm" type="time" name="endTime" value="${showobj.endTime}"></td>
				<td><span class="error">*</span></td>
			</tr>
			<tr>
				<th><label>Price</label></th>
				<td><input class="form-control form-control-sm" type="number" name="price" value="${showObj.price}"></td>
				<td><span class="error">*</span></td>
			</tr>
			
			<tr>
				<td id="button" colspan="2" align="right">
					<input class="btn btn-warning" type="reset" value="clear">
					<core:if test="${requestScope.action=='update'}">
						<input class="btn btn-success" type="submit" value="UpdateShow"/>
					</core:if>
					<core:if test="${requestScope.action==null}">
						<input class="btn btn-success" type="submit" value="Add Show">
					</core:if>
				</td>
			</tr>
		</table>
  		</fieldset>
  	</form>
  </div>
  
 </div>
 </div>
 </div>
</section>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>