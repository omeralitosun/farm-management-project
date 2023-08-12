package com.omerali.farmmanagementproject.entities.enums;

public enum EquipmentType {
    CAR("Araba"),
    TRACTOR("Traktör");

    public final String tr;

    private EquipmentType(String tr) {
        this.tr = tr;
    }
}
