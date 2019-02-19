package com.proyecto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.model.Employee;
import com.proyecto.model.EmployeeBean;
import com.proyecto.serviceinf.EmployeeService;



//import com.proyecto.bean.EmployeeBean;
//import com.proyecto.model.Employee;
//import com.proyecto.serviceinf.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired  
	 private EmployeeService employeeService; 	
	 
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/login")  
	public ModelAndView helloWorld() {
			
	  String message = "Spring 3.0.3 con Ibatis 2.3 CRUD Ejemplo";
	        
	   return new ModelAndView("login", "message", message);
	 }
	
	@RequestMapping(value="/employees", method = RequestMethod.GET)   
	 public ModelAndView listEmployees() {   
	  Map<String,Object> model = new HashMap<String,Object>();   
	  model.put("employees",  employeeService.listEmployeess());
	  return new ModelAndView("employeesList", model);   
	 } 

	 @RequestMapping(value = "/add", method = RequestMethod.GET)   
	 public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean, BindingResult result) {   
		 //Map<String,Object> model = new HashMap<String,Object>();   
	  //model.put("employees",  prepareListofBean(employeeService.listEmployeess()));   
	  return new ModelAndView("addEmployee");   
	 }
	 
	 @RequestMapping(value = "/save", method = RequestMethod.POST)   
	 public ModelAndView saveEmployee(@ModelAttribute("command")EmployeeBean employeeBean,BindingResult result) {   
		 System.out.println("nombre : "+employeeBean.getName());
		 System.out.println("Adress : "+employeeBean.getAddress());
		 Employee employee = prepareModel(employeeBean);   
	     employeeService.insert(employee);   
	   return new ModelAndView("redirect:/employees.html");   
	  }
	 

	 @RequestMapping(value = "/update", method = RequestMethod.POST)   
	 public ModelAndView updateEmployee(@ModelAttribute("command")EmployeeBean employeeBean,BindingResult result) {   
		 System.out.println("nombre : "+employeeBean.getName());
		 System.out.println("Adress : "+employeeBean.getAddress());
		 System.out.println("Id Update : "+employeeBean.getId());
		 Employee employee = prepareModel(employeeBean);   
		 System.out.println("Id Update2 : "+employee.getId());
	     employeeService.actualizar(employee, String.valueOf(employeeBean.getId()));  
	   return new ModelAndView("redirect:/employees.html");   
	  }
	
	 
	 @RequestMapping(value = "/delete", method = RequestMethod.GET)   
	 public ModelAndView editEmployee(@ModelAttribute("command")EmployeeBean employeeBean, BindingResult result,@RequestParam(value = "id")String idElimi) {   
	   
	  System.out.println("idEmployee a Eliminar : "+employeeBean.getId());
	  System.out.println("idEmployee a Eliminar2 : "+idElimi);
	  employeeService.eliminar(idElimi);
	   Map<String,Object> model = new HashMap<String, Object>();   
	   model.put("employee", null);   
	   model.put("employees",  employeeService.listEmployeess());   
	   return new ModelAndView("employeesList", model);  
	  }  
	 
	 
	 @RequestMapping(value = "/edit", method = RequestMethod.GET)   
	 public ModelAndView deleteEmployee(@ModelAttribute("command")EmployeeBean employeeBean,BindingResult result,@RequestParam(value = "id")String idUpdate) {   
	   Map<String, Object> model = new HashMap<String, Object>();   
	    System.out.println("idEmployee a Actualizar : "+employeeBean.getId());
	    System.out.println("idEmployee a Actualizar : "+idUpdate);
	    model.put("employee", employeeService.findEmployeeById(idUpdate));   
	   return new ModelAndView("editEmployee", model);   
	  
	 }
	 
	 
	 private Employee prepareModel(EmployeeBean employeeBean){   
		  Employee employee = new Employee();   
		  employee.setAddress(employeeBean.getAddress());   
		  employee.setAge(employeeBean.getAge());   
		  employee.setName(employeeBean.getName());   
		  employee.setSalary(employeeBean.getSalary());   
		  employee.setId(employeeBean.getId());   
		  return employee;   
	 } 
	
	
}
