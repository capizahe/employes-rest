package com.parameta.rest.validations;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.parameta.rest.exception.BussinessException;
import com.parameta.rest.exception.WrongParametersExeption;
import com.parameta.webservices.employe.AddEmployeeRequest;
import com.parameta.webservices.employe.Employee;

public class EmployeeValidation {


	/**
	 * This method validates if the attributes are empty. If they are it throws an error.
	 * @param request
	 */
	@ExceptionHandler
	public static void validate(AddEmployeeRequest request) {

		Employee employee = request.getEmployee();

		if(employee == null) 
			throw new WrongParametersExeption("The object can't be empty.");
		if(employee.getFirstName() == null | employee.getFirstName().isEmpty())
			throw new WrongParametersExeption("The first name can't be null");
		if(employee.getFirstSurname() == null || employee.getFirstSurname().isEmpty())
			throw new WrongParametersExeption("The first surname name can't be null");
		if(employee.getSecondSurname() == null || employee.getSecondSurname().isEmpty())
			throw new WrongParametersExeption("The second surname name can't be null");
		if(employee.getIdType() == null || employee.getIdType().isEmpty())
			throw new WrongParametersExeption("The id type name can't be null");
		if(employee.getIdNumber() == null || employee.getIdNumber().isEmpty())
			throw new WrongParametersExeption("The id number name can't be null");
		if(employee.getCompanyPosition() == null || employee.getCompanyPosition().isEmpty())
			throw new WrongParametersExeption("The company position name can't be null");
		if(employee.getBirthDate() == null)
			throw new WrongParametersExeption("The birthday can't be null");
		if(employee.getVinculationDate() == null)
			throw new WrongParametersExeption("The vinculation date can't be null");
		if(employee.getSalary() == 0)
			throw new WrongParametersExeption("The salary can't be 0");

		validateBirthDayDate(employee.getBirthDate());
		validateDateFormat(employee.getBirthDate());
		validateDateFormat(employee.getVinculationDate());

	}

	private static void validateDateFormat(XMLGregorianCalendar xmlGregorianCalendar) {
		xmlGregorianCalendar.setDay(xmlGregorianCalendar.getDay() +1);
		String FORMATER = "yyyy-MM-dd";
		DateFormat format = new SimpleDateFormat(FORMATER);
		try{
			format.format(xmlGregorianCalendar.toGregorianCalendar().getTime());
		}catch(Exception e) {
			throw new BussinessException("Invalid date format. The format should be in the form YYYY-MM-DD");
		}

	}

	private static void validateBirthDayDate(XMLGregorianCalendar date) {
		int min_age = 18;
		Calendar currentDate = Calendar.getInstance(TimeZone.getDefault());
		if(currentDate.get(Calendar.YEAR) - date.getYear() < min_age) {
			throw new BussinessException("You have to be at least 18 to execute this transaction.");
		}
	}

}
