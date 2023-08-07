package com.omerali.farmmanagementproject.business.abstracts;

import com.omerali.farmmanagementproject.business.dtos.field.requests.CreateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.requests.UpdateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.responses.CreateFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetAllFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.UpdateFieldResponse;

import java.util.List;
import java.util.UUID;

public interface FieldService {
    CreateFieldResponse create(CreateFieldRequest request);
    UpdateFieldResponse update(UUID id, UpdateFieldRequest request);
    GetFieldResponse getById(UUID id);
    List<GetAllFieldResponse> getAll();
    void delete(UUID id);
}
