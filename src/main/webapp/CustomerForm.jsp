<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link rel="icon" type="image/*" href="images/logo.png"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<section class="py-5">
<div class="container bg-white">
<div class="moviecontainer">
<div class="container">

	<div class="row">
			<h1>Customer Form</h1>
		</div>
		
	<div class="row">
		<span class="success">${msg}</span>
		<span class="error">${errormsg}</span>
	</div>
	<div>
	<script type="text/javascript">
		$(function(){
			$(".custform").validate({
				rules:{
					firstName:{
						required:true,
						minlength:4,
					},
					password:{
						required:true;
					    minlength:6,
					}
				},
				messages:{
					firstName:"Please enter your first name",
					minlength:"please enter at least 4 letter for first name",
				},
				password:{
					required:"Please Enter your password",
					minlength: "Password must be of 6 characters including one uppercase, one lowercase and one special character",
				},
		});
		
		// Add a custom validation method
	    $.validator.addMethod("strongPassword", function (value, element) {
	        return this.optional(element) || 
	               /[A-Z]/.test(value) &&    // Contains at least one uppercase letter
	               /[a-z]/.test(value) &&    // Contains at least one lowercase letter
	               /[!@#$%^&*(),.?:{}|<>]/.test(value); // Contains at least one special character
	    }, "Password must contain at least one uppercase letter, one lowercase letter, and one special character");
		});
	</script>
		
<form action="CustomerController" method="post">
		<c:if test="${requestScope.action=='update'}">
  			<input type="hidden" name="action" value="update">
  		</c:if>
  		<c:if test="${requestScope.action==null}">
  			<input type="hidden" name="action" value="add">
  		</c:if>
  		
	<fieldset>
	<c:if test="${requestScope.action== 'update'}">
	<legend>Update Profile</legend>
	</c:if>
	
	<c:if test="${requestScope.action== null }">
	<legend>Create Profile</legend>
	</c:if>
	
	<table class="table">
	<%if(request.getAttribute("action")!=null && request.getAttribute("action").equals("update")) {%>
		
			<tr>
				<th><label>Id</label></th>
				<td><input class="form-control form-control-sm" type="text" name="custId" value="${cusobj.custId}" readonly></td>
				<td><span class="error">*</span></td>
			</tr>
			<%} %>
	
	
	<tr>
	<th><label>first name</label></th>
	<td><input class="form-control form-control-sm" type="text" name="firstName" value="${cusobj.firstName }" ></td>
	<td><span class="error">*</span></td>
	</tr>
	
	<tr>
	<th><label>last name</label></th>
	<td><input class="form-control form-control-sm" type="text" name="lastName" value="${cusobj.lastName}"></td>
	<td><span class="error">*</span></td>
	</tr>
	
	<tr>
	<th><label>email-id</label></th>
	<td><input class="form-control form-control-sm" type="text" name="emailId" value="${cusobj.emailId}" ></td>
	<td><span class="error">*</span></td>
	</tr>
	
	<tr>
	<th><label>mobile no</label></th>
	<td><input class="form-control form-control-sm" type="tel" name="contact" value="${cusobj.contact}"></td>
	<td><span class="error">*</span></td>
	</tr>
	
	<tr>
	<th><label>password</label></th>
	<td><input class="form-control form-control-sm" type="password" name="password" value="${cusobj.password}"></td>
	<td><span class="error">*</span></td>
	</tr>
	
	<tr>
	<th><label>address</label></th>
	<td><input class="form-control form-control-sm" type="text" name="address" value="${cusobj.address}" ></td>
	<td><span class="error">*</span></td>
	</tr>
	
	<tr>
	<td id="button" colspan="2" align="right">
	<input class="btn btn-warning" type="reset" value="clear" >
	<c:if test="${requestScope.action=='update' }">
	 <input class="btn btn-warning" type="submit" value="update profile" >
	</c:if>
	
	<c:if test="${requestScope.action==null }">
	 <input class="btn btn-success" type="submit" value="register" >
	</c:if>
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