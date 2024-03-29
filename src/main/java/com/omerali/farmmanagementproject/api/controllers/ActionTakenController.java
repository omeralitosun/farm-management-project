package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.ActionTakenService;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.CreateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.UpdateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/actionTaken")
@CrossOrigin
public class ActionTakenController {

    private final ActionTakenService service;

    @GetMapping
    public List<GetAllActionTakenResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/byField")
    public List<GetAllActionTakenByFieldResponse> getAll(@RequestParam(required = false) UUID fieldId) {
        return service.getAllByField(fieldId);
    }
    @GetMapping("/byFieldandSeason")
    public List<GetAllActionTakenByFieldAndSeasonResponse> getAll(@RequestParam(required = false) UUID fieldId,@RequestParam(required = false) UUID seasonId) {
        return service.getAllByFieldAndSeason(fieldId,seasonId);
    }

    @GetMapping("/{id}")
    public GetActionTakenResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateActionTakenResponse add(@Valid @RequestBody CreateActionTakenRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateActionTakenResponse update(@PathVariable UUID id,@Valid  @RequestBody UpdateActionTakenRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
