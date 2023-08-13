package com.omerali.farmmanagementproject.entities.enums;

public enum Process {
    SOIL_PREPARATION("Toprak İşleme"),
    PLANTING("Ekim Yapma"),
    SPRAYING("İlaçlama"),
    WATERING("Sulama"),
    REAP("Biçim"),
    OTHER("Diğer");

    public final String tr;

    private Process(String tr) {
        this.tr = tr;
    }
}
