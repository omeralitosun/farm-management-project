package com.omerali.farmmanagementproject.business.dtos.actionTaken.responses;

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
public class GetActionTakenResponse {
    private UUID id;
    private EntitieIdAndName field;
    private String process;
    private double cost;
    private String comment;
    private LocalDateTime date;

}
