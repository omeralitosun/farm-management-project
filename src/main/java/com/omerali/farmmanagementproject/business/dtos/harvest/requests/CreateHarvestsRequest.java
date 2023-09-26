package com.omerali.farmmanagementproject.business.dtos.harvest.requests;

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
public class CreateHarvestsRequest {
    private UUID fieldId;
    private String name;
    private double amount;
    private double unitPrice;
    private String comment;
    private LocalDateTime date;
}
