package com.omerali.farmmanagementproject.entities;

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
@Table(name = "action_takens")
public class ActionTaken {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Process process;
    private double cost;
    private String comment;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name="field_id")
    private Field field;
}
