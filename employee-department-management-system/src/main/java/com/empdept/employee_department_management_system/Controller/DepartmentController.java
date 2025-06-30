package com.empdept.employee_department_management_system.Controller;

import com.empdept.employee_department_management_system.Dtos.DeptDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Exceptions.ResourceNotFoundException;
import com.empdept.employee_department_management_system.Mapper.DepartmentMapper;
import com.empdept.employee_department_management_system.Service.ServiceIMPL.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

    @Autowired
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/save")
    public ResponseEntity<DeptDto> save(@RequestBody Department dept) {
        DeptDto savedDept = departmentService.save(dept);
        return ResponseEntity.ok(savedDept);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeptDto> getEmpById(@PathVariable long id) throws ResourceNotFoundException {
        Optional<Department> department = departmentService.getById(id);

        return department.map(dept -> ResponseEntity.ok(DepartmentMapper.toDto(dept)))
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    @GetMapping
    public ResponseEntity<List<DeptDto>> getAll() {
        List<DeptDto> departments = departmentService.getAll();
        return ResponseEntity.ok(departments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable long id) {
        departmentService.removeEmp(id);
        return ResponseEntity.ok("Department removed successfully");
    }
}
