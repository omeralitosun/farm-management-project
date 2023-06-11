package com.omerali.farmmanagementproject.entities;

import com.omerali.farmmanagementproject.entities.base.Product;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "received_products")
public class ReceivedProduct extends Product {

}
