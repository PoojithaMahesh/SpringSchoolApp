package com.ty.spring_school_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ty.spring_school_app.dao.EmployeeDao;
import com.ty.spring_school_app.dto.Employee;
import com.ty.spring_school_app.exception.IdNotFoundException;
import com.ty.spring_school_app.repo.EmployeeRepo;
import com.ty.spring_school_app.util.ResponseStructure;

@org.springframework.stereotype.Service
public class EmpService {
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private EmployeeRepo repo;

//	public ResponseEntity<ResponseStructure<Employee>> saveEmp(Employee employee) {
//		if ((employee.getSalary() <= 30000) && (employee.getSalary() > 20000)) {
//			employee.setGrade('A');
//		} else if ((employee.getSalary() <= 20000) && (employee.getSalary() > 10000)) {
//			employee.setGrade('B');
//		} else if ((employee.getSalary() <= 10000)) {
//			employee.setGrade('C');
//		}
//		ResponseStructure<Employee> structure=new ResponseStructure<>();
//		Employee employee2= dao.saveEmployee(employee);
//		if(employee2!=null) {
//			structure.setMessage("Succesfully done");
//			structure.setStatus(HttpStatus.CREATED.value());
//			structure.setData(employee2);
//		}
//		return structure;
//	}
//	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id,Employee employee) {
//		if ((employee.getSalary() <= 30000) && (employee.getSalary() > 20000)) {
//			employee.setGrade('A');
//		} else if ((employee.getSalary() <= 20000) && (employee.getSalary() > 10000)) {
//			employee.setGrade('B');
//		} else if ((employee.getSalary() <= 10000)) {
//			employee.setGrade('C');
//		}
//		ResponseStructure<Employee> structure=new ResponseStructure<>();
//		 Employee employee2=dao.updateEmployee(id, employee);
//		if(employee2!=null) {
//			structure.setMessage("Succesfully done");
//			structure.setStatus(HttpStatus.OK.value());
//			structure.setData(employee2);
//		}
//		return structure;
//		
//	}
	public ResponseEntity<ResponseStructure<Employee>> getEmployee(int id){
		Employee employee=dao.getEmployee(id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		if(employee!=null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(employee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}else {
		throw new IdNotFoundException("id not found");
		}
	}
	
}
