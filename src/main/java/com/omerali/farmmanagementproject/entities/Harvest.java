package com.omerali.farmmanagementproject.entities;

import com.omerali.farmmanagementproject.entities.base.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "harvests")
public class Harvest extends Product {

    @ManyToOne
    @JoinColumn(name="field_id")
    private Field field;
}
