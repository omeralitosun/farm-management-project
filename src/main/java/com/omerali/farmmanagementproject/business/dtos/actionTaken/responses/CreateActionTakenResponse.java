package com.omerali.farmmanagementproject.business.dtos.actionTaken.responses;

import com.omerali.farmmanagementproject.entities.enums.Process;
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
public class CreateActionTakenResponse {
    private UUID id;
    private String process;
    private double cost;
    private String comment;
    private LocalDateTime date;
    private UUID fieldId;
}

