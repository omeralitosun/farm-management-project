package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.abstracts.SelledProductService;
import com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses.GetAllReceivedProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.requests.CreateSelledProductRequest;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.requests.UpdateSelledProductRequest;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.CreateSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.GetAllSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.GetSelledProductResponse;
import com.omerali.farmmanagementproject.business.dtos.selledProduct.responses.UpdateSelledProductResponse;
import com.omerali.farmmanagementproject.entities.SelledProduct;
import com.omerali.farmmanagementproject.repository.SelledProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SelledProductManager implements SelledProductService {
    private final SelledProductRepository repository;
    private final ModelMapper mapper;

    @Override
    public CreateSelledProductResponse create(CreateSelledProductRequest request) {

        SelledProduct selledProduct = mapper.map(request,SelledProduct.class);
        selledProduct.setId(null);
        repository.save(selledProduct);
        CreateSelledProductResponse response = mapper.map(selledProduct, CreateSelledProductResponse.class);

        if (selledProduct.getUnit() != null) {
            response.setUnit(selledProduct.getUnit().tr);
        }
        return response;
    }

    @Override
    public UpdateSelledProductResponse update(UUID id, UpdateSelledProductRequest request) {

        SelledProduct selledProduct = mapper.map(request,SelledProduct.class);
        selledProduct.setId(id);
        repository.save(selledProduct);
        UpdateSelledProductResponse response = mapper.map(selledProduct, UpdateSelledProductResponse.class);

        if (selledProduct.getUnit() != null) {
            response.setUnit(selledProduct.getUnit().tr);
        }
        return response;
    }

    @Override
    public GetSelledProductResponse getById(UUID id) {

        SelledProduct selledProduct = repository.findById(id).orElseThrow();
        GetSelledProductResponse response = mapper.map(selledProduct,GetSelledProductResponse.class);

        if (selledProduct.getUnit() != null) {
            response.setUnit(selledProduct.getUnit().tr);
        }
        return response;
    }

    @Override
    public List<GetAllSelledProductResponse> getAll() {
        List<SelledProduct> selledProducts = repository.findAll();
        List<GetAllSelledProductResponse> responses = selledProducts
                .stream()
                .map(selledProduct -> {
                    GetAllSelledProductResponse r = mapper.map(selledProduct, GetAllSelledProductResponse.class);
                    if (selledProduct.getUnit() != null) {
                        r.setUnit(selledProduct.getUnit().tr);
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
