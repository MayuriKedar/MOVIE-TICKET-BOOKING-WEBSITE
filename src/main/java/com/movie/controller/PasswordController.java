package com.movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.Dao.CustomerDaoImpl;
import com.movie.Pojo.Customer;

@WebServlet("/PasswordController")
public class PasswordController extends HttpServlet {
	Customer c1 = new Customer();
	CustomerDaoImpl cimpl = new CustomerDaoImpl();
	boolean flag=false;
	RequestDispatcher rd=null;
	//admin and user both

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		
		if(action != null && action.equals(action))
		{
			String email = request.getParameter("emailId");
			String password = request.getParameter("password");
			
			c1.setEmailId(email);
			c1.setPassword(password);
			
			flag = cimpl.updatePassword(email, password);
			
			if(flag)
			{
				request.setAttribute("msg", "Password Changed Succesfully....Login Here");
				rd= request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			else
			{
				request.setAttribute("msg", "Password Generation Failed.....Please try again");
				rd= request.getRequestDispatcher("forgotPassword.jsp");
				rd.include(request, response);
			}
		
			
		}
	}
	
}
