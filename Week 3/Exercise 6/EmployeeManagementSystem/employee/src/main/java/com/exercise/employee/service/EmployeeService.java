package com.exercise.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.exercise.employee.dao.Employee;
import com.exercise.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository empRepo;

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public Employee getEmployeeById(long id) {
        return empRepo.findById(id).orElse(new Employee());
    }

    public List<Employee> getEmployeesByName(String name) {
        return empRepo.findByName(name);
    }

    public Employee saveEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    public List<Employee> getEmployeesByDepartName(String deptName) {
        return empRepo.findByDepartmentName(deptName);
    }

    // Sorting
    public List<Employee> getEmployeesSorted(String field, String strategy) {
        if (strategy.equals("DESC")) {
            return empRepo.findAll(Sort.by(Sort.Direction.DESC, field));
        } else {
            return empRepo.findAll(Sort.by(field));
        }
    }

    // Pagination
    public Page<Employee> getPagedEmployees(int offset, int size) {
        Pageable p = PageRequest.of(offset, size);
        return empRepo.findAll(p);

    }

    // Pagination with Sorting
    public Page<Employee> getPagedSortedEmployees(int offset, int size, String field) {
        Pageable p = PageRequest.of(offset, size).withSort(Sort.by(field));
        return empRepo.findAll(p);

    }

    public String deleteEmployeeById(long id) {
        empRepo.deleteById(id);
        return "Employee with " + id + "deleted successfully!";
    }
}
