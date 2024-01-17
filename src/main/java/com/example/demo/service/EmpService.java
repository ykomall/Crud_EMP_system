package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;


@Service
public class EmpService {
	
	@Autowired
	EmpRepo empr;
	
	public Employee addEmp(Employee emp) {
		Employee e = empr.save(emp);
		return e;
	}

	
	public String rmvEmp(int id) {
		empr.deleteById(id);
		return "Employee deleted";
	}

	
	public Optional<Employee> findEmpById(int id) {
		
		Optional<Employee> emp = empr.findById(id);
		return Optional.empty();
	}

	
	public String updEmp(int id) {
	
		Optional<Employee> emp = empr.findById(id);
		if(emp.isPresent()) {
			Employee newemp = new Employee(id, null, null);
			empr.save(newemp);
			return "Employee Added";
		}
	
			return "Employee not found";
	}

	
	public List<Employee> getAllEmp() {
		List<Employee> l = empr.findAll();
		return l;
	}

}
