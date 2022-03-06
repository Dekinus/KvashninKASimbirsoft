package com.simbirsoft.kvashninkirill.service;

import com.simbirsoft.kvashninkirill.dto.request.RequestPersonDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponsePersonDto;

import java.util.List;

public interface PersonService {
    ResponsePersonDto createPerson(RequestPersonDto requestPersonDto);

    ResponsePersonDto editPerson(Long id, RequestPersonDto requestPersonDto);

    ResponsePersonDto getPerson(Long id);

    void deletePerson(Long id);

    List<ResponsePersonDto> getAll();
}
