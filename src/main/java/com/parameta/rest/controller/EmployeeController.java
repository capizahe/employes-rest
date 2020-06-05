package com.parameta.rest.controller;

import java.time.LocalDate;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.parameta.rest.client.SoapClient;
import com.parameta.rest.mapper.EmployeeMapper;
import com.parameta.rest.model.EmployeeRequest;
import com.parameta.rest.model.EmployeeResponse;
import com.parameta.webservices.employe.AddEmployeeRequest;
import com.parameta.webservices.employe.AddEmployeeResponse;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private SoapClient soapClient;

	/**
	 * This method adds and employee to the database
	 * @param request
	 * @return
	 */
	@PostMapping("addEmployee")
	public @ResponseBody EmployeeResponse addEmployee(@RequestBody EmployeeRequest request){
		AddEmployeeRequest addRequest = EmployeeMapper.mapToAddEmployeeRequest(request);
		AddEmployeeResponse  response =  this.soapClient.addEmployee(addRequest);	
		EmployeeResponse employeeResponse = new EmployeeResponse();

		if(response.isStatus()) {
			employeeResponse.setVinculationTime(convertDateToString(addRequest.getEmployee().getVinculationDate()));
			employeeResponse.setEmployeeAge(convertDateToString(addRequest.getEmployee().getBirthDate()));
		}
		return employeeResponse;
	}

	/**
	 * This method recieves the date and returns the number of years, months and days that have happened since now.
	 * @param date
	 * @return
	 */
	private String convertDateToString(XMLGregorianCalendar date) {
		
		LocalDate actualdate = LocalDate.now();
		LocalDate givendate = date.toGregorianCalendar().toZonedDateTime().toLocalDate();
		int years = actualdate.getYear() - givendate.getYear();
		int months = actualdate.getMonthValue() - givendate.getMonthValue();
		
		if(months < 0 ) {
			years-=1;
			months = 12 + months;
		}
		
		int days =  Math.abs(givendate.getDayOfMonth() - actualdate.getDayOfMonth() - 1);

		StringBuilder stringBuilder = new StringBuilder()
				.append(years).append(" years ")
				.append(months).append(" months ")
				.append(days).append(" days ");
		return stringBuilder.toString();
	}
}
