package com.movie.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.Dao.ShowDao;
import com.movie.Dao.ShowDaoImpl;
import com.movie.Pojo.Show;

/**
 * Servlet implementation class ShowController
 */
@WebServlet("/ShowController")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	String action;
	HttpSession session;
	
	Show show;
	List<Show> showlist;
	ShowDao showDao = new ShowDaoImpl();
	boolean flag;
	int movieId,showId;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session = request.getSession();
		action=request.getParameter("action");
		
		if(action!=null && action.equals("delete"))
		{
			showId = Integer.parseInt(request.getParameter("showid"));
			flag=showDao.deleteShow(showId);
			if(flag)
			{
				request.setAttribute("msg", "Show Deleted Successfully..!");
				showlist =showDao.getAllShows();
				session.setAttribute("showlist", showlist);
			}
			else
			{
				request.setAttribute("errormsg", "Show Not Deleted..!");
			}
			request.getRequestDispatcher("showlist.jsp").forward(request, response);
		}
		else if(action!=null && action.equalsIgnoreCase("edit"))
		{
			showId =Integer.parseInt(request.getParameter("showid"));
			show = showDao.getShowById(showId);
			request.setAttribute("action", "update");
			request.setAttribute("showObj", show);
			request.getRequestDispatcher("showforms.jsp").forward(request, response);
		}
		else if(action!=null && action.equalsIgnoreCase("showlistbymovie"))
		{
			movieId=Integer.parseInt(request.getParameter("MovieId"));
			
			showlist = showDao.getShowsByMovie(movieId);
			session.setAttribute("showlist", showlist);
			response.sendRedirect("showlist.jsp");
		}
		else if(action!=null && action.equals("showshowlist"))
		{
			showlist= showDao.getAllShows();
			session.setAttribute("showlist", showlist);
			response.sendRedirect("showlist.jsp");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session =request.getSession();
		action = request.getParameter("action");
		
		if(action!=null && action.equals("add"))
		{
			show= new Show();
			show.setShow_MovieId(Integer.parseInt(request.getParameter("movieId")));
			show.setTheaterName_loc(request.getParameter("theaterName_loc"));
			show.setScreen(request.getParameter("screen"));
			show.setShowtype(request.getParameter("type"));
			show.setShowDate(LocalDate.parse(request.getParameter("date")));
			show.setStartTime(LocalTime.parse(request.getParameter("startTime")));
			show.setEndTime(LocalTime.parse(request.getParameter("endTime")));
			show.setPrice(Double.parseDouble(request.getParameter("price")));
			
			flag=showDao.addShow(show);
			if(flag)
			{
				request.setAttribute("msg", "Show Added Successfully..!!");
			}
			else
			{
				request.setAttribute("errormsg", "Failed To add new show.. Try again..!");
			}
			RequestDispatcher rd= request.getRequestDispatcher("showforms.jsp");
			rd.forward(request, response);
		}
		else if(action!=null && action.equals("update"))
		{
			show= new Show();
			show.setShowId(Integer.parseInt(request.getParameter("showId")));
			show.setShow_MovieId(Integer.parseInt(request.getParameter("movieId")));
			show.setTheaterName_loc(request.getParameter("theaterName_loc"));
			show.setScreen(request.getParameter("screen"));
			show.setShowtype(request.getParameter("type"));
			show.setShowDate(LocalDate.parse(request.getParameter("date")));
			show.setStartTime(LocalTime.parse(request.getParameter("startTime")));
			show.setEndTime(LocalTime.parse(request.getParameter("endTime")));
			show.setPrice(Double.parseDouble(request.getParameter("price")));
			
			flag= showDao.UpdateShow(show);
			if(flag)
			{
				request.setAttribute("msg", "Show Updated Successfully..! Show Id is "+ show.getShowId());
				showlist=showDao.getAllShows();
				RequestDispatcher rd = request.getRequestDispatcher("showlist.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errormsg", "Failed to Update Show Details..! try agian..");
				RequestDispatcher rd = request.getRequestDispatcher("showforms.jsp");
				rd.forward(request, response);
			}
		}
	}

}
