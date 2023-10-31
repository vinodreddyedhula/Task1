package com.task.firstservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name="SecondService", url = "http://ec2-51-20-134-28.eu-north-1.compute.amazonaws.com:8080/")
@FeignClient(name= "second-service")
public interface SecondServiceClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/v1/second-service/response")
	    public ResponseEntity<String> getHello();
	

}
