package com.exercise.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.exercise.employee.dao.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // Custom query methods
    List<Department> findByName(String name);

    @Query("from Department where name like %:substring%")
    List<Department> findDepartmentsByNameContaining(@Param("substring") String substring);
}
