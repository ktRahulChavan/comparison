<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.List" %> 
 <%@ page import = "com.cdac.Product" %>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   
  <center><h1>Displaying updated Product List</h1></center>
      <table border ="1" width="500" align="center">
         <tr bgcolor="00FF7F">
          <th><b>Product ID</b></th>
          <th><b>Product Name</b></th>
          <th><b>Product  Price</b></th>
          <th><b>Product  Quantity</b></th>
          <th><b>Product  Discount</b></th>      
         </tr>             
        <c:forEach items="${sessionScope.products}" var="product">
            <tr>
                <td>${product.pid}</td>
                <td>${product.pname}</td>
                <td>${product.pprice}</td>
                <td>${product.pquantity}</td>
                <td>${product.pdiscount}</td>              
            </tr>
           </c:forEach> 
        </table> 
  <center><h3><a href = "Welcome.html">Welcome</a></h3></center>
  </body>
</html>