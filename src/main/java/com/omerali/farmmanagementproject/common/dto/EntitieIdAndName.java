package com.omerali.farmmanagementproject.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
/*
Data transfer object created to fetch the id and namespaces of entities
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntitieIdAndName {

    private UUID id;
    private String name;
}
