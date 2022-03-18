package com.cgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.exception.DriverNotFoundException;
import com.cgi.exception.DuplicateDriverIdException;
import com.cgi.model.Driver;
import com.cgi.service.DriverService;

@RestController
public class DriverController {

	@Autowired
	private DriverService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addDriver(@RequestBody Driver d){
		try {
			Driver savedDriver = service.addNewDriver(d);
			return new ResponseEntity<>(savedDriver,HttpStatus.CREATED);
		} catch (DuplicateDriverIdException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listDrivers(){
		return new ResponseEntity<>(service.getAllDriverDetails(),HttpStatus.OK);
	}
	@DeleteMapping("/delete/{driverId}")
	public ResponseEntity<?> deleteDriver(@PathVariable("driverId") int id){
		try {
			String msg = service.deleteDriverById(id);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} catch (DriverNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}
