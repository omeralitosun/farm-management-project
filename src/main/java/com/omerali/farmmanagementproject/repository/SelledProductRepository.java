package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.SelledProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SelledProductRepository extends JpaRepository<SelledProduct, UUID> {
}
