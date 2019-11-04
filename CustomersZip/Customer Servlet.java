package com.lti.servlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lti.Model.Customers;
import com.lti.Dao.CustomersDao;;


	@WebServlet("/")
	public class CustomersServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private CustomersDao customersDao;
		
		public void init() {
			customersDao= new CustomersDao();
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request, response);
		}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getServletPath();

			try {
				switch (action) {
				case "/new":
					showNewForm(request, response);
					break;
				case "/insert":
					insertUser(request, response);
					break;
				case "/delete":
					deleteUser(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/update":
					updateUser(request, response);
					break;
				default:
					listUser(request, response);
					break;
				}
			} catch (SQLException ex) {
				throw new ServletException(ex);
			}
		}

		private void listUser(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, IOException, ServletException {
			List<Customers> listUser = customersDao.selectAllUsers();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
			dispatcher.forward(request, response);
		}

		private void showNewForm(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
			dispatcher.forward(request, response);
		}

		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("customer_id"));
			Customers existingUser = customersDao.selectUser(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
			request.setAttribute("Customers", existingUser);
			dispatcher.forward(request, response);

		}

		private void insertUser(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			int customer_id = Integer.parseInt(request.getParameter("customer_id"));
			String fn = request.getParameter("first_name");
			String ln = request.getParameter("last_name");
			String add = request.getParameter("address");
	        String city=request.getParameter("city");
	        String state=request.getParameter("state");
	        String zipcode=request.getParameter("zipcode");
	        String email=request.getParameter("email_address");
		
			
			
			
			Customers newUser = new Customers(customer_id, fn,ln,add, city, state,zipcode,email);
			customersDao.insertUser(newUser);
			response.sendRedirect("list");
		}

		private void updateUser(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
	                int id=Integer.parseInt(request.getParameter("customer_id"));
	                String fn = request.getParameter("first_name");
	        		String ln = request.getParameter("last_name");
			String add = request.getParameter("address");
	                String city=request.getParameter("city");
	                String state=request.getParameter("state");
	               String zipcode=request.getParameter("zipcode");
	               String email=request.getParameter("email_address");
	               

			Customers newUser = new Customers(id,fn,ln,add, city, state,zipcode,email);
			customersDao.updateUser(newUser);
			response.sendRedirect("list");
		}

		private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
				throws SQLException, IOException {
			  int id=Integer.parseInt(request.getParameter("customer_id"));
		customersDao.deleteUser(id);
			response.sendRedirect("list");

		}


}
