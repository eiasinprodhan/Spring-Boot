package com.eiasin.crems.service;

import com.eiasin.crems.entity.Project;
import com.eiasin.crems.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Integer id) {
        return projectRepository.findById(id).get();
    }

    public void delete(Integer id) {
        projectRepository.deleteById(id);
    }

    public void edit(Project project) {
        projectRepository.save(project);
    }
}
