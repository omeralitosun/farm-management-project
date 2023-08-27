package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.ActionTakenService;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.CreateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.UpdateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.*;
import com.omerali.farmmanagementproject.entities.ActionTaken;
import com.omerali.farmmanagementproject.repository.ActionTakenRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ActionTakenManager implements ActionTakenService {
    private final ActionTakenRepository repository;
    private final ModelMapper mapper;
    @Override
    public CreateActionTakenResponse create(CreateActionTakenRequest request) {
        ActionTaken actionTaken = mapper.map(request,ActionTaken.class);
        actionTaken.setId(null);

        repository.save(actionTaken);
        CreateActionTakenResponse response = mapper.map(actionTaken,CreateActionTakenResponse.class);
        if (actionTaken.getProcess() != null) {
            response.setProcess(actionTaken.getProcess().tr);
        }
        return response;
    }

    @Override
    public UpdateActionTakenResponse update(UUID id, UpdateActionTakenRequest request) {
        ActionTaken actionTaken = mapper.map(request,ActionTaken.class);
        actionTaken.setId(id);

        repository.save(actionTaken);
        UpdateActionTakenResponse response = mapper.map(actionTaken,UpdateActionTakenResponse.class);
        if (actionTaken.getProcess() != null) {
            response.setProcess(actionTaken.getProcess().tr);
        }
        return response;
    }

    @Override
    public GetActionTakenResponse getById(UUID id) {
        ActionTaken actionTaken = repository.findById(id).orElseThrow();
        GetActionTakenResponse response = mapper.map(actionTaken,GetActionTakenResponse.class);
        if (actionTaken.getProcess() != null) {
            response.setProcess(actionTaken.getProcess().tr);
        }
        return response;
    }

    @Override
    public List<GetAllActionTakenResponse> getAll() {
        List<ActionTaken> actionTakens = repository.findAll();
        List<GetAllActionTakenResponse> responses = actionTakens
                .stream()
                .map(actionTaken -> {
                    GetAllActionTakenResponse r = mapper.map(actionTaken, GetAllActionTakenResponse.class);
                    if (actionTaken.getProcess() != null) {
                        r.setProcess(actionTaken.getProcess().tr);
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

    @Override
    public List<GetAllActionTakenByFieldResponse> getAllByField(UUID fieldId) {
        List<ActionTaken> actionTakens = repository.findAllByFieldId(fieldId);
        List<GetAllActionTakenByFieldResponse> responses = actionTakens
                .stream()
                .map(actionTaken -> {
                    GetAllActionTakenByFieldResponse r = mapper.map(actionTaken, GetAllActionTakenByFieldResponse.class);
                    if (actionTaken.getProcess() != null) {
                        r.setProcess(actionTaken.getProcess().tr);
                    }
                    return r;
                })
                .toList();

        return responses;
    }
}
