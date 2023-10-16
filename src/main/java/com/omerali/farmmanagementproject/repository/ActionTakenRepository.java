package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.ActionTaken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ActionTakenRepository extends JpaRepository<ActionTaken, UUID> {

    List<ActionTaken> findAllByFieldId(UUID fieldId);
    List<ActionTaken> findAllByFieldIdAndSeasonId(UUID fieldId, UUID seasonId);
}
