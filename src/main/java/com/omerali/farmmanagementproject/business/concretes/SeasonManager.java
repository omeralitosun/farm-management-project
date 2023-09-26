package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.SeasonService;
import com.omerali.farmmanagementproject.business.dtos.season.requests.CreateSeasonRequest;
import com.omerali.farmmanagementproject.business.dtos.season.responses.CreateSeasonResponse;
import com.omerali.farmmanagementproject.business.dtos.season.responses.GetAllSeasonResponse;
import com.omerali.farmmanagementproject.business.dtos.season.responses.GetSeasonResponse;
import com.omerali.farmmanagementproject.entities.Season;
import com.omerali.farmmanagementproject.repository.SeasonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SeasonManager implements SeasonService {

    private final SeasonRepository repository;
    private final ModelMapper mapper;
    @Override
    public CreateSeasonResponse create(CreateSeasonRequest request) {

        Season season = mapper.map(request,Season.class);
        season.setId(null);
        repository.save(season);
        CreateSeasonResponse response = mapper.map(season, CreateSeasonResponse.class);

        return response;
    }

    @Override
    public GetSeasonResponse getById(UUID id) {

        Season season = repository.findById(id).orElseThrow();
        GetSeasonResponse response = mapper.map(season,GetSeasonResponse.class);

        return response;
    }

    @Override
    public List<GetAllSeasonResponse> getAll() {
        List<Season> seasons = repository.findAll();
        List<GetAllSeasonResponse> responses = seasons
                .stream()
                .map(season -> mapper.map(season, GetAllSeasonResponse.class))
                .toList();

        return responses;
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
