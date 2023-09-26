package com.omerali.farmmanagementproject.business.abstracts;



import com.omerali.farmmanagementproject.business.dtos.season.requests.CreateSeasonRequest;
import com.omerali.farmmanagementproject.business.dtos.season.responses.CreateSeasonResponse;
import com.omerali.farmmanagementproject.business.dtos.season.responses.GetAllSeasonResponse;
import com.omerali.farmmanagementproject.business.dtos.season.responses.GetSeasonResponse;

import java.util.List;
import java.util.UUID;

public interface SeasonService {
    CreateSeasonResponse create(CreateSeasonRequest request);
    GetSeasonResponse getById(UUID id);
    List<GetAllSeasonResponse> getAll();
    void delete(UUID id);
}
