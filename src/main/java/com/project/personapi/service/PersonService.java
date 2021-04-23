package com.project.personapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.personapi.model.Person;
import com.project.personapi.repository.PersonRepository;

@Service
public class PersonService {

private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> listOfPerson(){
		return personRepository.findAll();
	}
}
