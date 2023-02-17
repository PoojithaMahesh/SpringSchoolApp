package com.ty.spring_school_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.ty.spring_school_app.dto.Employee;
import com.ty.spring_school_app.dto.Student;
import com.ty.spring_school_app.repo.EmployeeRepo;

@Repository
public class EmployeeDao {
	@Autowired
	private EmployeeRepo repo;
	
	
	public Employee saveEmployee( Employee employee) {
		return repo.save(employee);
	}
	public Employee deleteEmployee(int id) {
		
		Employee employee=repo.findById(id).get();
		repo.deleteById(id);
		return employee;
	}
     public Employee getEmployee(int id) {
    	 if(repo.findById(id).isPresent()) {
    		 return repo.findById(id).get();
    	 }
    	 return null;
     }
     public Employee updateEmployee(int id ,Employee employee) {
              Employee employee2=repo.findById(id).get();
    	 if(employee2!=null) {
    		employee.setId(id);
    		return repo.save(employee);
    	 }
    	 return null;
     }
}
