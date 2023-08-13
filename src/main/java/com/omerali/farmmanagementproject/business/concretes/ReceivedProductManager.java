package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.ReceivedProductService;
import com.omerali.farmmanagementproject.business.dtos.maintenance.responses.GetAllMaintenanceResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests.CreateReceivedProductRequest;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests.UpdateReceivedProductRequest;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.CreateReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetAllReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.UpdateReceivedProductResponse;
import com.omerali.farmmanagementproject.entities.ReceivedProduct;
import com.omerali.farmmanagementproject.repository.ReceivedProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReceivedProductManager implements ReceivedProductService {
    private final ReceivedProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreateReceivedProductResponse create(CreateReceivedProductRequest request) {

        ReceivedProduct receivedProduct = mapper.map(request,ReceivedProduct.class);
        receivedProduct.setId(null);
        repository.save(receivedProduct);
        CreateReceivedProductResponse response = mapper.map(receivedProduct, CreateReceivedProductResponse.class);

        if (receivedProduct.getUnit() != null) {
            response.setUnit(receivedProduct.getUnit().tr);
        }
        return response;
    }

    @Override
    public UpdateReceivedProductResponse update(UUID id, UpdateReceivedProductRequest request) {

        ReceivedProduct receivedProduct = mapper.map(request,ReceivedProduct.class);
        receivedProduct.setId(id);
        repository.save(receivedProduct);
        UpdateReceivedProductResponse response = mapper.map(receivedProduct, UpdateReceivedProductResponse.class);

        if (receivedProduct.getUnit() != null) {
            response.setUnit(receivedProduct.getUnit().tr);
        }
        return response;
    }

    @Override
    public GetReceivedProductResponse getById(UUID id) {

        ReceivedProduct receivedProduct = repository.findById(id).orElseThrow();
        GetReceivedProductResponse response = mapper.map(receivedProduct,GetReceivedProductResponse.class);

        if (receivedProduct.getUnit() != null) {
            response.setUnit(receivedProduct.getUnit().tr);
        }
        return response;
    }

    @Override
    public List<GetAllReceivedProductResponse> getAll() {
        List<ReceivedProduct> receivedProducts = repository.findAll();
        List<GetAllReceivedProductResponse> responses = receivedProducts
                .stream()
                .map(receivedProduct -> {
                    GetAllReceivedProductResponse r = mapper.map(receivedProduct, GetAllReceivedProductResponse.class);
                    if (receivedProduct.getUnit() != null) {
                        r.setUnit(receivedProduct.getUnit().tr);
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
