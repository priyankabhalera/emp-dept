package com.empdept.employee_department_management_system.Repository;

import com.empdept.employee_department_management_system.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Optional<Project> findByName(String name);
}
