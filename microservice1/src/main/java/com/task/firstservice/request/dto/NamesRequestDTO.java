package com.task.firstservice.request.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NamesRequestDTO {
	
	@Schema(description = "Name of the person")
	@NotBlank(message = "The Name is required.")
	@Size(min = 1, max = 15, message = "Name should be between 1 and 15")
	private String name;

	@NotBlank(message = "The Surname is required.")
	@Schema(description = "SurName of the person")
	private String surName;
	
	
	

}
