package com.tozzr;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tozzr.domain.Project;
import com.tozzr.domain.ProjectRepository;
import com.tozzr.domain.Specification;

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
	
    @RequestMapping(value="/{id}", method=GET)
    public String project(@PathVariable("id") Long id, Model model) {
    	Project project = projectRepository.findOne(id);
		model.addAttribute("project", project);
        return "project";
    }

    @RequestMapping(value="/{id}/specs/{specId}", method=GET)
    public String specs(@PathVariable("id") long id, @PathVariable("specId") long specId, Model model) {
    	Project project = projectRepository.findOne(id);
		model.addAttribute("project", project);
    	model.addAttribute("spec", findSpec(project, specId));
        return "spec";
    }

	private Specification findSpec(Project project, long id) {
		for (Specification s : project.getSpecs())
			if (s.getId() == id)
				return s;
		return null;
	}
	
	@RequestMapping(value="/{id}/specs/{specId}", method=POST)
    public String updateSpec(@PathVariable("id") long id, @PathVariable("specId") long specId, Model model) {
    	return "redirect:/projects/" + id;
    }
}
