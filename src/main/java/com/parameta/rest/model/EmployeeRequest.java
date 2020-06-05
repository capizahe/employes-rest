package com.parameta.rest.model;

public class EmployeeRequest {

	    private String firstName;
	    private String secondName;
	    private String firstSurname;
	    private String secondSurname;
	    private String idType;
	    private String idNumber;
	    private String vinculationDate;
	    private String birthDate;
	    private String companyPosition;
	    private double salary;
	    
		public EmployeeRequest(String firstName, String secondName, String firstSurname, String secondSurname,
				String idType, String idNumber, String vinculationDate, String birthDate, String companyPosition,
				double salary) {
			super();
			this.firstName = firstName;
			this.secondName = secondName;
			this.firstSurname = firstSurname;
			this.secondSurname = secondSurname;
			this.idType = idType;
			this.idNumber = idNumber;
			this.vinculationDate = vinculationDate;
			this.birthDate = birthDate;
			this.companyPosition = companyPosition;
			this.salary = salary;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getSecondName() {
			return secondName;
		}

		public void setSecondName(String secondName) {
			this.secondName = secondName;
		}

		public String getFirstSurname() {
			return firstSurname;
		}

		public void setFirstSurname(String firstSurname) {
			this.firstSurname = firstSurname;
		}

		public String getSecondSurname() {
			return secondSurname;
		}

		public void setSecondSurname(String secondSurname) {
			this.secondSurname = secondSurname;
		}

		public String getIdType() {
			return idType;
		}

		public void setIdType(String idType) {
			this.idType = idType;
		}

		public String getIdNumber() {
			return idNumber;
		}

		public void setIdNumber(String idNumber) {
			this.idNumber = idNumber;
		}

		public String getVinculationDate() {
			return vinculationDate;
		}

		public void setVinculationDate(String vinculationDate) {
			this.vinculationDate = vinculationDate;
		}

		public String getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}

		public String getCompanyPosition() {
			return companyPosition;
		}

		public void setCompanyPosition(String companyPosition) {
			this.companyPosition = companyPosition;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}
	    
			
	    
	
}
