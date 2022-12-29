package com.example.crud.controller;

import com.example.crud.entity.Employee;
import com.example.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // add
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
        Employee employee = this.employeeService.add(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    // update
    @PutMapping("/empId")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable int empId) {
        Employee employee = this.employeeService.update(emp, empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // delete
    @DeleteMapping("/empId")
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable int empId) {
        this.employeeService.delete(empId);

        Map<String, String> message = Map.of("message", "employee deleted successfully");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // get single employee
    @GetMapping("/empId")
    public ResponseEntity<Employee> getEmployee(@PathVariable int empId) {
        Employee employee = this.employeeService.getById(empId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // get All employees
    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> group = this.employeeService.getAll();
        return new ResponseEntity<>(group, HttpStatus.OK);
    }




//    @Autowired
//    private EmployeeService employee Service;
//
//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return employeeService.save(employee);
//    }
//    @GetMapping()
//    public Employee getEmployee(@PathVariable int id) {
//        return employeeService.getEmployee(id);
//    }
//    public EmployeeService getEmployeeService() {
//        return employeeService;
//    }
//
//    public void setEmployeeService(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
}
