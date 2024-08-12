package com.exercise.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.employee.dao.Employee;
import com.exercise.employee.dao.EmployeeNameEmailDTO;
import com.exercise.employee.projection.EmployeeNameEmailProjection;
import com.exercise.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    // public List<Employee> getAllEmployees() {
    // return empRepo.findAll();
    // }

    // public List<Employee> getEmployeesByName(String name) {
    // return empRepo.findByName(name);
    // }

    // public Employee saveEmployee(Employee emp) {
    // return empRepo.save(emp);
    // }

    // public List<Employee> getEmployeesByDepartName(String deptName) {
    // return empRepo.findByDepartmentName(deptName);
    // }

    public List<EmployeeNameEmailProjection> getNameAndEmail() {
        return empRepo.findBy();
    }

    // public String deleteEmployeeById(long id) {
    // empRepo.deleteById(id);
    // return "Employee with " + id + "deleted successfully!";
    // }

    public List<EmployeeNameEmailDTO> getNameAndEmailByName(String name) {
        return empRepo.findByName(name);
    }
}
