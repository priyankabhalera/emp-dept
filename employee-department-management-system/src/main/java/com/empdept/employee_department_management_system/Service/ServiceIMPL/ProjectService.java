package com.empdept.employee_department_management_system.Service.ServiceIMPL;

import com.empdept.employee_department_management_system.Dtos.ProjectDto;
import com.empdept.employee_department_management_system.Entity.Department;
import com.empdept.employee_department_management_system.Entity.Project;
import com.empdept.employee_department_management_system.Exceptions.DtoConversionException;
import com.empdept.employee_department_management_system.Mapper.ProjectMapper;
import com.empdept.employee_department_management_system.Repository.ProjectRepository;
import com.empdept.employee_department_management_system.Service.IProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.empdept.employee_department_management_system.Mapper.ProjectMapper.toProjectDto;

@Service
public class ProjectService implements IProject {

    @Autowired
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository, ProjectRepository projectRepository1) {
        this.projectRepository = projectRepository1;
    }

    public ProjectDto save(Project project) {
        Project savedProject = projectRepository.save(project);
        ProjectDto projectDto = ProjectMapper.toProjectDto(savedProject);

        if (projectDto != null) {
            return projectDto;
        } else {
            throw new DtoConversionException("Dto conversion failed");
        }
    }

    @Override
    public Optional<Project> getById(long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::toProjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public void removeProject(long id) {
    projectRepository.deleteById(id);
    }
}
