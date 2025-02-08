<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, com.movie.Pojo.Movie" %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
    
<!DOCTYPE html>
<html>
<head>

<%
	List<Movie> al = (List<Movie>)session.getAttribute("al");
%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>
	
	
<input type="hidden" name="action" value="Allmovies">
<section class="py-5">
<div class="container bg-white">
 <div class="moviecontainer">	
    <div class="container">
    <div class="row">
    	<h1>Movie List</h1>
    </div>
    <div class="row">
	  	<h3>
	  		<!-- Using expresssion language -->
	  		<span class="success">${msg}</span>
	  		<span class="error">${errormsg}</span>
	  	</h3>
  	</div>
	 <div>
	 
	 	<table class="table">
	 		<tr>
	 			<th>Id</th>
	 			<th>Name</th>
	 			<th>Director</th>
	 		    <th>Producer</th>
	 			<th>Writer</th>
	 			<th>Cast</th>
	 			<th>Type</th>
	 			<th>ReleaseDate</th>
	 			<th colspan="3" style="align-items:center;">Action</th>
	 		<tr>
	 			<%
	 			if(al!=null)
	 			{
	 				for(Movie m1 :al)
	 				{

	 			%>
	 		<tr>
	 			<td><%= m1.getMovieId()%></td>
	 			<td><%= m1.getMovieName() %></td>
	 			<td><%= m1.getDirector() %></td>
	 			<td><%= m1.getProducer() %></td>
	 			<td><%= m1.getWriter() %></td>
	 			<td><%= m1.getCast() %></td>
	 			<td><%= m1.getType() %></td>
	 			<td><%= m1.getReleaseDate()%></td>
	 			
	 			
 			<core:if test="${not empty admin}"> 
			  <td><a href="MovieController?action=updateMovie&MovieId=<%=m1.getMovieId() %>"class="btn btn-info">Update</a></td> 
	
			  <td><a href="MovieController?action=deleteMovie&MovieId=<%=m1.getMovieId()%>" class="btn btn-dark" 
			  onclick="return confirm('are you sure you want to deler this movie?')">delete</a></td> 
			</core:if> 
			  
			<td><a href="ShowController?action=showlistbymovie&MovieId=<%=m1.getMovieId() %>" class="btn btn-success">Allshows</a></td> 
				 			
	 		</tr>
	 		<%
	 			}
	 		}
	 		%>
	 		
	 	</table>
	 	
	 </div>
	</div>
	
</div>
</div>
</section>
 	
 	
 	
	
	
	
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>