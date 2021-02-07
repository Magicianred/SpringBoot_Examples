package com.example.demo.controller;

// import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Home controller")
public class HomeController {
	
	private static final String template = "Hello, %s!";

	@ApiOperation(value="Give Personal Hello to the user")
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return String.format(template, name);
	}
}
