package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.FieldService;
import com.omerali.farmmanagementproject.business.dtos.field.requests.CreateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.requests.UpdateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.responses.CreateFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetAllFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.UpdateFieldResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/field")
@CrossOrigin
public class FieldController {

    private final FieldService service;

    @GetMapping
    public List<GetAllFieldResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFieldResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateFieldResponse add(@RequestBody CreateFieldRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateFieldResponse update(@PathVariable UUID id, @RequestBody UpdateFieldRequest Field){
        return service.update(id,Field);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
