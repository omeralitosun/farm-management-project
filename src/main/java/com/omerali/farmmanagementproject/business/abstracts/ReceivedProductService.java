package com.omerali.farmmanagementproject.business.abstracts;



import com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests.CreateReceivedProductRequest;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests.UpdateReceivedProductRequest;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.CreateReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetAllReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.UpdateReceivedProductResponse;

import java.util.List;
import java.util.UUID;

public interface ReceivedProductService {
    CreateReceivedProductResponse create(CreateReceivedProductRequest request);

    UpdateReceivedProductResponse update(UUID id, UpdateReceivedProductRequest request);

    GetReceivedProductResponse getById(UUID id);

    List<GetAllReceivedProductResponse> getAll();

    void delete(UUID id);
}
