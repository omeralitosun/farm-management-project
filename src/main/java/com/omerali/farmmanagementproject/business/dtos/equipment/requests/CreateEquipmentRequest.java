package com.omerali.farmmanagementproject.business.dtos.equipment.requests;

import com.omerali.farmmanagementproject.entities.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEquipmentRequest {
    private String name;
    private EquipmentType equipmentType;
}

