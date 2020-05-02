package com.qafocus.core.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qafocus.core.entity.TestcaseE;

public interface TestcaseRepo extends CrudRepository<TestcaseE, Long> {

	  List<TestcaseE> findByLastName(String lastName);

	  TestcaseE findById(long id);
	  
	}