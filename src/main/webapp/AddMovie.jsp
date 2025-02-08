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
 
 	<div class="row">
			<h1>Add New Movie</h1>
		</div>
		
	<div class="row">
		<span class="success">${msg}</span>
		<span class="error">${errormsg}</span>
	</div>
	
 	<form action="MovieController" method="post">
 	<input type="hidden" name="action" value="add">
	<table class="table">
	<tr>	
		<th>Enter Movie Name :</th>
		<td><input class="form-control form-control-sm" type="text" name="movieName"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Director name :</th>
		<td><input class="form-control form-control-sm" type="text" name="director"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Producer name :</th>
		<td><input class="form-control form-control-sm" type="text" name="producer"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Writer name :</th>
		<td><input class="form-control form-control-sm" type="text" name="writer"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter cast :</th>
		<td><input class="form-control form-control-sm" type="text" name="cast"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Movie Type :</th>
		<td><input class="form-control form-control-sm" type="text" name="type"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>	
		<th>Enter Movie ReleaseDate :</th>
		<td><input class="form-control form-control-sm" type="date" name="releaseDate"></td>
		<td><span style="color:red">*</span></td>
	</tr>
	<tr>
		<td><input  class="btn btn-warning" type="reset" value="Reset"></td>
		<td><input class="btn btn-info" type="submit" value="Add Movie"></td>
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