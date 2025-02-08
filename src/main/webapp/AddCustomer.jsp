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
 
	 	<form action="CustomerController" method="post">
	 	<input type="hidden" name="action" value="add">
		<table class="table">
		<tr>	
			<th>Enter Firstname :</th>
			<td><input class="form-control form-control-sm" type="text" name="firstName"></td>
			<td><span style="color:red">*</span></td>
		</tr>
		<tr>	
			<th>Enter Lastname :</th>
			<td><input class="form-control form-control-sm" type="text" name="lastName"></td>
			<td><span style="color:red">*</span></td>
		</tr>
		<tr>	
			<th>Enter Email Id :</th>
			<td><input class="form-control form-control-sm" type="email" name="emailId"></td>
			<td><span style="color:red">*</span></td>
		</tr>
		<tr>	
			<th>Enter Contact No :</th>
			<td><input class="form-control form-control-sm" type="number" name="contact"></td>
			<td><span style="color:red">*</span></td>
		</tr>
		<tr>	
			<th>Enter Address :</th>
			<td><input class="form-control form-control-sm" type="text" name="address"></td>
			<td><span style="color:red">*</span></td>
		</tr>
		<tr>	
			<th>Enter Password :</th>
			<td><input class="form-control form-control-sm" type="password" name="password"></td>
			<td><span style="color:red">*</span></td>
		</tr>
		<tr>
			<td><input  class="btn btn-warning" type="reset" value="Reset"></td>
			<td><input class="btn btn-info" type="submit" value="Add Customer"></td>
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