package com.omerali.farmmanagementproject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fields")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double decare;
    @OneToMany(mappedBy = "field")
    private List<ActionTaken> actionTakens;
    @OneToMany(mappedBy = "field")
    private List<Harvest> harvests;
}



