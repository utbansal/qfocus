package com.qafocus.data;

import java.util.List;

import lombok.Data;

@Data
public class Testcase {

	
	private String identifier;
	private String name;
	private String description;
	private List<String> tags;
	private List<String> labels;
	private List<String> releases;
	private boolean enabled;
	
}
