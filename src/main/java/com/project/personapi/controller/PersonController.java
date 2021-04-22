package com.project.personapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
	
	@GetMapping
	public ResponseEntity<Void> list(){
		return ResponseEntity.noContent().build();
	}
}
