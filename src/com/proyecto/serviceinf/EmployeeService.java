package com.proyecto.serviceinf;

import java.util.List;

import com.proyecto.model.Employee;

public interface EmployeeService {
	
	public List<Employee> listEmployeess(); 

	public Employee findEmployeeById(String id);
	
	public Integer insert(Employee employee);
		
	public Boolean actualizar(Employee employee,String id);
	
	public Boolean eliminar(String id);
	
	
}
