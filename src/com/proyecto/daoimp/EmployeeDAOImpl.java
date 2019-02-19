package com.proyecto.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.proyecto.daoinf.EmployeeDAO;
//import com.proyecto.daoinf.EmployeeDAO;
import com.proyecto.model.Employee;



public class EmployeeDAOImpl extends SqlMapClientDaoSupport implements EmployeeDAO {

	@Override
	public List<Employee> listEmployeess() {
		List<Employee> result = new ArrayList<Employee>();
		result=(List<Employee>)getSqlMapClientTemplate().queryForList("employee.selectAll");
		
		return result;
	}
	
	@Override
	public Employee findEmployeeById(String id) {
		
		
		 HashMap<String, Object> params = new HashMap<String, Object>();
	     params.put("id",Integer.parseInt(id));
		
		List<Employee> result = new ArrayList<Employee>();
		result=(List<Employee>)getSqlMapClientTemplate().queryForList("employee.selectbyId",params);
		
		return result.get(0);
	}

	@Override
	public Boolean update(Employee employee, String id) {
		// TODO Auto-generated method stub
		  HashMap<String, Object> params = new HashMap<String, Object>();
		  
		  System.out.println("id a actualizar : "+id);
		  
		  params.put("name",employee.getName());
		  params.put("age",employee.getAge());
		  params.put("salary",employee.getSalary());
		  params.put("address",employee.getAddress());
		  params.put("id",Integer.parseInt(id));
		  
		  Boolean resultado = false;
		             
	      int exito = getSqlMapClientTemplate().update("employee.update", params);
	      resultado = exito>0?true:false;
		       
	       return resultado; 
		       
	}
	
	public Boolean delete(String id){
		
		Boolean resultado = false;
		HashMap<String, Object> params = new HashMap<String, Object>();
		  
		System.out.println("id a eliminar : "+id);
		
		params.put("id",Integer.parseInt(id));
		
	    int exito = getSqlMapClientTemplate().delete("employee.delete", params);
	    resultado = exito>0?true:false;
		       
	    return resultado; 
		
	}
	

	@Override
	public Integer insert(Employee employee){
			
	        HashMap<String, Object> map = new HashMap<String, Object>();

		    System.out.println("Insertando...");
		    System.out.println("Name...:"+employee.getName());
		    System.out.println("Age...:"+employee.getAge());
	        
	        map.put("id", employee.getId());
	        map.put("name", employee.getName() );
	        map.put("age", employee.getAge() );
	        map.put("salary", employee.getSalary() );
	        map.put("address", employee.getAddress() );

            getSqlMapClientTemplate().insert("employee.insert", map);
		
		return employee.getId();
	}
}
