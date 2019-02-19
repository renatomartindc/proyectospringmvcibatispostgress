package com.proyecto.daoinf;

import java.util.List;

import com.proyecto.model.Employee;

public interface EmployeeDAO {

	public List<Employee> listEmployeess(); 
	
	public Employee findEmployeeById(String id);
	
	Boolean update(Employee employee,String id);
	 
	Integer insert(Employee employee);
	
	Boolean delete(String id);
}
