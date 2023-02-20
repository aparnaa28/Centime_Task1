package com.service3.Microservice3.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service3.Microservice3.entity.Person;



@RestController
@RequestMapping("/service3")
public class Controller {
	

	private static final Logger LOG = Logger.getLogger(Controller.class.getName());
	
	@PostMapping(path = "person", 
            consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody Person person) throws Exception {
		
		LOG.log(Level.INFO, "invoked /service3/person with data: " + person);
        if (person == null) {
            throw new Exception();
        } else {
        	
        	String concatedName= person.toString();
        	System.out.println(concatedName);
            return new ResponseEntity<String>(concatedName, HttpStatus.CREATED);
        }
    }


}
