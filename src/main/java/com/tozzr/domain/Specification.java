package com.tozzr.domain;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Specification implements Comparable<Specification> {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
	@NotNull
    private String key;
    
	private String name;
    private String text;
    private String examples;
    
    @Enumerated
    private SpecificationType type;
    	
    @NotNull
    @ManyToOne
    private Project project;
    
    protected Specification() {
	}
    
    public Specification(String key, Project project) {
    	this.key = key;
    	this.project = project;
    }

    @Override
	public int compareTo(Specification other) {
		return getKey().compareTo(other.getKey());
	}
	
}
