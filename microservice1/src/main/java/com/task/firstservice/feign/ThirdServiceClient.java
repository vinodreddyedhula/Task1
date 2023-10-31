package com.task.firstservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task.firstservice.request.dto.NamesRequestDTO;

//@FeignClient(name="ThirdService", url = "http://ec2-51-20-134-249.eu-north-1.compute.amazonaws.com:8080/")
@FeignClient(name="third-service")
public interface ThirdServiceClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/api/v1/third-service/response", consumes = "application/json")
	public ResponseEntity<String> addNames(@RequestBody NamesRequestDTO name);

	
}
