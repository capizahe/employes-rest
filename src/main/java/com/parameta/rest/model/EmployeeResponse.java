package com.parameta.rest.model;

public class EmployeeResponse {

	private String vinculationTime;
	private String employeeAge;
	
	public EmployeeResponse(String vinculationTime, String employeeAge) {
		super();
		this.vinculationTime = vinculationTime;
		this.employeeAge = employeeAge;
	}
	
	public EmployeeResponse() {
		super();
	}

	public String getVinculationTime() {
		return vinculationTime;
	}

	public void setVinculationTime(String vinculationTime) {
		this.vinculationTime = vinculationTime;
	}

	public String getEmployeeAge() {
		return employeeAge;
	}

	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
	
	
	
	
}
