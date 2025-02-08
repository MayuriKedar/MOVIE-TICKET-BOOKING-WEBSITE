<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<link rel="icon" type="image/*" href="images/logo.png"/>
<script>
document.addEventListener("DOMContentLoaded", () => {
    const newPassword = document.getElementById("newPassword");
    const retypePassword = document.getElementById("retypePassword");
    const matchMessage = document.getElementById("matchMessage");
    const form = document.getElementById("resetPasswordForm");

    // Real-time password match validation
    retypePassword.addEventListener("input", () => {
        if (newPassword.value === retypePassword.value) {
            matchMessage.textContent = "Passwords match";
            matchMessage.className = "success";
        } else {
            matchMessage.textContent = "Passwords do not match";
            matchMessage.className = "error";
        }
    });

    // Prevent form submission if passwords do not match
    form.addEventListener("submit", (event) => {
        if (newPassword.value !== retypePassword.value) {
            event.preventDefault(); // Stop form submission
            alert("Passwords do not match. Please re-enter.");
        }
    });
});
</script>
<style>
    .error {
        color: red;
    }
    .success {
        color: green;
    }
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section class="py-5">
	<div class="container bg-white">
	<div class="moviecontainer">
		<div class="container">
		<div class="row">
			<h1>Change Password</h1>
		</div>
		<!-- if user already exists then should display already exist while registration -->
		<form id="resetPasswordForm" action="PasswordController" method="post">
			<input type="hidden" name="action"  value="password">
			<fieldset class="position-relative" style="min-height: 150px;">
				<table class="table">
				<tr>
					<th><label>Email-Id</label></th>
					<td><input class="form-control form-control-sm" type="email" name="emailId" required></td>
					<td><span class="error">*</span></td>
				</tr>
				<tr>
					<th><label>New Password</label></th>
					<td><input class="form-control form-control-sm" 
						id="newPassword" 
						type="password" 
						name="password" 
						minlength="8" 
						required  
            			pattern="^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" 
            			title="Must be at least 8 characters long and include at least one letter and one number."></td>
					<td><span class="error">*</span></td>
				</tr>
				<tr>
					<th><label>Retype Password</label></th>
					<td><input class="form-control form-control-sm" 
						id="retypePassword" 
						type="password" 
						name="retypePassword" 
						required></td>
					<td><span id="matchMessage" class="error"></span></td>
					<td><span class="error">*</span></td>
				</tr>
				<tr>
					<td id="button" colspan="2" align="right">
						<input class="btn btn-warning" type="reset" value="CLEAR">
						<input class="btn btn-info" type="submit" value="UPDATE"> 
					</td>
				</tr>		
				</table>
			</fieldset>
		</form>
	</div>
	</div>
	</div>
	</section>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>