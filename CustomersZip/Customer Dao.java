package com.lti.Dao;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.Model.Customers;
public class CustomersDao {



		private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
		private String jdbcUsername = "system";
		private String jdbcPassword = "123";

		private static final String INSERT_USERS_SQL = "INSERT INTO customers VALUES "
				+ " (?,?, ?, ?,?,?,?,?)";

		private static final String SELECT_USER_BY_ID = "select first_name,last_name,address, city,state,zipcode,email_address from customers where customer_id =?";
		private static final String SELECT_ALL_USERS = "select * from customers";
		private static final String DELETE_USERS_SQL = "delete from customers where customer_id = ?";
		private static final String UPDATE_USERS_SQL = "update customers set first_name = ? , last_name= ? , address = ? , city = ?, state = ?, zipcode = ?, email_address = ? where customer_id = ?";

		public CustomersDao() {
		}

		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection(jdbcURL, jdbcUsername, 
						jdbcPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}

		public void insertUser(Customers customer) throws SQLException {
			System.out.println(INSERT_USERS_SQL);
			// try-with-resource statement will auto close the connection.
			try {Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
					preparedStatement.setInt(1,customer.getCustomer_id());									
				preparedStatement.setString(2,customer.getFirst_name());									
				preparedStatement.setString(3, customer.getLast_name());
				preparedStatement.setString(4, customer.getAddress());
                preparedStatement.setString(5,customer.getCity());
                preparedStatement.setString(6,customer.getState());
                preparedStatement.setString(7,customer.getZipcode());
                preparedStatement.setString(8,customer.getEmail_address());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}

		public Customers selectUser(int customer_id) {
			Customers customer= null;
			// Step 1: Establishing a Connection
			try {Connection connection = getConnection();
					// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement
														(SELECT_USER_BY_ID);
				preparedStatement.setInt(1, customer_id);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {

					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String address = rs.getString("address");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zipcode = rs.getString("zipcode");
                    String email = rs.getString("email_address");
					
					customer = new Customers(customer_id,fname,lname,address,city,state,zipcode,email);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return customer;
		}

		public List<Customers> selectAllUsers() {

			// using try-with-resources to avoid closing resources (boiler plate code)
			List<Customers> customerlist = new ArrayList<>();
			// Step 1: Establishing a Connection
			try {Connection connection = getConnection();

					// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement
						(SELECT_ALL_USERS);
				System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				ResultSet rs = preparedStatement.executeQuery();

				// Step 4: Process the ResultSet object.
				while (rs.next()) {
					int customer_id=rs.getInt("customer_id");
					String fname = rs.getString("first_name");
					String lname = rs.getString("last_name");
					String address = rs.getString("address");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zipcode = rs.getString("zipcode");
                    String email = rs.getString("email_address");
				
					customerlist.add(new Customers(customer_id,fname,lname,address,city,state,zipcode,email));
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return customerlist;
		}

		public boolean deleteUser(int customer_id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection = getConnection();
					PreparedStatement statement = connection.prepareStatement
													(DELETE_USERS_SQL);){
				statement.setInt(1, customer_id);
				rowDeleted = statement.executeUpdate() > 0;
			}
			return rowDeleted;
		}

		public boolean updateUser(Customers customer) throws SQLException {
			boolean rowUpdated;
			try (Connection connection = getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);){
				preparedStatement.setString(1, customer.getFirst_name());
				preparedStatement.setString(2, customer.getLast_name());
                preparedStatement.setString(3,customer.getAddress());
				preparedStatement.setString(4, customer.getCity());
				preparedStatement.setString(5, customer.getState());
				preparedStatement.setString(6, customer.getZipcode());
				preparedStatement.setString(7, customer.getEmail_address());
				preparedStatement.setInt(8,customer.getCustomer_id());								


				rowUpdated = preparedStatement.executeUpdate() > 0;
			}
			return rowUpdated;
		}

		private void printSQLException(SQLException ex) {
			
					ex.printStackTrace();}}

	

