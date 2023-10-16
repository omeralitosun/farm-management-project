package com.omerali.farmmanagementproject.business.dtos.receivedProduct.requests;

import com.omerali.farmmanagementproject.entities.enums.Unit;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReceivedProductRequest {
    @NotBlank
    private String name;
    @Min(value = 0)
    private double amount;
    @NotNull
    private Unit unit;
    @Min(value = 0)
    private double unitPrice;
    private String comment;
    private LocalDateTime date;
}
