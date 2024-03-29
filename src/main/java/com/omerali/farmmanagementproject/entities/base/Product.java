package com.omerali.farmmanagementproject.entities.base;

import com.omerali.farmmanagementproject.entities.enums.Unit;
import jakarta.persistence.*;
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
@MappedSuperclass
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double amount;
    @Enumerated(EnumType.STRING)
    private Unit unit;
    private double unitPrice;
    private double totalPrice;
    private String comment;
    private LocalDateTime date;

}
