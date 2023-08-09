package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.ActionTakenService;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.CreateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.UpdateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.CreateActionTakenResponse;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.GetActionTakenResponse;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.GetAllActionTakenResponse;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.UpdateActionTakenResponse;
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

    @GetMapping("/{id}")
    public GetActionTakenResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateActionTakenResponse add(@RequestBody CreateActionTakenRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateActionTakenResponse update(@PathVariable UUID id, @RequestBody UpdateActionTakenRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
