package com.project.personapi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.model.Person;
import com.project.personapi.repository.PersonRepository;
import com.project.personapi.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepository;
	
	@InjectMocks
	private PersonService personService;

	@Test
	void testGivenPersonDTOThenReturnSavedEntity() {
		PersonDTO personDTO = PersonUtils.createFakeDTO();
		Person expectedSavedPerson = PersonUtils.createFakeEntity();
		
		Mockito.when(personRepository.save(Mockito.any(Person.class))).thenReturn(expectedSavedPerson);
		
		PersonDTO dto = personService.savePerson(personDTO);
		
		Assertions.assertEquals(PersonUtils.convertToDTO(expectedSavedPerson), dto);
	}
}
