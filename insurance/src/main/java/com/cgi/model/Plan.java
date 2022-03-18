package com.cgi.model;

public class Plan {

	private String planId;
	private String planName;
	private int period;
	private int amount;
	
	
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(String planId, String planName, int period, int amount) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.period = period;
		this.amount = amount;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Plan [planId=" + planId + ", planName=" + planName + ", period=" + period + ", amount=" + amount + "]";
	}
	
	
}
