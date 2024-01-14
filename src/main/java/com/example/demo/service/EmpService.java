package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Employee;

public interface EmpService {
 public Employee addEmp(Employee emp);
 public String rmvEmp(int id);
 public Optional<Employee> findEmpById(int id);
 public String updEmp(int id);
 public List<Employee> getAllEmp();
}
