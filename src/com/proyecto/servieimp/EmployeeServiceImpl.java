package com.proyecto.servieimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.daoinf.EmployeeDAO;
import com.proyecto.model.Employee;
import com.proyecto.serviceinf.EmployeeService;

@Service("employeeService")
	public class EmployeeServiceImpl implements EmployeeService {

		
		@Autowired
		private EmployeeDAO employeeDAO;
		
		public void setEmployeeDAO(EmployeeDAO employeeDAO) {
			this.employeeDAO = employeeDAO;
		}
		
		@Override
		public List<Employee> listEmployeess() {
			// TODO Auto-generated method stub
			List<Employee> result = null;
			 result= employeeDAO.listEmployeess();
			return result;
			
		}
		
		public Employee findEmployeeById(String id) {
			// TODO Auto-generated method stub
			Employee result = new Employee();
			 result= employeeDAO.findEmployeeById(id);
			return result;
			
		}
		
		public Integer insert(Employee employee){
		       return  employeeDAO.insert(employee);
		}
		
		public Boolean actualizar(Employee employee,String id){
			return employeeDAO.update(employee, id);
		}
		
		public Boolean eliminar(String id){
			return employeeDAO.delete(id);
		}

		
   }
