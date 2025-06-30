package com.empdept.employee_department_management_system.Controller;

import com.empdept.employee_department_management_system.Dtos.ProjectDto;
import com.empdept.employee_department_management_system.Entity.Project;
import com.empdept.employee_department_management_system.Exceptions.ResourceNotFoundException;
import com.empdept.employee_department_management_system.Mapper.ProjectMapper;
import com.empdept.employee_department_management_system.Service.IProject;

import com.empdept.employee_department_management_system.Service.ServiceIMPL.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private final IProject projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProjectDto> save(@RequestBody Project project) {
        ProjectDto savedProject = projectService.save(project);
        return ResponseEntity.ok(savedProject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getEmpById(@PathVariable long id) throws ResourceNotFoundException {
        Optional<Project> project = projectService.getById(id);

        return project.map(emp -> ResponseEntity.ok(ProjectMapper.toProjectDto(emp)))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

    }


    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll() {
        List<ProjectDto> projects = projectService.getAll();
        return ResponseEntity.ok(projects);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable long id) {
        projectService.removeProject(id);
        return ResponseEntity.ok("Department removed successfully");
    }

}
