package com.prac.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String helloWorld(
			@RequestHeader("Authorization") String token,
			@RequestParam(value="name", defaultValue="World") String name) {
		return "Hello "+name+"!!";
	}
}
