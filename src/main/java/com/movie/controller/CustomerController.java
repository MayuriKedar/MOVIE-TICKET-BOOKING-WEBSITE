//			CONTROLLER
package com.movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.movie.Dao.CustomerDaoImpl;
import com.movie.Pojo.Customer;
import com.movie.Pojo.Show;

@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	
	int custId;
	String firstName;
	String lastName;
	String emailId;
	String contact;
	String address;
	String password;
	Customer c1 = new Customer();
	CustomerDaoImpl cimpl = new CustomerDaoImpl();
	
	List<Customer> clist = null;
	boolean flag=true;
	
	String action;
	HttpSession session;
	RequestDispatcher rd=null;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		session = request.getSession();
		action=request.getParameter("action");
		
		if(action!=null && action.equals("delete"))
		{
			custId=Integer.parseInt(request.getParameter("custId"));
			flag = cimpl.deleteCustomer(custId);
			if(flag)
			{
				request.setAttribute("msg", "Customer Deleted Successfully..!!");
				
				String admin=(String)session.getAttribute("admin");
				if(action!=null && action.equals("admin"))
				{
					clist=cimpl.showAllCustomers();
					session.setAttribute("custlist", clist);
					request.getRequestDispatcher("CustomerList.jsp").forward(request, response);	
				}
				else
				{
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else
			{
				request.setAttribute("errormsg", "Customer Not Deleted");
				request.getRequestDispatcher("CustomerList.jsp").forward(request, response);
			}
		}
		else if(action!=null && action.equals("showcustlist"))
		{
			clist = cimpl.showAllCustomers();
			session.setAttribute("custlist", clist);
			response.sendRedirect("CustomerList.jsp");
		}
		else if(action != null && action.equals("edit"))
		{
				session = request.getSession();

		        // Retrieve the user's existing data
			 	custId=Integer.parseInt(request.getParameter("custId"));
			 	c1 = cimpl.showByCustomerById(custId);

		        // Add the customer object to the request scope
			 	request.setAttribute("action", "update");
		        request.setAttribute("cusobj", c1);
		        request.getRequestDispatcher("CustomerForm.jsp").forward(request, response);
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		response.setContentType("text/html");
		
		if(action!=null && action.equals("add"))
		{	
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			emailId = request.getParameter("emailId");
			contact = request.getParameter("contact");
			address = request.getParameter("address");
			password = request.getParameter("password");
			
			
			c1.setFirstName(firstName);
			c1.setLastName(lastName);
			c1.setEmailId(emailId);
			c1.setContact(contact);
			c1.setAddress(address);
			c1.setPassword(password);
			
			flag = cimpl.addCustomer(c1);
			
			if(flag)
			{
				request.setAttribute("msg", "Your Registration is Successfull..<br> Please login here");
				rd= request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
			else
			{
				request.setAttribute("msg", "Registration is Failed..<br> Please try again");
				rd= request.getRequestDispatcher("CustomerForm.jsp");
				rd.include(request, response);
			}
			
		}
		
	else if(action!=null && action.equals("update"))
	{
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		emailId = request.getParameter("emailId");
		contact = request.getParameter("contact");
		address = request.getParameter("address");
		password = request.getParameter("password");
		
		
		c1.setFirstName(firstName);
		c1.setLastName(lastName);
		c1.setEmailId(emailId);
		c1.setContact(contact);
		c1.setAddress(address);
		c1.setPassword(password);
		
		flag = cimpl.updateCustomer(c1);
		if(flag)
		{
			request.setAttribute("msg", "Profile Updated Successfully..<br> Please login here");
			rd= request.getRequestDispatcher("CustomerProfile.jsp");
			rd.include(request, response);
		}
		else
		{
			request.setAttribute("msg", "Profile Updation is Failed..<br> Please try again");
			rd= request.getRequestDispatcher("CustomerForm.jsp");
			rd.include(request, response);
		}
	}
	}
	}



