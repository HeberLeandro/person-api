package com.github.heberleandro.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.heberleandro.personapi.dto.mapper.PersonMapper;
import com.github.heberleandro.personapi.dto.request.PersonDTO;
import com.github.heberleandro.personapi.dto.response.MessageResponseDTO;
import com.github.heberleandro.personapi.entity.Person;
import com.github.heberleandro.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		
		Person savedPerson = personRepository.save(personToSave);
		return MessageResponseDTO.builder()
				.Message("Created person with ID "+ savedPerson.getId())
				.build();
	}
	
}
