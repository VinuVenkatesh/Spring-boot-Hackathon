package com.cgi.service;

import java.util.List;

import com.cgi.exception.InsuranceAlreadyExistException;
import com.cgi.exception.PlanIdNotFoundException;
import com.cgi.model.Insurance;

public interface InsuranceService {

	Insurance addNewInsurance(Insurance i) throws InsuranceAlreadyExistException;
	List<Insurance> listAllInsurances();
	Insurance detailsByInsuranceIdAndPlanId(String insuranceId, String planId) throws PlanIdNotFoundException;
}
