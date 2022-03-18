package com.cgi.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgi.model.Insurance;

@Repository
public interface InsuranceRepository extends MongoRepository<Insurance, String> {

	@Query(value = "{'insuranceId' : ?0, 'plan.planId': ?1}")
	Optional<Insurance> findByUserIdAndPlanPlanId(String insuranceId, String planId);
	
}
