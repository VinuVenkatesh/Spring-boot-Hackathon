package com.cgi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.exception.DriverNotFoundException;
import com.cgi.exception.DuplicateDriverIdException;
import com.cgi.model.Driver;
import com.cgi.repository.DriverRepository;
@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository repository;
	
	@Override
	public Driver addNewDriver(Driver d) throws DuplicateDriverIdException {
		Optional<Driver> check = repository.findById(d.getDriverId());
		if(check.isEmpty()) {
			return repository.save(d);
		}
		throw new DuplicateDriverIdException("Duplicate ID");
	}

	@Override
	public List<Driver> getAllDriverDetails() {
		return repository.findAll();
	}

	@Override
	public String deleteDriverById(int id) throws DriverNotFoundException {
		// TODO Auto-generated method stub
		Optional<Driver> check =  repository.findById(id);
		if(check.isEmpty()) {
			throw new DriverNotFoundException("No driver with that id exists");
		}
		repository.deleteById(id);
		return "Driver with id " + id + " has been deleted";
	}

}
