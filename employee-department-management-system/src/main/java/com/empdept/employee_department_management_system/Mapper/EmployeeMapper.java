package com.empdept.employee_department_management_system.Mapper;

import com.empdept.employee_department_management_system.Dtos.EmpDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Entity.Employee;
import com.empdept.employee_department_management_system.Entity.Project;
import com.empdept.employee_department_management_system.Repository.DepartmentRepository;
import com.empdept.employee_department_management_system.Repository.ProjectRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmpDto toEmpDto(Employee employee) {
        EmpDto empDto = new EmpDto();
        empDto.setEmpId(employee.getEmpId());
        empDto.setName(employee.getName());
        empDto.setSalary(employee.getSalary());

        if (employee.getDepartment() != null) {
            empDto.setDepartment(employee.getDepartment());
        }
        if (employee.getProjects() != null) {
            empDto.setProjects(new HashSet<>(employee.getProjects()));
        }

        return empDto;
    }
    public static Employee toEntity(EmpDto empDto, DepartmentRepository departmentRepository, ProjectRepository projectRepository) {
        Employee employee = new Employee();
        try {
            employee.setEmpId(empDto.getEmpId());
            employee.setName(empDto.getName());
            employee.setSalary(empDto.getSalary());

            if (empDto.getDepartment() != null && empDto.getDepartment().getDeptId() != 0) {
                Department department = departmentRepository.findById(empDto.getDepartment().getDeptId())
                        .orElseThrow(() -> new RuntimeException("Department not found!"));
                employee.setDepartment(department);
            }


            if (empDto.getProjects() != null && !empDto.getProjects().isEmpty()) {
                Set<Project> projects = empDto.getProjects().stream()
                        .map(proj -> projectRepository.findById (proj.getId())
                                .orElseThrow(() -> new RuntimeException("Project with name '" + proj.getName() + "' not found!")))
                        .collect(Collectors.toSet());
                employee.setProjects(projects);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error processing employee data: " + e.getMessage());
        }
        return employee;
    }

    public static Employee toEntityWithoutDepartment(EmpDto empDto) {
        Employee employee = new Employee();
        employee.setEmpId(empDto.getEmpId());
        employee.setName(empDto.getName());
        employee.setSalary(empDto.getSalary());

        if (empDto.getProjects() != null) {
            employee.setProjects(new HashSet<>(empDto.getProjects()));
        }

        return employee;
    }
}
