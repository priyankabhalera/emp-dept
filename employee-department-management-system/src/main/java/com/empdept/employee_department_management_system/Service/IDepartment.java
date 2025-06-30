package com.empdept.employee_department_management_system.Service;

import com.empdept.employee_department_management_system.Dtos.DeptDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IDepartment {
    public Optional<Department> getById(long id);
    public List<DeptDto> getAll();
    public DeptDto save(Department dept);
    public void removeEmp(long id);
}

