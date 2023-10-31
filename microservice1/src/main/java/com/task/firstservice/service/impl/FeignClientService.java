package com.task.firstservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.firstservice.feign.SecondServiceClient;
import com.task.firstservice.feign.ThirdServiceClient;
import com.task.firstservice.interfaces.FirstServiceInterface;
import com.task.firstservice.request.dto.NamesRequestDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class FeignClientService implements FirstServiceInterface {
	
	Logger logger=LoggerFactory.getLogger(FeignClientService.class);

	@Autowired
	private SecondServiceClient secondServiceClient;

	@Autowired
	private ThirdServiceClient thirdServiceClient;

	@Override
	//@CircuitBreaker(name="other-service",fallbackMethod="otherServicefallback")
	public String serviceResponse() {
		
		String response = null;
		logger.info("---Invoking the Second Service---");
		ResponseEntity<String> secondServiceresponse = secondServiceClient.getHello();
		logger.info("---Invoking the Third Service---");
		ResponseEntity<String> thirdServiceResponse = thirdServiceClient.addNames(prepareJson());

		if (secondServiceresponse != null && thirdServiceResponse != null) {
			response = secondServiceresponse.getBody().toString().concat(" ")
					.concat(thirdServiceResponse.getBody().toString());
		}

		return response;
	}
	
	public String otherServicefallback(Throwable t) {
		logger.info("Exception is",t.getMessage());
		return new String("Unable to access the other services.FallBack method triggered.Please try after some time");
	}


	private NamesRequestDTO prepareJson() {
		NamesRequestDTO names = new NamesRequestDTO();
		names.setName("John");
		names.setSurName("Doe");
		return names;
	}

}
