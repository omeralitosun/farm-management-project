package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.business.abstracts.ReceivedProductService;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests.CreateReceivedProductRequest;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests.UpdateReceivedProductRequest;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.CreateReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetAllReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.UpdateReceivedProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/receivedProduct")
@CrossOrigin
public class ReceivedProductController {

    private final ReceivedProductService service;

    @GetMapping
    public List<GetAllReceivedProductResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetReceivedProductResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateReceivedProductResponse add(@RequestBody CreateReceivedProductRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UpdateReceivedProductResponse update(@PathVariable UUID id, @RequestBody UpdateReceivedProductRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
