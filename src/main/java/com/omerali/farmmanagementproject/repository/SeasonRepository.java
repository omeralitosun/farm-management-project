package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {
}
