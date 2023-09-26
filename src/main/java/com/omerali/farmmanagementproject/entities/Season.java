package com.omerali.farmmanagementproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "season")
    private List<ActionTaken> actionTakens;
    @OneToMany(mappedBy = "season")
    private List<Harvest> harvests;
}
