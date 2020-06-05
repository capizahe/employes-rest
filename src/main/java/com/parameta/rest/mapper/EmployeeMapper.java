package com.parameta.rest.mapper;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.parameta.rest.exception.BussinessException;
import com.parameta.rest.model.EmployeeRequest;
import com.parameta.webservices.employe.AddEmployeeRequest;
import com.parameta.webservices.employe.Employee;

public class EmployeeMapper {

	public static AddEmployeeRequest mapToAddEmployeeRequest(EmployeeRequest employee) {
		AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest();
		Employee soapEmployee = new Employee();
		soapEmployee.setFirstName(employee.getFirstName());
		soapEmployee.setSecondName(employee.getSecondName());
		soapEmployee.setFirstSurname(employee.getFirstSurname());
		soapEmployee.setSecondSurname(employee.getSecondSurname());
		soapEmployee.setIdType(employee.getIdType());
		soapEmployee.setIdNumber(employee.getIdNumber());
		soapEmployee.setBirthDate(stringToXmlGregorianCalendar(employee.getBirthDate()));
		soapEmployee.setVinculationDate(stringToXmlGregorianCalendar(employee.getVinculationDate()));
		soapEmployee.setCompanyPosition(employee.getCompanyPosition());
		soapEmployee.setSalary(employee.getSalary());
		addEmployeeRequest.setEmployee(soapEmployee);
		return addEmployeeRequest;
	}
	
	private static XMLGregorianCalendar stringToXmlGregorianCalendar(String date) {
		try {
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
					.newXMLGregorianCalendar(date);
			return xmlGregorianCalendar;
		} catch (DatatypeConfigurationException e) {
			throw new BussinessException("Invalid date format. The format should be in the form YYYY-MM-DD");
		}
	}
}
