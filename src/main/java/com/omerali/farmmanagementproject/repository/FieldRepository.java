package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FieldRepository extends JpaRepository<Field, UUID> {
}

