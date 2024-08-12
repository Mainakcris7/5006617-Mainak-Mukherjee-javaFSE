package com.exercise.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.employee.dao.Department;
import com.exercise.employee.service.DepartmentService;

@RestController
public class DepartmentControllers {
    @Autowired
    private DepartmentService deptService;

    @GetMapping("/departments")
    public List<Department> getDepartments() {
        return deptService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getTheDepartmentById(@PathVariable("id") long deptId) {
        return deptService.getDepartmentById(deptId);
    }

    @GetMapping("/departments/nameContains/{name}")
    public List<Department> getDepartmentBySubstring(@PathVariable("name") String name) {
        return deptService.getDepartmentsByNameContaining(name);
    }

    @PostMapping("/departments/save")
    public Department saveTheDepartment(@RequestBody Department dept) {
        return deptService.saveDepartment(dept);
    }

    @DeleteMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable("id") long deptId) {
        return deptService.deleteDepartmentById(deptId);
    }
}
