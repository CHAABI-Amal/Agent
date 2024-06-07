package com.example.agent.models;

import java.util.UUID;

public class Machine {

    private UUID machineId;
    private String code;
    private UUID typeId;
    private UUID moduleId;
    private String name;

    private String type;

    private boolean isonline;
    private String description;
    private String ipAddress;


    private String lastStatus;


    private String currentStatus;

    //*********************888
    public Machine() {
    }

    public Machine(UUID machineId, String code, UUID typeId, UUID modelId, String name, String type, boolean isonline, String description, String ipAddress, String lastStatus, String currentStatus) {
        this.machineId = machineId;
        this.code = code;
        this.typeId = typeId;
        this.moduleId = modelId;
        this.name = name;
        this.type = type;
        this.isonline = isonline;
        this.description = description;
        this.ipAddress = ipAddress;
        this.lastStatus = lastStatus;
        this.currentStatus = currentStatus;
    }

    public boolean isIsonline() {
        return isonline;
    }
    public void setIsonline(boolean isonline) {
        this.isonline = isonline;
    }
    public UUID getMachineId() {
        return machineId;
    }
    public void setMachineId(UUID machineId) {
        this.machineId = machineId;
    }

    public UUID getTypeId() {
        return typeId;
    }

    public void setTypeId(UUID typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public UUID getModuleId() {
        return moduleId;
    }

    public void setModuleId(UUID moduleId) {
        this.moduleId = moduleId;
    }
}
