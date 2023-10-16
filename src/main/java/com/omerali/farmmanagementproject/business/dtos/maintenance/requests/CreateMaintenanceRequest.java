package com.omerali.farmmanagementproject.business.dtos.maintenance.requests;

import com.omerali.farmmanagementproject.entities.Equipment;
import com.omerali.farmmanagementproject.entities.enums.MaintenanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
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
public class CreateMaintenanceRequest {
    @NotNull
    private MaintenanceType maintenanceType;
    @Min(value = 0)
    private double cost;
    private String comment;
    private LocalDateTime date;
    @NotNull
    private UUID equipmentId;
}

