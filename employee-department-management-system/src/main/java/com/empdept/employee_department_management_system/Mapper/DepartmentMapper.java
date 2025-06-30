package com.empdept.employee_department_management_system.Mapper;

import com.empdept.employee_department_management_system.Dtos.DeptDto;
import com.empdept.employee_department_management_system.Dtos.EmpDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Entity.Employee;
import com.empdept.employee_department_management_system.Repository.DepartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentMapper {

    public static DeptDto toDto(Department department) {
        DeptDto dto = new DeptDto();
        dto.setDeptId(department.getDeptId());
        dto.setName(department.getName());

        List<EmpDto> employeeDtos = (department.getEmpList() != null)
                ? department.getEmpList().stream().map(emp -> {
            EmpDto empDto = new EmpDto();
            empDto.setEmpId(emp.getEmpId());
            empDto.setName(emp.getName());
            empDto.setSalary(emp.getSalary());
            return empDto;
        }).collect(Collectors.toList())
                : List.of();


        dto.setEmpList(employeeDtos);
        return dto;
    }

    public static Department toEntity(DeptDto deptDto, DepartmentRepository departmentRepository) {
        Department existingDepartment = departmentRepository.findById(deptDto.getDeptId())
                .orElse(new Department());

        existingDepartment.setName(deptDto.getName());

        if (deptDto.getEmpList() != null && !deptDto.getEmpList().isEmpty()) {
            List<Employee> employees = deptDto.getEmpList().stream()
                    .map(EmployeeMapper::toEntityWithoutDepartment)
                    .collect(Collectors.toList());

            employees.forEach(emp -> emp.setDepartment(existingDepartment));
            existingDepartment.setEmpList(employees);
        } else {
            existingDepartment.setEmpList(List.of());
        }
        return existingDepartment;
    }
}
