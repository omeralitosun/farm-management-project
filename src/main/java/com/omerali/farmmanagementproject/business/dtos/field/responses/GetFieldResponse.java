package com.omerali.farmmanagementproject.business.dtos.field.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFieldResponse {
    private UUID id;
    private String name;
    private double decare;
}
