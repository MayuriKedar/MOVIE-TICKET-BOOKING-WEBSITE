package com.movie.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.Dao.CustomerDao;
import com.movie.Dao.CustomerDaoImpl;
import com.movie.Dao.LoginDao;
import com.movie.Dao.LoginDaoImpl;
import com.movie.Pojo.Customer;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String action;
	HttpSession session;
    String usertype,emailId,password;
    LoginDao loginDao = new LoginDaoImpl();
    CustomerDao custDao = new CustomerDaoImpl();
    Customer user;
    boolean flag;
    RequestDispatcher rd= null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		action =request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("logout"))
		{
			session = request.getSession();
			session.invalidate(); // session object destroyed..
			request.setAttribute("msg", "Logout Successfull....!!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		action = request.getParameter("action");
		if(action!=null && action.equalsIgnoreCase("login"))
		{
			usertype=request.getParameter("usertype");
			emailId=request.getParameter("emailId");
			password=request.getParameter("password");
			
			if(usertype!=null && usertype.equalsIgnoreCase("admin"))
			{
				flag= loginDao.checkAdmin(emailId, password);
				if(flag)
				{
					session = request.getSession();
					session.setAttribute("admin", emailId);
					request.setAttribute("msg", "Admin Login Successfull..!!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("errormsg", "Invalid Email Id or Password!!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else if(usertype!=null && usertype.equalsIgnoreCase("customer"))
			{
				flag = loginDao.checkCustomer(emailId, password);
				if(flag)
				{
					//new session will be created for each user.
					session = request.getSession();
					session.setAttribute("customer", emailId);
					user = custDao.showByCustomerByEmailId(emailId);
					session.setAttribute("user", user);
					request.setAttribute("msg", "Customer Login Successfull..!!");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
				else
				{
					request.setAttribute("errormsg", "Invalid Email Id or Password");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			
		}
	}

}
