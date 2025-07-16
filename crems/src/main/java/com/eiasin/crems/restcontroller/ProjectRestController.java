package com.eiasin.crems.restcontroller;

import com.eiasin.crems.entity.Project;
import com.eiasin.crems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project/")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("")
    public List<Project> findAll() {
        return projectService.findAll();
    }

    @PostMapping("")
    public void save(Project project) {
        projectService.save(project);
    }

    @PostMapping("")
    public void edit(Project project) {
        projectService.edit(project);
    }

    @DeleteMapping("")
    public void delete(Integer id) {
        projectService.delete(id);
    }

}
