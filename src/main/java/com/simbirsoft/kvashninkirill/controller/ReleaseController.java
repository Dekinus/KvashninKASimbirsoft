package com.simbirsoft.kvashninkirill.controller;

import com.simbirsoft.kvashninkirill.dto.request.RequestReleaseDto;
import com.simbirsoft.kvashninkirill.dto.response.ResponseReleaseDto;
import com.simbirsoft.kvashninkirill.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/release")
@Tag(name = "Релиз")
public class ReleaseController {

    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }


    @Operation(summary = "Записать в базу данных релиз")
    @PostMapping
    public ResponseEntity<ResponseReleaseDto> createRelease(@RequestBody RequestReleaseDto requestReleaseDto) {
        return ResponseEntity.ok(releaseService.createRelease(requestReleaseDto));
    }

    @Operation(summary = "Обновить данные релиза")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseReleaseDto> editRelease(@PathVariable Long id, @RequestBody RequestReleaseDto requestReleaseDto) {
        return ResponseEntity.ok(releaseService.editRelease(id, requestReleaseDto));
    }

    @Operation(summary = "Найти релиз по id")
    @GetMapping("/{id}")
    public ResponseEntity<ResponseReleaseDto> getRelease(@PathVariable Long id) {
        return ResponseEntity.ok(releaseService.getRelease(id));
    }

    @Operation(summary = "Найти все релизы")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseReleaseDto>> getAllRelease() {
        return ResponseEntity.ok(releaseService.getAll());
    }

    @Operation(summary = "Удалить релиз")
    @DeleteMapping("/{id}")
    public String deleteRelease(@PathVariable Long id) {
        releaseService.deleteRelease(id);
        return "Release deleted";
    }
}
