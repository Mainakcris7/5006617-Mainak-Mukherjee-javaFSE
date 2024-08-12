package com.exercise.employee.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.exercise.employee.dao.Employee;
import com.exercise.employee.dao.EmployeeNameEmailDTO;
import com.exercise.employee.projection.EmployeeNameEmailProjection;
import com.exercise.employee.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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

    // @GetMapping("/employees")
    // public List<Employee> getEmployees() {
    // return empService.getAllEmployees();
    // }

    // @GetMapping("/employees/department/{name}")
    // public List<Employee> getEmployeeByDepartmentName(@PathVariable("name")
    // String deptName) {
    // return empService.getEmployeesByDepartName(deptName);
    // }

    @GetMapping("/employees/name-email")
    public List<EmployeeNameEmailProjection> getEmployeesNameAndEmail() {
        return empService.getNameAndEmail();
    }

    @GetMapping("/employees/name-email/{name}")
    public List<EmployeeNameEmailDTO> getNameAndEmailByName(@PathVariable String name) {
        return empService.getNameAndEmailByName(name);
    }

    // @PostMapping("/employees/save")
    // public Employee saveTheEmployee(@RequestBody Employee emp) {
    // return empService.saveEmployee(emp);
    // }

    // @DeleteMapping("/employees/delete/{id}")
    // public String deleteEmployee(@PathVariable("id") long empId) {
    // return empService.deleteEmployeeById(empId);
    // }

}
