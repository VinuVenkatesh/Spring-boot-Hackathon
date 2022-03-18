package com.cgi.service;

import java.util.List;

import com.cgi.exception.DriverNotFoundException;
import com.cgi.exception.DuplicateDriverIdException;
import com.cgi.model.Driver;

public interface DriverService {

	Driver addNewDriver(Driver d) throws DuplicateDriverIdException ;
	List<Driver> getAllDriverDetails();
	String deleteDriverById(int id) throws DriverNotFoundException;
}
