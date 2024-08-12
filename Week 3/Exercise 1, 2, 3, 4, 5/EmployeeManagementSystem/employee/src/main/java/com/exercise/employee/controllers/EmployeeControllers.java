package com.exercise.employee.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.exercise.employee.dao.Employee;
import com.exercise.employee.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeControllers {
    @Autowired
    private EmployeeService empService;

    @GetMapping("/")
    public String getIndex() {
        return "Welcome to the Employee Management system!\n" +
                "/employees for the Employees\n" +
                "/departments for Departments";
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return empService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getTheEmployeeById(@PathVariable("id") long empId) {
        return empService.getEmployeeById(empId);
    }

    @GetMapping("/employees/department/{name}")
    public List<Employee> getEmployeeByDepartmentName(@PathVariable("name") String deptName) {
        return empService.getEmployeesByDepartName(deptName);
    }

    @PostMapping("/employees/save")
    public Employee saveTheEmployee(@RequestBody Employee emp) {
        return empService.saveEmployee(emp);
    }

    @DeleteMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long empId) {
        return empService.deleteEmployeeById(empId);
    }

}
