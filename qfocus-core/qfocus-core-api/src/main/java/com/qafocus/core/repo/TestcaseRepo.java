package com.qafocus.core.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qafocus.core.entity.TestcaseE;

@Repository
public interface TestcaseRepo extends CrudRepository<TestcaseE, Long> {

	  List<TestcaseE> findByName(String lastName);

	  TestcaseE findById(long id);
	  
	}