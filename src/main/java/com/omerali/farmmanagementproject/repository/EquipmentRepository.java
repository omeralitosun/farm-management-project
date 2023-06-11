package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EquipmentRepository extends JpaRepository<Equipment, UUID> {
}
