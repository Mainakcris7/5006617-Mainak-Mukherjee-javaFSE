package com.exercise.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exercise.employee.dao.Department;
import com.exercise.employee.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository deptRepo;

    public List<Department> getAllDepartments() {
        return deptRepo.findAll();
    }

    public Department getDepartmentById(long id) {
        return deptRepo.findById(id).orElse(new Department());
    }

    public List<Department> getDepartmentsByName(String name) {
        return deptRepo.findByName(name);
    }

    public List<Department> getDepartmentsByNameContaining(String name) {
        return deptRepo.findDepartmentsByNameContaining(name);
    }

    public Department saveDepartment(Department dept) {
        return deptRepo.save(dept);
    }

    public String deleteDepartmentById(long id) {
        deptRepo.deleteById(id);
        return "Department with " + id + "deleted successfully!";
    }

}
