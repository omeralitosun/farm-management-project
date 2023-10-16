package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.MaintenanceService;
import com.omerali.farmmanagementproject.business.dtos.maintenance.requests.CreateMaintenanceRequest;
import com.omerali.farmmanagementproject.business.dtos.maintenance.requests.UpdateMaintenanceRequest;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.CreateMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetAllMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.UpdateMaintenanceResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/maintenance")
@CrossOrigin
public class MaintenanceController {

    private final MaintenanceService service;

    @GetMapping
    public List<GetAllMaintenanceResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetMaintenanceResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMaintenanceResponse add(@Valid @RequestBody CreateMaintenanceRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateMaintenanceResponse update(@PathVariable UUID id,@Valid @RequestBody UpdateMaintenanceRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
