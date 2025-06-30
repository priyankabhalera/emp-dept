package com.empdept.employee_department_management_system.Controller;

import com.empdept.employee_department_management_system.Dtos.EmpDto;
import com.empdept.employee_department_management_system.Entity.Employee;
import com.empdept.employee_department_management_system.Exceptions.ResourceNotFoundException;
import com.empdept.employee_department_management_system.Mapper.DepartmentMapper;
import com.empdept.employee_department_management_system.Mapper.EmployeeMapper;
import com.empdept.employee_department_management_system.Service.IEmployee;
import com.empdept.employee_department_management_system.Service.ServiceIMPL.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private final IEmployee employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> save(@RequestBody EmpDto empDto) {
        Employee savedEmployee = employeeService.save(empDto);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpDto> getEmpById(@PathVariable long id) throws ResourceNotFoundException {
        Optional<Employee> employee = employeeService.getById(id);

        return employee.map(emp -> ResponseEntity.ok(EmployeeMapper.toEmpDto(emp)))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }


    @GetMapping
    public ResponseEntity<List<Employee>>getAll()
    {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable long id)
    {
        employeeService.removeEmp(id);
        return ResponseEntity.ok("Employee with Id "+id+" removed successfully");
    }

    @PatchMapping
    public ResponseEntity<EmpDto> updateEmp(@RequestBody Employee employee)
    {
        EmpDto empDto = employeeService.updateEmp(employee);
        return ResponseEntity.ok(empDto);
    }
}
