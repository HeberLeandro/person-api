package com.github.heberleandro.personapi.controller;

import javax.validation.Valid;

import com.github.heberleandro.personapi.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.github.heberleandro.personapi.dto.request.PersonDTO;
import com.github.heberleandro.personapi.dto.response.MessageResponseDTO;
import com.github.heberleandro.personapi.entity.Person;
import com.github.heberleandro.personapi.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/app/v1/people")
public class PersonController {
	
	private PersonService personService;
	
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}

	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findByID(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
}
