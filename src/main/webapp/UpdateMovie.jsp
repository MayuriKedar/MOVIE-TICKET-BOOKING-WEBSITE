<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	 <div>
 
 	<form action="MovieController" method="post">
 	<input type="hidden" name="action" value="edit">
	<table class="table">
	<tr>
		<th>Movie Id</th>
		<td><input  readonly="readonly" type="text" name="MovieId" class="form-control form-control-sm"
		value="${movieObj.movieId}"></td>
	</tr>
	<tr>	
		<th>Enter Movie Name :</th>
		<td><input class="form-control form-control-sm" type="text" value="${movieObj.movieName}" name="movieName"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Director name :</th>
		<td><input class="form-control form-control-sm" type="text" value="${movieObj.director}" name="director"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Producer name :</th>
		<td><input class="form-control form-control-sm" type="text" value="${movieObj.producer}" name="producer"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Writer name :</th>
		<td><input class="form-control form-control-sm" type="text" value="${movieObj.writer}" name="writer"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter cast :</th>
		<td><input class="form-control form-control-sm" type="text" value="${movieObj.cast}" name="cast"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Movie Type :</th>
		<td><input class="form-control form-control-sm" type="text" value="${movieObj.type}" name="type"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Movie ReleaseDate :</th>
		<td><input class="form-control form-control-sm" type="date" value="${movieObj.releaseDate}" name="releaseDate"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>
		<td><input  class="btn btn-warning" type="reset" value="Reset"></td>
		<td><input class="btn btn-info" type="submit" value="Update Movie"></td>
	</tr>
	</table>
	</form>
	</div>
   </div>
  </div>
</div>
</section>

<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>