package com.omerali.farmmanagementproject.repository;

import com.omerali.farmmanagementproject.entities.ReceivedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReceivedProductRepository extends JpaRepository<ReceivedProduct, UUID> {
}
