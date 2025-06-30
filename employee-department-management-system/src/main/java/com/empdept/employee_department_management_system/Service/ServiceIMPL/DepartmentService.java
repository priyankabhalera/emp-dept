package com.empdept.employee_department_management_system.Service.ServiceIMPL;

import com.empdept.employee_department_management_system.Dtos.DeptDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Exceptions.DtoConversionException;
import com.empdept.employee_department_management_system.Mapper.DepartmentMapper;
import com.empdept.employee_department_management_system.Mapper.ProjectMapper;
import com.empdept.employee_department_management_system.Repository.DepartmentRepository;
import com.empdept.employee_department_management_system.Service.IDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements IDepartment {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DeptDto save(Department dept) {
        Department department = departmentRepository.save(dept);
        DeptDto deptDto = DepartmentMapper.toDto(department);

        if(deptDto != null)
        {
            return deptDto;
        }
        else throw new DtoConversionException("Dto conversion failed");
    }


    @Override
    public Optional<Department> getById(long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<DeptDto> getAll() {
        return departmentRepository.findAll().stream()
                .map(DepartmentMapper::toDto)
                        .collect(Collectors.toList());
    }

    @Override
    public void removeEmp(long id) {
        departmentRepository.deleteById(id);
    }
}
