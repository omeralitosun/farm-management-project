package com.omerali.farmmanagementproject.business.dtos.season.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSeasonResponse {
    private UUID id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}