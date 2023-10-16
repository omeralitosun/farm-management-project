package com.omerali.farmmanagementproject.business.abstracts;



import com.omerali.farmmanagementproject.business.dtos.harvest.requests.CreateHarvestRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.CreateHarvestsRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.UpdateHarvestRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.responses.*;

import java.util.List;
import java.util.UUID;

public interface HarvestService {
    CreateHarvestResponse create(CreateHarvestRequest request);

    void createHarvests(List<CreateHarvestsRequest> request);
    UpdateHarvestResponse update(UUID id, UpdateHarvestRequest request);

    GetHarvestResponse getById(UUID id);

    List<GetAllHarvestResponse> getAll();

    void delete(UUID id);

    List<GetAllHarvestByFieldResponse> getAllByField(UUID fieldId);
    List<GetAllHarvestByFieldAndSeasonResponse> getAllByFieldAndSeason(UUID fieldId,UUID seasonId);
}