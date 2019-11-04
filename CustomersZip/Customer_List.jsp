<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Bookstore</title>
</head>
<body>
	<center>
		<h1>Customers</h1>
        <h2>
        	<a href="new">Add New Customers</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Customers</a>
        	
        </h2>
	</center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Customers</h2></caption>
            <tr>
                <th>Customer ID</th>
                <th>First Name</th>
                <th>Last Name</th>
	<th>Address</th>
		<th>City</th>
	
		<th>State</th>
			<th>Zipcode</th>
			<th>Email Address</th>
	
              
                <th>Actions</th> </tr>
            <c:forEach var="customer" items="${listUser}">
                <tr>
                    <td><c:out value="${customer.customer_id}" /></td>
                    <td><c:out value="${customer.first_name}" /></td>
                    <td><c:out value="${customer.last_name}" /></td>
                     <td><c:out value="${customer.address}" /></td>
                      <td><c:out value="${customer.city}" /></td>
                       <td><c:out value="${customer.state}" /></td>
                        <td><c:out value="${customer.zipcode}" /></td>
                         <td><c:out value="${customer.email_address}" /></td>
                    
                    <td>
                    	<a href="edit?customer_id=<c:out value='${customer.customer_id}' />">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?customer_id=<c:out value='${customer.customer_id}' />">Delete</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>

</body>
</html>
