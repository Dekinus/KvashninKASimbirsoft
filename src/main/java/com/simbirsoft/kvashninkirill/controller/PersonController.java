package com.simbirsoft.kvashninkirill.controller;

import com.simbirsoft.kvashninkirill.dto.request.RequestPersonDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponsePersonDto;
import com.simbirsoft.kvashninkirill.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name = "Сотрудник")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Operation(summary = "Записать в базу данных сотрудника")
    @PostMapping
    public ResponseEntity<ResponsePersonDto> createPerson(@RequestBody RequestPersonDto requestPersonDto) {
        return ResponseEntity.ok(personService.createPerson(requestPersonDto));
    }

    @Operation(summary = "Обновить сотрудника")
    @PutMapping("/{id}")
    public ResponseEntity<ResponsePersonDto> editPerson(@PathVariable Long id, @RequestBody RequestPersonDto requestPersonDto) {
        return ResponseEntity.ok(personService.editPerson(id, requestPersonDto));
    }

    @Operation(summary = "Найти сотрудника по id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponsePersonDto> getPerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @Operation(summary = "Найти всех сотрудников")
    @GetMapping("/all")
    public ResponseEntity<List<ResponsePersonDto>> getAllPerson() {
        return ResponseEntity.ok(personService.getAll());
    }

    @Operation(summary = "Удалить сотрудника")
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "Person deleted";
    }
}
