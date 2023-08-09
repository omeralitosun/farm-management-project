package com.omerali.farmmanagementproject.business.abstracts;


import com.omerali.farmmanagementproject.business.dtos.equipment.requests.CreateEquipmentRequest;
import com.omerali.farmmanagementproject.business.dtos.equipment.requests.UpdateEquipmentRequest;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.CreateEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.GetAllEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.GetEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.UpdateEquipmentResponse;

import java.util.List;
import java.util.UUID;

public interface EquipmentService {
    CreateEquipmentResponse create(CreateEquipmentRequest request);

    UpdateEquipmentResponse update(UUID id, UpdateEquipmentRequest request);

    GetEquipmentResponse getById(UUID id);

    List<GetAllEquipmentResponse> getAll();

    void delete(UUID id);
}
