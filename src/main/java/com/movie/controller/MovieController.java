package com.movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.Dao.MovieDaoImpl;
import com.movie.Pojo.Movie;

/**
 * Servlet implementation class MovieController
 */
@WebServlet("/MovieController")
public class MovieController extends HttpServlet {
	
	int movieId;
	String movieName;
	String director;
	String producer;
	String writer;
	String cast;
	String type;
	LocalDate releaseDate;
	boolean flag;
	
	Movie m1=null;
	MovieDaoImpl impl = new MovieDaoImpl();
	List<Movie> al = null;
	
	HttpSession session;
	RequestDispatcher rd=null;
	
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		session = request.getSession();
		
		if(action!=null && action.equalsIgnoreCase("deleteMovie"))
		{
			//write code for delete
			movieId= Integer.parseInt(request.getParameter("MovieId"));
			flag= impl.deleteMovie(movieId);
			
			if(flag)
			{
				//
				request.setAttribute("msg", "Movie Deleted Successfully..!!");
				
				//after delete list of session must be update
				al=impl.getAllMovie();
				session.setAttribute("movielist", al);
			}
			else
			{
				request.setAttribute("errormsg", "Movie Not Deleted..!!");
			}
			rd=request.getRequestDispatcher("AllMovies.jsp");
			rd.forward(request, response);
			//show updated movieList after deleting..
		}
		
	
		
		if(action!=null && action.equals("ShowMovielist"))
		{
			al=impl.getAllMovie();
			if(al.isEmpty() || al==null)
			{
				request.setAttribute("emsg", "Sorry No movies Added!!");
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
			}
			else
			{
				session.setAttribute("al", al);
				response.sendRedirect("AllMovies.jsp");
			}
		}
		else if(action!=null && action.equals("updateMovie"))
		{
			movieId=Integer.parseInt(request.getParameter("MovieId"));
			m1= impl.getMovieById(movieId);
			session.setAttribute("movieObj", m1);
			response.sendRedirect("UpdateMovie.jsp");
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		if(action!=null && action.equals("add"))
		{
			movieName = request.getParameter("movieName");
			director = request.getParameter("director");
			producer = request.getParameter("producer");
			writer = request.getParameter("writer");
			cast = request.getParameter("cast");
			type = request.getParameter("type");
			releaseDate = LocalDate.parse(request.getParameter("releaseDate"));

			m1 = new Movie();
			m1.setMovieName(movieName);
			m1.setDirector(director);
			m1.setProducer(producer);
			m1.setWriter(writer);
			m1.setCast(cast);
			m1.setType(type);
			m1.setReleaseDate(releaseDate);
			
			flag = impl.addMovie(m1);
			
			if(flag)
			{
				//pw.print("<h4 style='color:green';>Movie Added Successfully!!</h4>");
				request.setAttribute("msg", "Moive Added Successfully..!");
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.include(request, response);
			}
			else
			{
				//pw.print("<h4 style='color:maroon';>Error While Adding Movie Details!!</h4>");
				request.setAttribute("errormsg", "Failed to Add Movie Details..!");
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.include(request, response);
			}
		}
		
		if(action!=null && action.equals("edit"))
		{
			movieName = request.getParameter("movieName");
			director = request.getParameter("director");
			producer = request.getParameter("producer");
			writer = request.getParameter("writer");
			cast = request.getParameter("cast");
			type = request.getParameter("type");
			releaseDate = LocalDate.parse(request.getParameter("releaseDate"));
			movieId= Integer.parseInt(request.getParameter("MovieId"));
			
			m1 = new Movie();
			m1.setMovieName(movieName);
			m1.setDirector(director);
			m1.setProducer(producer);
			m1.setWriter(writer);
			m1.setCast(cast);
			m1.setType(type);
			m1.setReleaseDate(releaseDate);
			m1.setMovieId(movieId);
			
			flag = impl.updateMovie(m1);
			if(flag)
			{
				request.setAttribute("msg", "Movie Updated Successfully!!");
				al = impl.getAllMovie();
				session.setAttribute("al", al);
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("errormsg", "Error while Updating movie details!!");
				rd=request.getRequestDispatcher("AllMovies.jsp");
				rd.forward(request, response);
			}	
		}
		
	}

}
