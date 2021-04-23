package com.project.personapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.exception.PersonNotFoundException;
import com.project.personapi.mapper.PersonMapper;
import com.project.personapi.model.Person;
import com.project.personapi.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public Person savePerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		Person savedPerson = personRepository.save(personToSave);
		return savedPerson;
	}

	public List<PersonDTO> listOfPerson() {
		List<PersonDTO> people = personRepository.findAll()
				.stream()
				.map(person -> personMapper.toDTO(person))
				.collect(Collectors.toList());
		return people;
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExistsId(id);
		
		return personMapper.toDTO(person);
	}

	public void deleteById(Long id) throws PersonNotFoundException {
		verifyIfExistsId(id);
		personRepository.deleteById(id);
	}

	private Person verifyIfExistsId(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
}
