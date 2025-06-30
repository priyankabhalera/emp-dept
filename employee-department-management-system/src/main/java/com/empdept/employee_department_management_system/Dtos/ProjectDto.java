package com.empdept.employee_department_management_system.Dtos;

import com.empdept.employee_department_management_system.Entity.Employee;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProjectDto {
    private long projectId;
    private String name;
    private List<Employee> assignedEmp;

    public long getprojectId() {
        return projectId;
    }

    public void setprojectId(long id) {
        this.projectId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeIds() {
        return assignedEmp;
    }

    public void setEmployeeIds(List<Employee> assignedEmp) {
        this.assignedEmp = assignedEmp;
    }
}
