package com.omerali.farmmanagementproject.api.controllers;

import com.omerali.farmmanagementproject.entities.enums.EquipmentType;
import com.omerali.farmmanagementproject.entities.enums.MaintenanceType;
import com.omerali.farmmanagementproject.entities.enums.Process;
import com.omerali.farmmanagementproject.entities.enums.Unit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/enums")
@CrossOrigin
public class EnumsController {

    @GetMapping("/equipment-type")
    public HashMap<String, EquipmentType> getEquipmentTypes() {
        HashMap<String,EquipmentType> response = new HashMap<>();
        Arrays.stream(EquipmentType.values()).forEach(equipmentType -> {
            response.put(equipmentType.tr, equipmentType);
        });
        return response;
    }

    @GetMapping("/maintenance-type")
    public HashMap<String, MaintenanceType> getMaintenanceTypes() {
        HashMap<String,MaintenanceType> response = new HashMap<>();
        Arrays.stream(MaintenanceType.values()).forEach(maintenanceType -> {
            response.put(maintenanceType.tr, maintenanceType);
        });
        return response;
    }

    @GetMapping("/process")
    public HashMap<String, Process> getProcess() {
        HashMap<String,Process> response = new HashMap<>();
        Arrays.stream(Process.values()).forEach(process -> {
            response.put(process.tr, process);
        });
        return response;
    }

    @GetMapping("/unit")
    public HashMap<String, Unit> getUnits() {
        HashMap<String,Unit> response = new HashMap<>();
        Arrays.stream(Unit.values()).forEach(unit -> {
            response.put(unit.tr, unit);
        });
        return response;
    }
}
