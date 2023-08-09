package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.SelledProductService;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.requests.CreateSelledProductRequest;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.requests.UpdateSelledProductRequest;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.CreateSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.GetAllSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.GetSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.UpdateSelledProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/selledProduct")
@CrossOrigin
public class SelledProductController {

    private final SelledProductService service;

    @GetMapping
    public List<GetAllSelledProductResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetSelledProductResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateSelledProductResponse add(@RequestBody CreateSelledProductRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateSelledProductResponse update(@PathVariable UUID id, @RequestBody UpdateSelledProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
