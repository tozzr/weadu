package com.tozzr.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String key;
    private String name;
    private Date begin;
    private Date end;

    protected Project() {}

    public Project(String key, String name) {
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

	@Override
    public String toString() {
        return String.format(
                "Project[id=%d, key='%s', name='%s']",
                id, key, name);
    }

}

