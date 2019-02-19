<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Spring MVC Form Handling</title>  
 </head>  
 <body>  
  <h2>Edit Employee Data</h2>  
  <form:form method="POST" action="/TestProject/update.html">  
      <table>
       <tr>  
           <td><form:label path="id">Empleado ID:</form:label></td>  
           <td><form:input path="id" name="id" id="id" value="${employee.id}" readonly="readonly" /></td>  
       </tr>  
       <tr>  
           <td><form:label path="name">Empleado Nombre:</form:label></td>  
           <td><form:input path="name" name="name" id="name" value="${employee.name}"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="age">Empleado Edad:</form:label></td>  
           <td><form:input path="age" name="age" id="age" value="${employee.age}"/></td>  
       </tr>  
       <tr>  
           <td><form:label path="salary">Empleado Salario:</form:label></td>  
           <td><form:input path="salary" name="salary" id="salary" value="${employee.salary}"/></td>  
       </tr>  
          
       <tr>  
           <td><form:label path="address">Empleado Direccion:</form:label></td>  
           <td><form:input path="address" name="address" id="address" value="${employee.address}"/></td>  
       </tr>  
          <tr>  
         <td><input type="submit" value="Actualizar"/></td>  
        </tr>  
   </table>    
  </form:form>  
 </body>  
</html>