package com.empdept.employee_department_management_system.Service;

import com.empdept.employee_department_management_system.Dtos.ProjectDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IProject {
    ProjectDto save(Project project);

    Optional<Project> getById(long id);

    List<ProjectDto> getAll();

    void removeProject(long id);
}
