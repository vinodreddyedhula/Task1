package com.task.secondservice.rest.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/second-service")
public class SecondServiceRestEndpoint {

	Logger logger=LoggerFactory.getLogger(SecondServiceRestEndpoint.class);
	
	@ApiOperation(value = "Get Hello String response")
	@GetMapping("/response")
	public ResponseEntity<String> getHello() {
		logger.info("---Returning Hello---");
		return ResponseEntity.ok("Hello");
	}

}
