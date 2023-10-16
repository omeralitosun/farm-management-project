package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HarvestRepository extends JpaRepository<Harvest,UUID> {
    List<Harvest> findAllByFieldId(UUID fieldId);
    List<Harvest> findAllByFieldIdAndSeasonId(UUID fieldId, UUID seasonId);
}
