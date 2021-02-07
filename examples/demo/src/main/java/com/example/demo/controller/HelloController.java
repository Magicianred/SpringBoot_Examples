package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Api(value="Primary controller")
public class HelloController {

	@ApiOperation(value="Give Hello to the user")
	@RequestMapping("/")
	public String index() {
		return "Hello from Spring Boot!";
	}
	
}
