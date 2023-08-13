package com.omerali.farmmanagementproject.business.dtos.receivedProduct.responses;

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
public class GetReceivedProductResponse {
    private UUID id;
    private String name;
    private double amount;
    private String unit;
    private double unitPrice;
    private double totalPrice;
    private String comment;
    private LocalDateTime date;
}
