package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.EquipmentService;
import com.omerali.farmmanagementproject.business.dtos.equipment.requests.CreateEquipmentRequest;
import com.omerali.farmmanagementproject.business.dtos.equipment.requests.UpdateEquipmentRequest;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.CreateEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.GetAllEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.GetEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.UpdateEquipmentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/equipment")
@CrossOrigin
public class EquipmentController {

    private final EquipmentService service;

    @GetMapping
    public List<GetAllEquipmentResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetEquipmentResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEquipmentResponse add(@Valid @RequestBody CreateEquipmentRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateEquipmentResponse update(@PathVariable UUID id,@Valid  @RequestBody UpdateEquipmentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
