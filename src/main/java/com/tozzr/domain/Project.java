package com.tozzr.domain;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String key;
    private String name;
    private Date begin;
    private Date end;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @OrderBy("key")
    private SortedSet<Specification> specs = new TreeSet<Specification>();

    protected Project() {
    }

	public Project(String key, String name) {
		super();
		this.key = key;
		this.name = name;
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

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public SortedSet<Specification> getSpecs() {
		return specs;
	}

	public void setSpecs(SortedSet<Specification> specs) {
		this.specs = specs;
	}
	
}
