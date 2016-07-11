package com.tozzr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tozzr.domain.Specification;
import com.tozzr.domain.Project;
import com.tozzr.domain.ProjectRepository;

@SpringBootApplication
public class WeaduApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeaduApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ProjectRepository repository) {
		return (args) -> {
			Project project = new Project("RMT", "Requirements Management Tool");
			Specification spec = new Specification("CRS001", project);
			spec.setName("Projekte");
			spec.setText("Das System muss mehre Anforderungen in Projekten gruppiert erfassen können.");
			spec.setExamples("Projekt 1, ..., Projekt N");
			project.getSpecs().add(spec);
			
			spec = new Specification("CRS002", project);
			spec.setName("Anforderungstypen");
			spec.setText("Das System muss mehrere unterschiedliche Anforderungstypen unterstützen.");
			spec.setExamples("CRS, SRS, SAR");
			project.getSpecs().add(spec);
			
			spec = new Specification("CRS003", project);
			spec.setName("Links");
			spec.setText("Das System muss Anforderungen verlinken können.");
			spec.setExamples("Vorgänger, Nachfolger");
			project.getSpecs().add(spec);

			repository.save(project);
		};
	}
}
