package com.empdept.employee_department_management_system.Repository;

import com.empdept.employee_department_management_system.Dtos.DeptDto;
import com.empdept.employee_department_management_system.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
