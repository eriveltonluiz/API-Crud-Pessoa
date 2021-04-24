package com.project.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.model.Person;

public class PersonUtils {

	 private static final String FIRST_NAME = "Erivelton";
	    private static final String LAST_NAME = "Luiz";
	    private static final String CPF_NUMBER = "139.081.593-90";
	    private static final long PERSON_ID = 1L;
	    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

	    public static PersonDTO createFakeDTO() {
	        return PersonDTO.builder()
	                .firstName(FIRST_NAME)
	                .lastName(LAST_NAME)
	                .cpf(CPF_NUMBER)
	                .birthDate("04-04-2010")
	                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
	                .build();
	    }
	    
	    public static PersonDTO convertToDTO(Person person) {
	    	return PersonDTO.builder()
	    			.id(PERSON_ID)
	                .firstName(person.getFirstName())
	                .lastName(person.getLastName())
	                .cpf(person.getCpf())
	                .birthDate("04-04-2010")
	                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
	                .build();
	    }

	    public static Person createFakeEntity() {
	        return Person.builder()
	                .id(PERSON_ID)
	                .firstName(FIRST_NAME)
	                .lastName(LAST_NAME)
	                .cpf(CPF_NUMBER)
	                .birthDate(BIRTH_DATE)
	                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
	                .build();
	    }
	
}
