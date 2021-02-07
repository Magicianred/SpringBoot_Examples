package com.example.demo.controller;

// import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	private static final String template = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return String.format(template, name);
	}
}
