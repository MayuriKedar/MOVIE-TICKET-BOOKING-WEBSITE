<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page import="com.movie.Pojo.Show" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/seatingcss.css">
<meta charset="UTF-8">
<title>Seat Selection</title>
</head>

<body>
<!-- include header here  -->
<jsp:include page="header.jsp" />

<script type="text/javascript">
	$(function() {

		$(".displayerBoxes").hide();

		$(".csbtn").click(function() {
			selectedCheckbox = $(".seatStructure input:checked"); // Select only relevant checkboxes
		    if (selectedCheckbox.length === 0) {
		        alert("Please select at least one seat before proceeding."); // Warning if no seats are selected
		        
		        return; // Exit the function to prevent further execution
		        }
		    else
		   	{
			$(".displayerBoxes").show();
			$(".seatStructure").hide();
			

			selectedCheckbox = $("input:checked");
			//Price Calculation.		
			noofseats = selectedCheckbox.length

			singleshowprice = $("input[name=showPrice]").val();

			var totalPrice = singleshowprice * noofseats;

			$("#totalPrice").text(totalPrice);
			//list of selected seats

			// array of seats

			seats_arr = [] // empty array..

			selectedCheckbox.each(function() {

				//	var valueofcheckbox = this.value;

				//	seats_arr.push(valueofcheckbox);

				seats_arr.push(this.value);

			})

			//show all the selected seats 

			$("input[name=booking_seats]").val(seats_arr);
		   	}
		});
	});
</script>

<!-- main Content if any -->
<section class="py-5">
	<div class="container bg-white">
		<div class="moviecontainer">
			<div class="container">
				<div class="row">
					<h1>Select your Seats</h1>
				</div>
				<div class="row">
					<h5>
						<core:if test="${msg!=null}">
							<span class="success">${msg}</span>
						</core:if>
						<core:if test="${errormsg!=null}">
							<span class="error">${errormsg}</span>
						</core:if>
					</h5>
				</div>
				<div class="row">
					<div class="container">
						<div class="seatStructure column" style="margin: 0px auto">
							<table id="seatsBlock" align="center" style="color: black;">
								<tr>
									<td colspan="14"><div class="screen">SCREEN</div></td>
									<td rowspan="20">
										<div class="smallBox greenBox">Selected Seat</div> <br />
										<div class="smallBox redBox">Reserved Seat</div> <br />
										<div class="smallBox emptyBox">Empty Seat</div> <br />
									</td>
									<br />
								</tr>
								<%
								int cols = 12;
								char rows = 'M';
								List<String> reserverSeats = (List<String>) request.getAttribute("reservedSeats");
								%>


								<tr>
									<td>&nbsp;</td>
									<%
									for (int i = 1; i <= cols; i++) {
									%>
									<td><%=i%></td>
									<%
									if (i == 6) {
									%>
									<td class="seatGap"></td>
									<%
									}
									%><!-- end of if -->
									<%
									}
									%><!-- end for -->

								</tr>
								<%
								for (char ch = 'A'; ch <= rows; ch++) {
								%>
								<!-- outer loop for rows -->
								<tr>
									<td><%=ch%></td>
									<%
									for (int i = 1; i <= cols; i++) {
									%>
									<!-- inner loop for rows -->
									<%
									String seat = ch + "" + i;
									if(reserverSeats.contains(seat)) {
									%>
									<%-- <td><input type="checkbox" class="seats" value="<%=seat%>" disabled="disabled" class="redBox"></td> --%>
									<td><div class="smallBox redBox"></div></td>
									<%
									} else {
									%>
									<td><input type="checkbox" class="seats" value="<%=seat%>"></td>
									<%
									}
									%>

									<%
									if (i == 6) {
									%>
									<td class="seatGap"></td>
									<%
									}
									%><!-- end of if -->


									<%
									}
									%>
									<!-- inner Loop is Closed -->
								</tr>
								<%
								}
								%>
								<!-- inner Loop is Closed -->
								<tr>
									<td align="center" colspan="14"><button class="csbtn"
											style="margin: 5px;">Confirm Selection</button></td>
								</tr>
							</table>
						</div>


						<div class="displayerBoxes column " style="margin-top: 50px;">
							<form action="BookingController" method="post">
								<input type="hidden" name="action" value="payment">
								<table class="Displaytable" align="center">

									<tr>
										<th>Customer Name :</th>
										<td>${user.firstName} ${user.lastName}</td>
									</tr>
									<tr>
										<th>Show Id :</th>
										<td><input type="text" id="showId" name="showId"
											value="${show.showId}" readonly="readonly"></td>
									</tr>
									<tr>
										<th>Movie :</th>
										<td>${show.showMoive.movieName}</td>
									</tr>
									<tr>
										<th>Screen No:</th>
										<td>${show.screen}</td>
									</tr>
									<tr>
										<th>Show Date:</th>
										<td><fmt:parseDate var="date" value="${show.showDate}"
												pattern="yyyy-MM-dd" /> <fmt:formatDate value="${date}"
												type="date" dateStyle="medium" /></td>
									</tr>
									<tr>
										<th>Start Time:</th>
										<td><fmt:parseDate var="start" value="${show.startTime}"
												pattern="HH:mm" /> <fmt:formatDate value="${start}"
												type="time" timeStyle="short" /></td>
									</tr>
									<tr>
										<th>End Time:</th>
										<td><fmt:parseDate var="end" value="${show.endTime}"
												pattern="HH:mm" /> <fmt:formatDate value="${end}"
												type="time" timeStyle="short" /></td>
									</tr>
									<tr>
										<th>Seat:</th>
										<td><input type="text" id="seatsDisplay"
											name="booking_seats" readonly="readonly">
										</td>
									</tr>
									<tr>
										<th>Total:</th>
										<td><input type="hidden" name="showPrice" value="${show.price}"/></td>
										<td>&#8377;<span id="totalPrice"></span></td>
									</tr>
									
									<tr>
										<th colspan="2"><input type="submit"
											value="Confirm Booking" class="btnConfirmBooking"></th>
									</tr>
								</table>
							</form>
							<div id="legend"></div>
							<div style="clear: both"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="footer.jsp" />
<!--  inlcude Footer here -->
</body>
</html>