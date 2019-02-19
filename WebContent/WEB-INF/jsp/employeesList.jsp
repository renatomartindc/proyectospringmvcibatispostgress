<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<title>All Employees</title>  
</head>  
<body>  
<h1>List Employees</h1>  
<h3><a href="add.html">Add More Employee</a></h3>  
  
<c:if test="${!empty employees}">  
 <table align="left" border="1">  
  <tr>  
   <th>Empleado ID</th>  
   <th>Empleado Name</th>  
   <th>Empleado Age</th>  
   <th>Empleado Salary</th>  
   <th>Empleado Address</th>  
   <th>Acciones</th>
  </tr>  
  
  <c:forEach items="${employees}" var="employee">  
   <tr>  
    <td><c:out value="${employee.id}"/></td>  
    <td><c:out value="${employee.name}"/></td>  
    <td><c:out value="${employee.age}"/></td>  
    <td><c:out value="${employee.salary}"/></td>  
    <td><c:out value="${employee.address}"/></td>
    <td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td>    
   </tr>  
  </c:forEach>  
 </table>  
</c:if>  
</body>  
</html>