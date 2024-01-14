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
import com.example.demo.serviceIMP.EmpServImp;



@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
		private EmpServImp esi;
		
	@GetMapping("/home")
	public String homePage() {
		return "Welcome Employee Managemenmt";
	}
	
	@PostMapping("/addEmp")
	public ResponseEntity<Employee> addEmpl(@RequestBody Employee emp) {
		
		Employee e = esi.addEmp(emp);
		return new ResponseEntity<Employee>(e,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/RemoveEmp")
	public ResponseEntity<String> removeEmp(@PathVariable int id){
		esi.rmvEmp(id);
		
		return new ResponseEntity<String>("Removed Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/findEmp")
	public ResponseEntity<Optional<Employee>> findEmpById(@PathVariable int id){
		Optional<Employee> e= esi.findEmpById(id);
		return new ResponseEntity<Optional<Employee>>(e,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> listOfEmp(){
		List<Employee> lemp = esi.getAllEmp();
		return new ResponseEntity<List<Employee>>(lemp,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
}
