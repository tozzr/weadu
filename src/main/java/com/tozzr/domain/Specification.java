package com.tozzr.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Specification {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@NotNull
    private String key;
    
    private String text;
    private String examples;
    
    @Enumerated
    private SpecificationType type;
    	
    @NotNull
    @ManyToOne
    private Project project;
    
    @OneToOne
    private Specification next;
    
    public Specification() {
	}
    
    public Specification(String key, Project project) {
    	this.key = key;
    	this.project = project;
    }

    public static Specification version(Specification spec) {
		Specification s = new Specification(spec.getKey(), spec.getProject());
		s.setText(spec.getText());
		s.setType(spec.getType());
		spec.setNext(s);
		return s;
	}

}
