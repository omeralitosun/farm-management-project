package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.entities.enums.EquipmentType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/enums")
@CrossOrigin
public class EnumsController {

    @GetMapping("/equipment-type")
    public HashMap<String, EquipmentType> getEquipmentTypes() {
        HashMap<String,EquipmentType> response = new HashMap<>();
        Arrays.stream(EquipmentType.values()).forEach(equipmentType -> {
            response.put(equipmentType.tr, equipmentType);
        });
        return response;
    }
}
