package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmpService;
//import com.example.demo.serviceIMP.EmpServImp;



@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
		private EmpService eservice;
		
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to Employee Managemenmt";
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmpl(@RequestBody Employee emp) {
		
		Employee e = eservice.addEmp(emp);
		return new ResponseEntity<Employee>(e,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/RemoveEmp{id}")
	public ResponseEntity<String> removeEmp(@PathVariable int id){
		eservice.rmvEmp(id);
		
		return new ResponseEntity<String>("Removed Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findEmp{id}")
	public ResponseEntity<Optional<Employee>> findEmpById(@PathVariable int id){
		Optional<Employee> e= eservice.findEmpById(id);
		return new ResponseEntity<Optional<Employee>>(e,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> listOfEmp(){
		List<Employee> lemp = eservice.getAllEmp();
		return new ResponseEntity<List<Employee>>(lemp,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
}
