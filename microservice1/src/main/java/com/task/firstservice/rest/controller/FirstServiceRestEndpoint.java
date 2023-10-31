package com.task.firstservice.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.firstservice.request.dto.ErrorResponse;
import com.task.firstservice.request.dto.SuccessResponse;
import com.task.firstservice.service.impl.FeignClientService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/first-service")
public class FirstServiceRestEndpoint {
	
	Logger logger=LoggerFactory.getLogger(FirstServiceRestEndpoint.class);

	@Autowired
	private FeignClientService service;

	@ApiOperation(value = "Get Service UP Status")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Created", response = SuccessResponse.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal validation error", response = ErrorResponse.class) })
	@GetMapping( "/status")
	public ResponseEntity<SuccessResponse<String>> serviceStatus() {
		logger.info("---Service is UP---");
		return ResponseEntity.ok(new SuccessResponse("UP"));
	}

	@ApiOperation(value = "Concatinate Response")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Created", response = SuccessResponse.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal validation error", response = ErrorResponse.class) })
	@PostMapping("/response")
	public ResponseEntity<SuccessResponse<String>> serviceResponse() {
		logger.info("---TRiggering the post call---");
		return ResponseEntity.ok(new SuccessResponse(service.serviceResponse()));
	}
}
