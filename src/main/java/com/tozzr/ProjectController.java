package com.tozzr;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tozzr.domain.Project;
import com.tozzr.domain.ProjectRepository;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	
	@ModelAttribute("projects")
	public Iterable<Project> populateProjects() {
		return projectRepository.findAll();
	}
	
	@RequestMapping(method=GET)
    public String projects() {
        return "projects";
    }
	
    @RequestMapping(value="{id}", method=GET)
    public String specs(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("project", projectRepository.findOne(id));
        return "project";
    }

}
