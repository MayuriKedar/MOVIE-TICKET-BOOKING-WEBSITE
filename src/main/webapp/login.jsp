<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="icon" type="image/*" href="images/logo.png"/>


<!-- JQuery validation links -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/jquery.validation/1.19.5/jquery.validate.min.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

	<!-- main content if any -->
<section class="py-5">
	<div class="container bg-white">
	<div class="moviecontainer">
		<div class="container">
		
		<div class="row">
			<h1>Login Form</h1>
		</div>
		<div>
			<h4><span class="success">${msg}</span>
				<span class="error">${errormsg}</span>
			</h4>
		</div>
		
		<!-- JQuery Validation Setup -->
		<div>
			<script type="text/javascript">
			$(function(){
			$(".loginform").validate({
				
				rule:{
					usertype:{
						required:true,
					},
					emailId:{
						required:true,
						email:true,
					},
					password:{
						required:true;
					    minlength:6,
					},
				},
				messages:{
					usertype:{
						required:"Please select your usertype",
					},
					emailId:{
						required:"Please enter your email Id",
						email:"Please enter valid email Id"
					},
					password:{
						required:"Please Enter your password",
						minlength: "Password must be of 6 characters including one uppercase, one lowercase and one special character",
					},
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
		
		<form class="loginform" action="LoginController" method="post">
			<input type="hidden" name="action"  value="login">
			<fieldset class="position-relative" style="min-height: 150px;">
				<legend><strong>Login here</strong></legend>
				<table class="table">
				<tr>
					<th><label>User Type</label></th>
					<td>
					<select class="form-control form-control-sm" id="usertype" name="usertype">
						<option value="">Select</option>
						<option value="admin">Admin</option>
						<option value="customer">Customer</option>
					</select>
					</td>
					<td><span class="errot">*</span></td>
				</tr>
				<tr>
					<th><label>Email Id</label></th>
					<td><input class="form-control form-control-sm" id="emailId" type="email" name="emailId"></td>
					<td><span class="errot">*</span></td>
				</tr>
				<tr>
					<th><label>Password</label></th>
					<td><input class="form-control form-control-sm" id="password" type="password" name="password"></td>
					<td><span class="errot">*</span></td>
				</tr>
				<tr>
					<td id="button" colspan="2" align="right">
						<input class="btn btn-warning" type="reset" value="CLEAR">
						<input class="btn btn-info" type="submit" value="LOGIN"> 
					</td>
				</tr>
				
				</table>
				<div class="d-flex justify-content-between align-items-center mt-4 mb-4">
        <p class="mb-0">Don't have an account? 
            <a href="CustomerForm.jsp" class="text-primary">Signup</a>
        </p>
        <a href="forgotPassword.jsp" class="text-primary">Forgot Password</a>
    </div>
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