package com.tozzr.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CustomerRequirementSpecification implements Comparable<CustomerRequirementSpecification> {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String key;
    private String name;
    private String description;
	
    @ManyToOne
    private Project project;
    
    public CustomerRequirementSpecification(String key, String name, Project project) {
		this.key = key;
		this.name = name;
		this.project = project;
	}

	public long getId() {
		return id;
	}
	
    public void setId(long id) {
		this.id = id;
	}
	
    public String getKey() {
		return key;
	}
	
    public void setKey(String key) {
		this.key = key;
	}
	
    public String getName() {
		return name;
	}
	
    public void setName(String name) {
		this.name = name;
	}
	
    public String getDescription() {
		return description;
	}
	
    public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(CustomerRequirementSpecification other) {
		return getKey().compareTo(other.getKey());
	}
    
}
