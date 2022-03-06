package com.simbirsoft.kvashninkirill.service.impl;

import com.simbirsoft.kvashninkirill.dto.request.RequestPersonDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponsePersonDto;
import com.simbirsoft.kvashninkirill.entity.Person;
import com.simbirsoft.kvashninkirill.exception.PersonNotFoundException;
import com.simbirsoft.kvashninkirill.repository.PersonRepository;
import com.simbirsoft.kvashninkirill.service.PersonService;
import com.simbirsoft.kvashninkirill.service.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public ResponsePersonDto createPerson(RequestPersonDto requestPersonDto) {
        Person person = personMapper.toPerson(requestPersonDto);
        personRepository.save(person);
        return personMapper.toPersonDto(person);
    }

    @Override
    public ResponsePersonDto editPerson(Long id, RequestPersonDto requestPersonDto) {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        Person person = personMapper.toPerson(requestPersonDto);
        person.setId(id);
        personRepository.save(person);
        return personMapper.toPersonDto(person);
    }

    @Override
    public ResponsePersonDto getPerson(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toPersonDto(person);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personRepository.deleteById(id);
    }

    @Override
    public List<ResponsePersonDto> getAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toPersonDto)
                .collect(Collectors.toList());
    }
}
