package com.qafocus.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TestcaseE {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String identifier;
	private String name;
	private String description;
	private List<String> tags;
	private List<String> labels;
	private List<String> releases;
	private boolean enabled;
	
	public TestcaseE(String identifier) {
		this.identifier = identifier;
	}
	
	
	
}
