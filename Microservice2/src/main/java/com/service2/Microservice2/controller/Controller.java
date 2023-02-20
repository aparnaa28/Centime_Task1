package com.service2.Microservice2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service2")
public class Controller {

	@GetMapping("getMsg")
	public ResponseEntity<String> getMessage()
	{
		return new ResponseEntity<String>("Hello", HttpStatus.OK);
	}

   

}
