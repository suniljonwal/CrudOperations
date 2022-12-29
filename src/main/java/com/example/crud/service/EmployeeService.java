package com.example.crud.service;

import com.example.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // create                                  // this is a method
    Employee add(Employee emp);            // return type Employee, in argument taking emp.

    // update
    Employee update(Employee emp, int empId);

    // delete
    void delete(int empId);

    // get single employee
    Employee getById(int empId);

    // get All employees
    List<Employee> getAll();


//    @Autowired
//    private EmployeeRepository employeeRepository;
//    public Employee save(Employee emp) {
//        return employeeRepository.save(emp);
//    }
//
//    public Employee getEmployee(int id) {
//        return employeeRepository.findById(id).get();
//    }
//
//    public Employee update(Employee employee) {
//        Employee emp = employeeRepository.findById(employee.getId()).get();
//        emp.setName(employee.getName());
//        emp.setAge(employee.getAge());
//        return employeeRepository.save(emp);
//    }
//
//    public EmployeeRepository getEmployeeRepository() {
//        return employeeRepository;
//    }
//
//    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
}
