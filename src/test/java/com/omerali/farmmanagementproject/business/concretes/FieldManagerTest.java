package com.omerali.farmmanagementproject.business.concretes;

import com.omerali.farmmanagementproject.business.dtos.field.requests.CreateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.requests.UpdateFieldRequest;
import com.omerali.farmmanagementproject.business.dtos.field.responses.CreateFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetAllFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.GetFieldResponse;
import com.omerali.farmmanagementproject.business.dtos.field.responses.UpdateFieldResponse;
import com.omerali.farmmanagementproject.core.exceptions.BusinessException;
import com.omerali.farmmanagementproject.entities.Field;
import com.omerali.farmmanagementproject.repository.FieldRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class FieldManagerTest {

    FieldManager fieldManager;
    FieldRepository fieldRepository;
    ModelMapper modelMapper;

    @BeforeEach
    public void before(){
        fieldRepository = mock(FieldRepository.class);
        modelMapper = mock(ModelMapper.class);

        fieldManager = new FieldManager(fieldRepository,modelMapper);
    }
    @Test
    void create() {
        //Given
        CreateFieldRequest fieldRequest = new CreateFieldRequest();
        fieldRequest.setName("Test");
        fieldRequest.setDecare(1.0);

        Field field = new Field();
        field.setName(fieldRequest.getName());
        field.setDecare(fieldRequest.getDecare());

        CreateFieldResponse fieldResponse = new CreateFieldResponse();
        UUID uuid = UUID.randomUUID();
        fieldResponse.setId(uuid);
        fieldResponse.setName(field.getName());
        fieldResponse.setDecare(field.getDecare());



        given(modelMapper.map(fieldRequest,Field.class)).willReturn(field);
        given(fieldRepository.save(field)).willReturn(field);
        given(modelMapper.map(field, CreateFieldResponse.class)).willReturn(fieldResponse);

        //When
        CreateFieldResponse response = fieldManager.create(fieldRequest);

        //Than
        assertEquals(fieldResponse, response);
    }

    @Test
    void update() {
        //Given
        UUID uuid = UUID.randomUUID();
        UpdateFieldRequest fieldRequest = new UpdateFieldRequest();
        fieldRequest.setName("Test");
        fieldRequest.setDecare(1.0);

        Field field = new Field();
        field.setId(uuid);
        field.setName(fieldRequest.getName());
        field.setDecare(fieldRequest.getDecare());

        UpdateFieldResponse fieldResponse = new UpdateFieldResponse();
        fieldResponse.setId(uuid);
        fieldResponse.setName(field.getName());
        fieldResponse.setDecare(field.getDecare());



        given(modelMapper.map(fieldRequest,Field.class)).willReturn(field);
        given(fieldRepository.save(field)).willReturn(field);
        given(modelMapper.map(field, UpdateFieldResponse.class)).willReturn(fieldResponse);

        //When
        UpdateFieldResponse response = fieldManager.update(uuid, fieldRequest);

        //Than
        assertEquals(fieldResponse, response);
    }

    @Test
    void getById() {
        //Given
        UUID uuid = UUID.randomUUID();

        Field field = new Field();
        field.setId(uuid);
        field.setName("Test");
        field.setDecare(1.0);

        GetFieldResponse fieldResponse = new GetFieldResponse();
        fieldResponse.setId(field.getId());
        fieldResponse.setName(field.getName());
        fieldResponse.setDecare(field.getDecare());

        given(fieldRepository.findById(uuid)).willReturn(Optional.of(field));
        given(modelMapper.map(field,GetFieldResponse.class)).willReturn(fieldResponse);

        //When
        GetFieldResponse response = fieldManager.getById(uuid);

        //Than
        assertEquals(fieldResponse, response);
    }

    @Test
    void getAll() {
        UUID uuid = UUID.randomUUID();

        Field field = new Field();
        field.setId(uuid);
        field.setName("Test");
        field.setDecare(1.0);

        GetAllFieldResponse fieldResponse = new GetAllFieldResponse();
        fieldResponse.setId(field.getId());
        fieldResponse.setName(field.getName());
        fieldResponse.setDecare(field.getDecare());

        List<Field> fieldList = new ArrayList<>();
        fieldList.add(field);

        given(fieldRepository.findAll()).willReturn(fieldList);
        given(modelMapper.map(field,GetAllFieldResponse.class)).willReturn(fieldResponse);

        //When
        List<GetAllFieldResponse> response = fieldManager.getAll();

        //Than
        assertEquals(fieldResponse, response.get(0));

    }

    @Test
    void deleteField() {
        UUID uuid = UUID.randomUUID();
        Mockito.doNothing().when(fieldRepository).deleteById(uuid);

        fieldManager.delete(uuid);
    }

    @Test
    void throwExceptionWhenDeleteByNullId(){
        assertThrows(BusinessException.class,() -> fieldManager.delete(null),"Id null olamaz.");
    }
}