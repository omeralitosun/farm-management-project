package com.omerali.farmmanagementproject.business.abstracts;

import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.CreateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.requests.UpdateActionTakenRequest;
import com.omerali.farmmanagementproject.business.dtos.actionTaken.responses.*;


import java.util.List;
import java.util.UUID;

public interface ActionTakenService {
    CreateActionTakenResponse create(CreateActionTakenRequest request);

    UpdateActionTakenResponse update(UUID id, UpdateActionTakenRequest request);

    GetActionTakenResponse getById(UUID id);

    List<GetAllActionTakenResponse> getAll();

    void delete(UUID id);

    List<GetAllActionTakenByFieldResponse> getAllByField(UUID fieldId);
    List<GetAllActionTakenByFieldAndSeasonResponse> getAllByFieldAndSeason(UUID fieldId, UUID seasonId);
}
