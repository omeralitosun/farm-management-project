package com.omerali.farmmanagementproject.business.dtos.season.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSeasonRequest {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
}
