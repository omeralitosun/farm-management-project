package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.Maintenance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaintenanceRepository extends JpaRepository<Maintenance, UUID> {
    Page<Maintenance> findAllByEquipmentId(UUID id, PageRequest pageRequest);
}
