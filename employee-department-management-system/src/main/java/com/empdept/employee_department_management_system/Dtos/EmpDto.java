package com.empdept.employee_department_management_system.Dtos;

import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Entity.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {
    private long empId;
    private String name;
    private Double salary;
    //@JsonIgnore
    private Department department;
    private Set<Project> projects;

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
