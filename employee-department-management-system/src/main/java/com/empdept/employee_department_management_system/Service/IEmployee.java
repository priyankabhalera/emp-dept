package com.empdept.employee_department_management_system.Service;

import com.empdept.employee_department_management_system.Dtos.EmpDto;
import com.empdept.employee_department_management_system.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IEmployee {

    public Employee save(EmpDto empDto);

    public Optional<Employee> getById(long id);
    public List<Employee> getAll();



    public void removeEmp(long id);

    EmpDto updateEmp(Employee employee);
}
