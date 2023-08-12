package com.omerali.farmmanagementproject.business.dtos.equipment.responses;

import com.omerali.farmmanagementproject.entities.enums.EquipmentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllEquipmentResponse {
    private UUID id;
    private String name;
    private String equipmentType;
}
