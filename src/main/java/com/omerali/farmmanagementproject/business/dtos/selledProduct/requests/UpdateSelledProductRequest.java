package com.omerali.farmmanagementproject.business.dtos.selledProduct.requests;

import com.omerali.farmmanagementproject.entities.enums.Unit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSelledProductRequest {
    private String name;
    private double amount;
    private Unit unit;
    private double unitPrice;
    private double totalPrice;
    private String comment;
    private LocalDateTime date;
}
