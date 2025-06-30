package com.empdept.employee_department_management_system.Service.ServiceIMPL;

import com.empdept.employee_department_management_system.Dtos.EmpDto;
import com.empdept.employee_department_management_system.Entity.Employee;
import com.empdept.employee_department_management_system.Exceptions.ResourceNotFoundException;
import com.empdept.employee_department_management_system.Mapper.EmployeeMapper;
import com.empdept.employee_department_management_system.Repository.DepartmentRepository;
import com.empdept.employee_department_management_system.Repository.EmployeeRepository;
import com.empdept.employee_department_management_system.Repository.ProjectRepository;
import com.empdept.employee_department_management_system.Service.IEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService implements IEmployee {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ProjectRepository projectRepository;


    @Override
    public Employee save(EmpDto empDto) {
        Employee employee = EmployeeMapper.toEntity(empDto, departmentRepository, projectRepository);
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void removeEmp(long id) {
        employeeRepository.deleteById(id);
    }

    public EmpDto updateEmp(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getEmpId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        if (employee.getName() != null) {
            emp.setName(employee.getName());
        }
        if (employee.getSalary() != null) {
            emp.setSalary(employee.getSalary());
        }
        if (employee.getDepartment() != null) {
            emp.setDepartment(employee.getDepartment());
        }
        if (employee.getProjects() != null) {
            emp.setProjects(employee.getProjects());
        }
        employeeRepository.save(emp);
        return EmployeeMapper.toEmpDto(emp);
    }

}
