package com.task.thirdservice.rest.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.thirdservice.request.dto.ErrorResponse;
import com.task.thirdservice.request.dto.NameRequestDTO;
import com.task.thirdservice.request.dto.SuccessResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/api/v1/third-service")
public class ThirdServiceRestEndpoint {

	Logger logger = LoggerFactory.getLogger(ThirdServiceRestEndpoint.class);

	@ApiOperation(value = "Concatinate Response")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully Created", response = String.class),
			@ApiResponse(code = 400, message = "Invalid Request", response = ErrorResponse.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, message = "Internal validation error", response = ErrorResponse.class) })
	@PostMapping("/response")
	public ResponseEntity<String> serviceResponse(@Valid @RequestBody NameRequestDTO names) {

		logger.info("Name and SurName dtls are {} {}", names.getName(), names.getSurName());
		String response = names.getName().concat(" ").concat(names.getSurName());
		return ResponseEntity.ok(response);
	}
}
