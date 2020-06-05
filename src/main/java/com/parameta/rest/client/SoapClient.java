package com.parameta.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.parameta.rest.validations.EmployeeValidation;
import com.parameta.webservices.employe.AddEmployeeRequest;
import com.parameta.webservices.employe.AddEmployeeResponse;

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller jaxb2Marshaller;
	
	private WebServiceTemplate webServiceTemplate;
	
	public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
		EmployeeValidation.validate(request);
		webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
		AddEmployeeResponse addEmployeeResponse =(AddEmployeeResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/webservice",request);
		return addEmployeeResponse;
	}
}
