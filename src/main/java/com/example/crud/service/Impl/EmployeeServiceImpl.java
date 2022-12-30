package com.example.crud.service.Impl;

import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EmployeeServiceImpl implements EmployeeService {
    // This is our implementation part
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee add(Employee emp) {
        return this.employeeRepository.save(emp);
    }

    @Override
    public Employee update(Employee emp, int empId) {  // new emp but old empId
        Employee employee = this.employeeRepository.findById(empId).orElseThrow(() ->
                new RuntimeException("Employee not found"));
        employee.setName(emp.getName());
        employee.setAge(emp.getAge());

        Employee save = this.employeeRepository.save(employee);
        return save;
    }

    @Override
    public void delete(int empId) {
        Employee employee = this.employeeRepository.findById(empId).orElseThrow(() ->
                new RuntimeException("Employee not found"));
        this.employeeRepository.delete(employee);
    }

    @Override
    public Employee getById(int empId) {
      Employee employee = this.employeeRepository.findById(empId).orElseThrow(() ->
              new RuntimeException("Employee not found"));
      return employee;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> group = this.employeeRepository.findAll();
        return group;
    }
}
