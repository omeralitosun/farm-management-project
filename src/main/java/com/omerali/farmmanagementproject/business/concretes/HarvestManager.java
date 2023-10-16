package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.HarvestService;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.CreateHarvestRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.CreateHarvestsRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.requests.UpdateHarvestRequest;
import com.omerali.farmmanagementproject.business.dtos.harvest.responses.*;
import com.omerali.farmmanagementproject.entities.Harvest;
import com.omerali.farmmanagementproject.repository.HarvestRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HarvestManager implements HarvestService {
    private final HarvestRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreateHarvestResponse create(CreateHarvestRequest request) {
        Harvest harvest = mapper.map(request, Harvest.class);
        harvest.setId(null);
        harvest.setTotalPrice(harvest.getUnitPrice() * harvest.getAmount());
        repository.save(harvest);
        CreateHarvestResponse response = mapper.map(harvest, CreateHarvestResponse.class);
        return response;
    }

    @Override
    public void createHarvests(List<CreateHarvestsRequest> request) {
        List<Harvest> harvests = request
                .stream()
                .map(harvest -> {
                    Harvest r = mapper.map(harvest, Harvest.class);
                    r.setTotalPrice(r.getUnitPrice() * r.getAmount());
                    return r;
                })
                .toList();
        repository.saveAll(harvests);
    }

    @Override
    public UpdateHarvestResponse update(UUID id, UpdateHarvestRequest request) {
        Harvest harvest = mapper.map(request, Harvest.class);
        harvest.setId(id);
        harvest.setTotalPrice(harvest.getUnitPrice() * harvest.getAmount());
        repository.save(harvest);
        UpdateHarvestResponse response = mapper.map(harvest, UpdateHarvestResponse.class);
        return response;
    }

    @Override
    public GetHarvestResponse getById(UUID id) {
        Harvest harvest = repository.findById(id).orElseThrow();
        GetHarvestResponse response = mapper.map(harvest, GetHarvestResponse.class);

        return response;
    }

    @Override
    public List<GetAllHarvestResponse> getAll() {
        List<Harvest> harvests = repository.findAll();
        return harvests
                .stream()
                .map(harvest -> {
                    GetAllHarvestResponse r = mapper.map(harvest, GetAllHarvestResponse.class);
                    return r;
                })
                .toList();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<GetAllHarvestByFieldResponse> getAllByField(UUID fieldId) {
        List<Harvest> harvests = repository.findAllByFieldId(fieldId);
        return harvests
                .stream()
                .map(harvest ->
                        mapper.map(harvest, GetAllHarvestByFieldResponse.class)
                )
                .toList();

    }

    @Override
    public List<GetAllHarvestByFieldAndSeasonResponse> getAllByFieldAndSeason(UUID fieldId, UUID seasonId) {
        List<Harvest> harvests = repository.findAllByFieldIdAndSeasonId(fieldId,seasonId);
        return harvests
                .stream()
                .map(harvest ->
                        mapper.map(harvest, GetAllHarvestByFieldAndSeasonResponse.class)
                )
                .toList();
    }
}
