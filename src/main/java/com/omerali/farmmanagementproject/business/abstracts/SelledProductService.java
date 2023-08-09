package com.omerali.farmmanagementproject.business.abstracts;


import com.omerali.farmmanagementproject.business.dtos.selledProduct.requests.CreateSelledProductRequest;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.requests.UpdateSelledProductRequest;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.CreateSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.GetAllSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.GetSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.UpdateSelledProductResponse;

import java.util.List;
import java.util.UUID;

public interface SelledProductService {
    CreateSelledProductResponse create(CreateSelledProductRequest request);

    UpdateSelledProductResponse update(UUID id, UpdateSelledProductRequest request);

    GetSelledProductResponse getById(UUID id);

    List<GetAllSelledProductResponse> getAll();

    void delete(UUID id);
}
