package com.example.demo.serviceIMP;
//import springframework.beans.factory.annotation.Autowired(required=true)


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmpRepo;
import com.example.demo.service.EmpService;

public class EmpServImp implements EmpService{

	@Autowired
	EmpRepo empr;
	@Override
	public Employee addEmp(Employee emp) {
		Employee e = empr.save(emp);
		return e;
	}

	@Override
	public String rmvEmp(int id) {
		empr.deleteById(id);
		return "Employee deleted";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		
		Optional<Employee> emp = empr.findById(id);
		return Optional.empty();
	}

	@Override
	public String updEmp(int id) {
	
		Optional<Employee> emp = empr.findById(id);
		if(emp.isPresent()) {
			Employee newemp = new Employee(id, null, null);
			empr.save(newemp);
			return "Employee Added";
		}
	
			return "Employee not found";
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> l = empr.findAll();
		return l;
	}

}
