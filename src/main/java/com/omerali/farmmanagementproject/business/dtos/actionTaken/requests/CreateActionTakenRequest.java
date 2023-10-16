package com.omerali.farmmanagementproject.business.dtos.actionTaken.requests;


import com.omerali.farmmanagementproject.entities.enums.Process;
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
public class CreateActionTakenRequest {
    @NotNull
    private Process process;
    @Min(value = 0,message = "Geçersiz maaliyet")
    private double cost;
    private String comment;
    private LocalDateTime date;
    @NotNull
    private UUID fieldId;
    @NotNull
    private UUID seasonId;
}

