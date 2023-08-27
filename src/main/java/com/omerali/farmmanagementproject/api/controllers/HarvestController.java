package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.HarvestService;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.CreateHarvestRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.UpdateHarvestRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.responses.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/harvest")
@CrossOrigin
public class HarvestController {

    private final HarvestService service;

    @GetMapping
    public List<GetAllHarvestResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/byField")
    public List<GetAllHarvestByFieldResponse> getAll(@RequestParam(required = false) UUID fieldId) {
        return service.getAllByField(fieldId);
    }
    @GetMapping("/{id}")
    public GetHarvestResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateHarvestResponse add(@RequestBody CreateHarvestRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateHarvestResponse update(@PathVariable UUID id, @RequestBody UpdateHarvestRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
