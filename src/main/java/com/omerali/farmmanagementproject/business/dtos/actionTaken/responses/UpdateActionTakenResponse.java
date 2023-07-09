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
public class UpdateActionTakenResponse {
    private UUID id;
    private Process process;
    private double cost;
    private String comment;
    private LocalDateTime date;
    private UUID fieldId;
}

