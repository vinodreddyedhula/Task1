package com.task.thirdservice.request.dto;

public class ErrorResponse extends BaseRestApiResponse{
	
	private static final long serialVersionUID = 3840642803049235232L;
	
	private ErrorDetails error;
	
	public ErrorResponse() {
		super("Operation Failed",false);
	}

	public ErrorResponse(ErrorDetails error) {
		super("Operation Failed",false);
		this.error=error;
	}
}
