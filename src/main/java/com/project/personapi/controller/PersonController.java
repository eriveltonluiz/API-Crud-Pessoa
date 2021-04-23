package com.project.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.personapi.dto.request.PersonDTO;
import com.project.personapi.exception.PersonNotFoundException;
import com.project.personapi.model.Person;
import com.project.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping
	public ResponseEntity<List<PersonDTO>> listAll(){
		return ResponseEntity.ok(personService.listOfPerson());
	}

	@PostMapping
	public ResponseEntity<Person> createPerson(@RequestBody @Valid PersonDTO personDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(personDTO));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> findById(@PathVariable Long id) throws PersonNotFoundException{
		return ResponseEntity.ok(personService.findById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) throws PersonNotFoundException{
		personService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
