package com.cgi.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "insurance")
public class Insurance {

	@Id
	private String insuranceId;
	private String type;
	private List<Plan> plan;
	
	
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(String insuranceId, String type, List<Plan> plan) {
		super();
		this.insuranceId = insuranceId;
		this.type = type;
		this.plan = plan;
	}
	public String getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(String insuranceId) {
		this.insuranceId = insuranceId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Plan> getPlan() {
		return plan;
	}
	public void setPlan(List<Plan> plan) {
		this.plan = plan;
	}
	@Override
	public String toString() {
		return "Insurance [insuranceId=" + insuranceId + ", type=" + type + ", plan=" + plan + "]";
	}

	
	
}
