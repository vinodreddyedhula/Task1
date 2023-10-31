package com.task.firstservice.feign;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		log.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status()
				+ ", methodKey = " + methodKey);

		switch (response.status()) {

		case 400:

			return new ResponseStatusException(HttpStatus.valueOf(response.status()), "Its a Bad request");
		case 404:

			return new ResponseStatusException(HttpStatus.valueOf(response.status()), "UnAuthorised");
		case 500:

			return new ResponseStatusException(HttpStatus.valueOf(response.status()),
					"Internal Server Error while accessing other service!!!");		
		case 503:

			return new ResponseStatusException(HttpStatus.valueOf(response.status()), methodKey+"  Service Unavailable !!!");

		default:
			return new Exception(response.reason());
		}
	}

}
