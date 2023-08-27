package com.omerali.farmmanagementproject.business.dtos.harvest.responses;

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
public class GetHarvestResponse {
    private UUID id;
    private EntitieIdAndName field;
    private String name;
    private double amount;
    private double unitPrice;
    private double totalPrice;
    private String comment;
    private LocalDateTime date;
}
