package com.omerali.farmmanagementproject.entities.enums;

public enum Unit {
    NUMBER("Adet"),
    KILOGRAM("Kilogram"),
    LITER("Litre");
    public final String tr;

    private Unit(String tr) {
        this.tr = tr;
    }
}
