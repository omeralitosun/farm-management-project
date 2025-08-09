package com.omerali.farmmanagementproject.business.dtos.equipment.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetEquipmentResponse {
    private UUID id;
    private String name;
    private String equipmentType;
}
