package com.omerali.farmmanagementproject.entities.enums;

public enum MaintenanceType {
    MAINTENANCE("Bakım"),
    PARTS_REPLACEMENT("Parça Değişimi"),
    OTHER("Diğer");

    public final String tr;

    private MaintenanceType(String tr) {
        this.tr = tr;
    }
}
