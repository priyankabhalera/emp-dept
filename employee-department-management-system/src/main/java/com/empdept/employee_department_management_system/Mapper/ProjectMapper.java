package com.empdept.employee_department_management_system.Mapper;

import com.empdept.employee_department_management_system.Dtos.ProjectDto;
import com.empdept.employee_department_management_system.Entity.Project;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDto toProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setprojectId(project.getId());
        projectDto.setName(project.getName());

        if (project.getAssignedEmployees() != null) {
            projectDto.setEmployeeIds(
                    project.getAssignedEmployees()
                            .stream()
                            .map(employee -> employee)
                            .collect(Collectors.toList())
            );
        }
        return projectDto;
    }

    public static Project toEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getprojectId());
        project.setName(projectDto.getName());
        return project;
    }
}
