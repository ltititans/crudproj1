<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



	<title>Customers</title>
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
		<c:if test="${Customers != null}">
			<form action="update" method="post">
        </c:if>
        <c:if test="${Customers == null}">
			<form action="insert" method="post">
        </c:if>
      
        <table border="1" cellpadding="5">
            <caption>
            	
            		
            		<c:if test="${Customers == null}">
            			Customer Form
            		</c:if>
            	
            </caption>
        		
        		   <tr>
                <th>Customer ID: </th>
                <td>
                	<input type="number" name="customer_id" size="45"
                			value="<c:out value='${Customers.customer_id}' />"
                		/>
                </td>
            </tr>         
          <tr>
                <th>First Name: </th>
                <td>
                	<input type="text" name="first_name" size="45"
                			value="<c:out value='${Customers.first_name}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Last Name:  </th>
                <td>
                	<input type="text" name="last_name" size="45"
                			value="<c:out value='${Customers.last_name}' />"
                	/>
                </td>
            </tr>
            
 <tr>
                <th>Address: </th>
                <td>
                	<input type="text" name="address" size="45"
                			value="<c:out value='${Customers.address}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>City: </th>
                <td>
                	<input type="text" name="city" size="45"
                			value="<c:out value='${Customers.city}' />"
                	/>
                </td>
            </tr>
<tr>
                <th>State : </th>
                <td>
                	<input type="text" name="state" size="45"
                			value="<c:out value='${Customers.state}' />"
                	/>
                </td>
            </tr>
 <tr>
                <th>ZipCode: </th>
                <td>
                	<input type="text" name="zipcode" size="45"
                			value="<c:out value='${Customers.zipcode}' />"
                	/>
                </td>
            </tr>                       
 <tr>
                <th>Email Address: </th>
                <td>
                	<input type="text" name="email_address" size="45"
                			value="<c:out value='${Customers.email_address}' />"
                	/>
                </td>
            </tr>

            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>

