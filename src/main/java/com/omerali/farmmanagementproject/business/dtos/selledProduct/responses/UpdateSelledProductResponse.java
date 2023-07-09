package com.omerali.farmmanagementproject.business.dtos.selledProduct.responses;

import com.omerali.farmmanagementproject.entities.enums.Unit;
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
public class UpdateSelledProductResponse {
    private UUID id;
    private String name;
    private double amount;
    private Unit unit;
    private double unitPrice;
    private double totalPrice;
    private String comment;
    private LocalDateTime date;
}
