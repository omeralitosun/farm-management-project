package com.omerali.farmmanagementproject.business.dtos.maintenance.responses;

import com.omerali.farmmanagementproject.common.dto.EntitieIdAndName;
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
public class GetAllMaintenanceResponse {
    private UUID id;
    private EntitieIdAndName equipment;
    private String maintenanceType;
    private double cost;
    private String comment;
    private LocalDateTime date;
}
