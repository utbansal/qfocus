package com.qafocus.core.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qafocus.core.entity.TestcaseE;
import com.qafocus.core.repo.TestcaseRepo;
import com.qafocus.data.Testcase;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/testcase", produces = "application/json")
@Api(value = "testcase")
public class TestcaseApi {

	@Autowired
	private TestcaseRepo testcaseRepo;

	@ApiOperation(value = "request")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "internal server error") })
	@PostMapping(value = "/")
	public Testcase createTest(
			@ApiParam(name = "body", value = "", required = true) @Valid @RequestBody Testcase identifier)
			throws Exception {
		System.out.println("got a request");
		List<TestcaseE> findByName = testcaseRepo.findByName("name");
		return null;
	}

	@GetMapping(value = "/all")
	public Testcase getAll(String identifier) throws Exception {
		System.out.println("got a request");
		return null;
	}
}
