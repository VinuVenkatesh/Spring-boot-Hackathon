package com.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cgi.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
