<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
    
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
	  <h1>Customer List</h1>
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
		<table class="table table-stripped">
		<thead class="thead-dark">
		<tr>
			<th>Cust Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email Id</th>
			<th>Contact</th>
			<th>Address</th>
			<th>Actions</th>
		</tr>
		</thead>
		<core:forEach var="cust" items="${custlist}">
		<tr>
			<td>${cust.custId}</td>
			<td>${fn:toUpperCase(cust.firstName)}</td>
			<td>${fn:toUpperCase(cust.lastName)}</td>
			<td>${cust.emailId}</td>
			<td>${cust.contact}</td>
			<td>${cust.address}</td>
			<td>
				<a class="btn btn-danger" onclick="return  confirm('Do you really want to delete customer')" href="CustomerController?action=delete&custId=${cust.custId}">Delete
				</a>			
			</td>
		</tr>
		</core:forEach>
		</table>
	</div>
  
	</div>
</div>
</div>
</section>
	
	
	
	
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>