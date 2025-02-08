package com.movie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.Dao.BookingDao;
import com.movie.Dao.BookingDaoImpl;
import com.movie.Dao.ShowDao;
import com.movie.Dao.ShowDaoImpl;
import com.movie.Pojo.Booking;
import com.movie.Pojo.Show;

/**
 * Servlet implementation class BookingController
 */
@WebServlet("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	HttpSession session;
	String action;
	
	Booking booking;
	List<Booking> bookinglist;
	List<String> bookedSeates;
	
	BookingDaoImpl bimpl = new BookingDaoImpl();
	ShowDao showDao = new ShowDaoImpl();
	int bookingShowId;
	private Show show;
	String custEmailId;
	String bookingSeats;
	
	Booking bookingObj;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		action = request.getParameter("action");
		session = request.getSession();
		
		if(action!=null && action.equals("mybookings"))
		{
			String cust_emailId = (String)session.getAttribute("customer");
			bookinglist =bimpl.getMyBooking(cust_emailId); //showMyBooking()
			session.setAttribute("bookinglist", bookinglist);
			response.sendRedirect("Bookinglist.jsp");	
		}
		else if(action!=null && action.equals("allbookings"))
		{
			bookinglist = bimpl.getAllBooking();
			session.setAttribute("bookinglist", bookinglist);
			response.sendRedirect("Bookinglist.jsp");
		}
		else if(action!=null && action.equalsIgnoreCase("bookyourshow"))
		{
			bookingShowId = Integer.parseInt(request.getParameter("showId"));
			
			show = showDao.getShowById(bookingShowId);
			
			List<String> reservedSeats = bimpl.getReservedSeates(bookingShowId);
			
			request.setAttribute("show", show);
			request.setAttribute("reservedSeats", reservedSeats);
			request.getRequestDispatcher("seatView.jsp").forward(request, response);	
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		action= request.getParameter("action");
		session = request.getSession();
		
		if(action!=null && action.equals("payment"))
		{
			custEmailId = (String)session.getAttribute("customer");
			if(custEmailId!=null)
			{
				bookingShowId =Integer.parseInt(request.getParameter("showId"));
				bookingSeats =request.getParameter("booking_seats");
				
				bookingObj = bimpl.bookmyShow(bookingShowId, custEmailId, bookingSeats);
				
				request.setAttribute("booking", bookingObj);
				request.getRequestDispatcher("bookingDetails.jsp").forward(request, response);;
			}
			else
			{
				request.setAttribute("errormsg", "something went wrong please try again..");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
	}

}
