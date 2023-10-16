package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.SeasonService;

import com.omerali.farmmanagementproject.business.dtos.season.requests.CreateSeasonRequest;
import com.omerali.farmmanagementproject.business.dtos.season.responses.CreateSeasonResponse;
import com.omerali.farmmanagementproject.business.dtos.season.responses.GetAllSeasonResponse;
import com.omerali.farmmanagementproject.business.dtos.season.responses.GetSeasonResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/season")
@CrossOrigin
public class SeasonController {

    private final SeasonService service;

    @GetMapping
    public List<GetAllSeasonResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSeasonResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSeasonResponse add(@Valid @RequestBody CreateSeasonRequest request){
        return service.create(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
