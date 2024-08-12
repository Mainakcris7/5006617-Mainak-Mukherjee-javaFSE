package com.exercise.employee.dao;

public class EmployeeNameEmailDTO {

    private String name;
    private String email;

    public EmployeeNameEmailDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "EmployeeNameEmailDTO [name=" + name + ", email=" + email + "]";
    }
}
