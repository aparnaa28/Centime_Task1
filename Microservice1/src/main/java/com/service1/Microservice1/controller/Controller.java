package com.service1.Microservice1.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.service1.Microservice1.entity.Person;
import com.service1.Microservice1.entity.ResponseMessage;


import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/service1")
public class Controller {

	private static final Logger LOG = Logger.getLogger(Controller.class.getName());
	
	@GetMapping("getServiceStatus")
	public ResponseEntity<String> getServiceStatus()
	{
		 LOG.log(Level.INFO, "Checking the service status");
		return new ResponseEntity<String>("Up", HttpStatus.OK);
	}
	
	@PostMapping(path = "response", 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseMessage> getConcatenatedString(@RequestBody Person person)
	{
		LOG.log(Level.INFO, "Invoking Microservices 2 and 3.");
		RestTemplate restTemplate = new RestTemplate();
		String service2Url= "http://localhost:8081/service2/getMsg";
		String service3Url= "http://localhost:8082/service3/person"; 
		
		ResponseEntity<String> response1= restTemplate.getForEntity(service2Url, String.class);
		ResponseEntity<String> response2= restTemplate.postForEntity(service3Url, person , String.class,"");
		
		String response=response1.getBody()+ " " + response2.getBody();
		
		
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(response), HttpStatus.CREATED);
	}
	
	
}
