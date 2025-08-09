package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.EquipmentService;
import com.omerali.farmmanagementproject.business.dtos.equipment.requests.CreateEquipmentRequest;
import com.omerali.farmmanagementproject.business.dtos.equipment.requests.UpdateEquipmentRequest;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.CreateEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.GetAllEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.GetEquipmentResponse;
import com.omerali.farmmanagementproject.business.dtos.equipment.responses.UpdateEquipmentResponse;
import com.omerali.farmmanagementproject.entities.Equipment;
import com.omerali.farmmanagementproject.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EquipmentManager implements EquipmentService {

    private final EquipmentRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreateEquipmentResponse create(CreateEquipmentRequest request) {
        Equipment equipment = mapper.map(request,Equipment.class);
        equipment.setId(null);

        repository.save(equipment);
        CreateEquipmentResponse response = mapper.map(equipment,CreateEquipmentResponse.class);
        if (equipment.getEquipmentType() != null) {
            response.setEquipmentType(equipment.getEquipmentType().tr);
        }
        return response;
    }

    @Override
    public UpdateEquipmentResponse update(UUID id, UpdateEquipmentRequest request) {
        Equipment equipment = mapper.map(request,Equipment.class);
        equipment.setId(id);

        repository.save(equipment);
        UpdateEquipmentResponse response = mapper.map(equipment,UpdateEquipmentResponse.class);
        if (equipment.getEquipmentType() != null) {
            response.setEquipmentType(equipment.getEquipmentType().tr);
        }
        return response;
    }

    @Override
    public GetEquipmentResponse getById(UUID id) {
        Equipment equipment = repository.findById(id).orElseThrow();

        return mapper.map(equipment,GetEquipmentResponse.class);
    }

    @Override
    public List<GetAllEquipmentResponse> getAll(int page, int rows) {
        List<Equipment> equipments;

        if (rows == 0) {
            equipments = repository.findAll();
        } else {
            equipments = repository.findAll(PageRequest.of(page, rows)).getContent();
        }

        return equipments.stream()
                .map(equipment -> mapper.map(equipment, GetAllEquipmentResponse.class))
                .toList();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
