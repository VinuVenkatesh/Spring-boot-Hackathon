package com.cgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.exception.InsuranceAlreadyExistException;
import com.cgi.exception.PlanIdNotFoundException;
import com.cgi.model.Insurance;
import com.cgi.service.InsuranceService;

@RestController
public class InsuranceController {

	@Autowired
	private InsuranceService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addInsurance(@RequestBody Insurance i){
		try {
			Insurance saved = service.addNewInsurance(i);
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		} catch (InsuranceAlreadyExistException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<>(service.listAllInsurances(),HttpStatus.OK);
	}
	
	@GetMapping("/get/{insuranceId}/{planId}")
	public ResponseEntity<?> findByInsuranceIdPlanId(@PathVariable ("insuranceId") String insuranceId, @PathVariable("planId") String planId){
		try {
			Insurance saved = service.detailsByInsuranceIdAndPlanId(insuranceId, planId);
			return new ResponseEntity<>(saved, HttpStatus.CREATED);
		} catch (PlanIdNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
