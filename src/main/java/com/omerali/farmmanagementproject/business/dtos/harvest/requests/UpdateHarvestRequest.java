package com.omerali.farmmanagementproject.business.dtos.harvest.requests;

import com.omerali.farmmanagementproject.entities.enums.Unit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHarvestRequest {
    @NotNull
    private UUID fieldId;
    @NotBlank
    private String name;
    @Min(value = 0)
    private double amount;
    @Min(value = 0)
    private double unitPrice;
    private String comment;
    private LocalDateTime date;
}
