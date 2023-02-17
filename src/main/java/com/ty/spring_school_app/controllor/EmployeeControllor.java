package com.ty.spring_school_app.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.spring_school_app.dao.EmployeeDao;
import com.ty.spring_school_app.dto.Employee;
import com.ty.spring_school_app.dto.Student;
import com.ty.spring_school_app.service.EmpService;
import com.ty.spring_school_app.util.ResponseStructure;

@RestController
public class EmployeeControllor {
	@Autowired
	private EmpService empService;
	@Autowired
	private EmployeeDao dao;
//	@PostMapping("/saveemp")
//	public ResponseEntity<ResponseStructure<Employee>>  saveEmployee(@RequestBody Employee employee) {
//		 return empService.saveEmp(employee);
//	}
	@DeleteMapping("/deleteemp")
	public Employee deleteEmployee(@RequestParam int id) {
		return dao.deleteEmployee(id);
	}
	@GetMapping("/getemp/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployee(@PathVariable int id) {
		return empService.getEmployee(id);
	}
//	@PutMapping("/updateemp")
//	public ResponseEntity<ResponseStructure<Employee>> getEmployee(@RequestParam int id,@RequestBody Employee employee) {
//		return empService.updateEmployee(id, employee);
//	}
}
