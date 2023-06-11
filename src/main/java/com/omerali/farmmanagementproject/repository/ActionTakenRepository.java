package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.ActionTaken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionTakenRepository extends JpaRepository<ActionTaken, UUID> {
}
