package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.FieldService;
import com.omerali.farmmanagementproject.business.dtos.field.requests.CreateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.requests.UpdateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.responses.CreateFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetAllFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.UpdateFieldResponse;
import com.omerali.farmmanagementproject.entities.Field;
import com.omerali.farmmanagementproject.repository.FieldRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FieldManager implements FieldService {
    private final FieldRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreateFieldResponse create(CreateFieldRequest request) {

        Field field = mapper.map(request,Field.class);
        field.setId(null);
        repository.save(field);
        CreateFieldResponse response = mapper.map(field, CreateFieldResponse.class);

        return response;
    }

    @Override
    public UpdateFieldResponse update(UUID id, UpdateFieldRequest request) {

        Field field = mapper.map(request,Field.class);
        field.setId(id);
        repository.save(field);
        UpdateFieldResponse response = mapper.map(field, UpdateFieldResponse.class);

        return response;
    }

    @Override
    public GetFieldResponse getById(UUID id) {

        Field field = repository.findById(id).orElseThrow();
        GetFieldResponse response = mapper.map(field,GetFieldResponse.class);

        return response;
    }

    @Override
    public List<GetAllFieldResponse> getAll() {
        List<Field> fields = repository.findAll();
        List<GetAllFieldResponse> responses = fields
                .stream()
                .map(field -> mapper.map(field, GetAllFieldResponse.class))
                .toList();

        return responses;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
