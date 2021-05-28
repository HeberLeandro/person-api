package com.github.heberleandro.personapi.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.github.heberleandro.personapi.dto.request.PersonDTO;
import com.github.heberleandro.personapi.entity.Person;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
