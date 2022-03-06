package com.simbirsoft.kvashninkirill.service.mapper;

import com.simbirsoft.kvashninkirill.dto.request.RequestPersonDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponsePersonDto;
import com.simbirsoft.kvashninkirill.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person toPerson(RequestPersonDto requestPersonDto) {
        Person person = new Person();
        person.setName(requestPersonDto.getName());
        return person;
    }

    public ResponsePersonDto toPersonDto(Person person) {
        ResponsePersonDto responsePersonDto = new ResponsePersonDto();
        responsePersonDto.setId(person.getId());
        responsePersonDto.setName(person.getName());
        return responsePersonDto;
    }
}
