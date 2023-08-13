package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.MaintenanceService;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.GetAllActionTakenResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.requests.CreateMaintenanceRequest;
import com.omerali.farmmanagementproject.business.dtos.maintenance.requests.UpdateMaintenanceRequest;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.CreateMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetAllMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.UpdateMaintenanceResponse;
import com.omerali.farmmanagementproject.entities.Maintenance;
import com.omerali.farmmanagementproject.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapper mapper;
    @Override
    public CreateMaintenanceResponse create(CreateMaintenanceRequest request) {
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(null);

        repository.save(maintenance);
        CreateMaintenanceResponse response = mapper.map(maintenance,CreateMaintenanceResponse.class);

        if (maintenance.getMaintenanceType() != null) {
            response.setMaintenanceType(maintenance.getMaintenanceType().tr);
        }
        return response;
    }

    @Override
    public UpdateMaintenanceResponse update(UUID id, UpdateMaintenanceRequest request) {
        Maintenance maintenance = mapper.map(request,Maintenance.class);
        maintenance.setId(id);

        repository.save(maintenance);
        UpdateMaintenanceResponse response = mapper.map(maintenance,UpdateMaintenanceResponse.class);

        if (maintenance.getMaintenanceType() != null) {
            response.setMaintenanceType(maintenance.getMaintenanceType().tr);
        }
        return response;
    }

    @Override
    public GetMaintenanceResponse getById(UUID id) {
        Maintenance maintenance = repository.findById(id).orElseThrow();
        GetMaintenanceResponse response = mapper.map(maintenance,GetMaintenanceResponse.class);

        if (maintenance.getMaintenanceType() != null) {
            response.setMaintenanceType(maintenance.getMaintenanceType().tr);
        }
        return response;
    }

    @Override
    public List<GetAllMaintenanceResponse> getAll() {
        List<Maintenance> maintenances = repository.findAll();
        List<GetAllMaintenanceResponse> responses = maintenances
                .stream()
                .map(maintenance -> {
                    GetAllMaintenanceResponse r = mapper.map(maintenance, GetAllMaintenanceResponse.class);
                    if (maintenance.getMaintenanceType() != null) {
                        r.setMaintenanceType(maintenance.getMaintenanceType().tr);
                    }
                    return r;
                })
                .toList();

        return responses;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}