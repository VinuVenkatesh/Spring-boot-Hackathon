package com.cgi.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.exception.InsuranceAlreadyExistException;
import com.cgi.exception.PlanIdNotFoundException;
import com.cgi.model.Insurance;
import com.cgi.model.Plan;
import com.cgi.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	InsuranceRepository repository;

	@Override
	public Insurance addNewInsurance(Insurance i) throws InsuranceAlreadyExistException { //If insurance already exists will add plan under same insurance if it is a new plan
		Optional<Insurance> check = repository.findById(i.getInsuranceId());
		if(check.isEmpty()) {
			return repository.save(i);
		}
		else {
			Insurance obj = check.get();
			List<Plan> newPlans = i.getPlan();
			List<Plan> savedPlans = obj.getPlan();
			int size = savedPlans.size();
			boolean equal = false;
			for (Plan plan : newPlans) {
				for(int j = 0; j < savedPlans.size(); j++) {
					if((plan.getPlanId().equals(savedPlans.get(j).getPlanId()))) {
						equal = true;
					}
				}
				if(!equal) {
					savedPlans.add(plan);
					equal = false;
				}
			}
			if(size < savedPlans.size()) {
				obj.setPlan(savedPlans);
				return repository.save(obj);
			}
			else {
				throw new InsuranceAlreadyExistException("Insurance with same plans already exist");
			}
		}
	}

	@Override
	public List<Insurance> listAllInsurances() {
		return repository.findAll();
	}

	@Override
	public Insurance detailsByInsuranceIdAndPlanId(String insuranceId, String planId) throws PlanIdNotFoundException {
		Optional<Insurance> check = repository.findByUserIdAndPlanPlanId(insuranceId, planId);
		if(check.isEmpty()) {
			throw new PlanIdNotFoundException("No such insurance with that plan id");
		}
		List<Plan> only = new ArrayList<>();
		for (Plan p : check.get().getPlan()) {
			if(p.getPlanId().equals(planId))
				only.add(p);
		}
		check.get().setPlan(only);
		return check.get();
	}

	
}
