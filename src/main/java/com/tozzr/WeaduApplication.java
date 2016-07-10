package com.tozzr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tozzr.domain.CustomerRequirementSpecification;
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
			Project pr = new Project("RMT", "Requirements Management Tool");
			pr.getCrs().add(new CustomerRequirementSpecification("CRS001", "Projekte", pr));
			repository.save(pr);
		};
	}
}
