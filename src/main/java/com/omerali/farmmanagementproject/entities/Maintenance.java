package com.omerali.farmmanagementproject.entities;

import com.omerali.farmmanagementproject.entities.enums.MaintenanceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenances")
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private MaintenanceType maintenanceType;
    private double cost;
    private String comment;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
