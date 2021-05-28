package com.github.heberleandro.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.heberleandro.personapi.dto.response.MessageResponseDTO;
import com.github.heberleandro.personapi.entity.Person;
import com.github.heberleandro.personapi.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public MessageResponseDTO createPerson(Person person) {
		Person savedPerson = personRepository.save(person);
		return MessageResponseDTO.builder()
				.Message("Created person with ID "+ savedPerson.getId())
				.build();
	}
	
}
