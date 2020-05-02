package com.qafocus.core.api.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qafocus.core.entity.TestcaseE;
import com.qafocus.core.repo.TestcaseRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class QFocusAPIApp {
	
	public static void main(String[] args) {
		SpringApplication.run(QFocusAPIApp.class, args);
	}

	
	@Bean
	  public CommandLineRunner demo(TestcaseRepo repository) {
	    return (args) -> {
	      // save a few customers
	      TestcaseE testcaseE = new TestcaseE("com.package.dummyclass.dummymethod");
	      
		repository.save(testcaseE);

	      // fetch all customers
	      for (TestcaseE customer : repository.findAll()) {
	        log.info(customer.toString());
	      }

	      // fetch an individual customer by ID
	      TestcaseE customer = repository.findById(1L);

	      // fetch customers by last name
	      repository.findByLastName("Bauer").forEach(bauer -> {
	        log.info(bauer.toString());
	      });
	    };
	  }
}
