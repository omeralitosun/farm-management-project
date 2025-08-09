package com.omerali.farmmanagementproject.business.abstracts;


import com.omerali.farmmanagementproject.business.dtos.maintenance.requests.CreateMaintenanceRequest;
import com.omerali.farmmanagementproject.business.dtos.maintenance.requests.UpdateMaintenanceRequest;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.CreateMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetAllMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.UpdateMaintenanceResponse;

import java.util.List;
import java.util.UUID;

public interface MaintenanceService {
    CreateMaintenanceResponse create(CreateMaintenanceRequest request);

    UpdateMaintenanceResponse update(UUID id, UpdateMaintenanceRequest request);

    GetMaintenanceResponse getById(UUID id);

    List<GetAllMaintenanceResponse> getAll(int page, int rows);

    void delete(UUID id);

    List<GetAllMaintenanceResponse> getAllByEquipmentId(UUID equipmentId, int page, int rows);
}
