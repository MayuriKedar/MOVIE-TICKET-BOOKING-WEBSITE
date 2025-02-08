<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="header.jsp"></jsp:include>

	<!-- main content if any -->
	
<section class="py-5">
<div class="container bg-white">
<div class="moviecontainer">
	<div class="container">
	<div>
	<table class="table table-striped m-auto" style="width:500px">
	<thead class="thead-dark">
		<tr>
			<th colspan="2" style="text-align:center;">
    <a class="btn btn-warning" href="CustomerController?action=edit&custId=${user.custId}">Edit Profile</a>
</th>
		</tr>
		<tr>
			<th colspan="2">
				<core:if test="${msg!=null}">
					<span class="success">${msg}</span>
				</core:if>
				<core:if test="${errormsg!=null}">
					<span class="error">${errormsg}</span>
				</core:if>
			</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Customer Id</td>
			<td>${user.custId}</td>
		</tr>
		<tr>
			<td>Full Name</td>
			<td><span style="font-variant:small-caps;">${user.firstName}${user.lastName}</span></td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td>${user.emailId}</td>
		</tr>
		<tr>
			<td>Mobile No</td>
			<td>${user.contact}</td>
		</tr>
		<tr>
			<td>Password</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>${user.address}</td>
		</tr>
	</tbody>
		
	</table>
	
	</div>
	</div>
</div>
</div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>