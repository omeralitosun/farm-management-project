package com.omerali.farmmanagementproject.business.dtos.equipment.requests;

import com.omerali.farmmanagementproject.entities.enums.EquipmentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEquipmentRequest {
    @NotBlank
    private String name;
    @NotNull
    private EquipmentType equipmentType;
}

