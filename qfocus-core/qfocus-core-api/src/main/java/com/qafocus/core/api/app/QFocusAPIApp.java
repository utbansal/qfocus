package com.qafocus.core.api.app;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories
public class QFocusAPIApp {
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		try {
			SpringApplication.run(QFocusAPIApp.class, args);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@PostConstruct
	public void init() {
		log.info(Arrays.asList(environment.getDefaultProfiles()).toString());
		System.out.println(Arrays.asList(environment.getDefaultProfiles()).toString());
	}


}
