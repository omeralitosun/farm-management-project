package com.omerali.farmmanagementproject.business.dtos.field.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateFieldRequest {
    private String name;
    private double decare;
}
