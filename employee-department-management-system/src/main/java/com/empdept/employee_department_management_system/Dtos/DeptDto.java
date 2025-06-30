package com.empdept.employee_department_management_system.Dtos;

import com.empdept.employee_department_management_system.Entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class DeptDto {
    private long deptId;
    private String name;
    //@JsonIgnore
    private List<EmpDto> empList;


    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<EmpDto> getEmpList() {
        return empList;
    }

    public void setEmpList(List<EmpDto> empList) {
        this.empList = empList;
    }
}
