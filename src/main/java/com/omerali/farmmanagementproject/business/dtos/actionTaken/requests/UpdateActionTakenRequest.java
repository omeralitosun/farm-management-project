package com.omerali.farmmanagementproject.business.dtos.actionTaken.requests;

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
public class UpdateActionTakenRequest {
    private Process process;
    private double cost;
    private String comment;
    private LocalDateTime date;
    private UUID fieldId;
}
