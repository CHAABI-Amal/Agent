package com.example.agent.models;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Composant implements Serializable {

    private UUID id;
    private String name;

    private int statusId;

    private String value;// 80% , 50% ............

    private LocalDateTime lastStatusChangeTime;// date de status actuelle

    private String lastStatus;// status ancienne

    private String currentStatus;


    private String code;

    private UUID machineId;

    private int componentTypeId;
    private String model;

    private boolean isDeleted;

    private LocalDateTime composantCreatedDate;

    private LocalDateTime composantModifiedDate;

    //****************************************
    // Constructeur
    public Composant() {
    }

    public Composant(UUID id, String name, int statusId, String value, LocalDateTime lastStatusChangeTime, String lastStatus, String currentStatus, String code, UUID machineId, int componentTypeId, String model, boolean isDeleted, LocalDateTime composantCreatedDate, LocalDateTime composantModifiedDate) {
        this.id = id;
        this.name = name;
        this.statusId = statusId;
        this.value = value;
        this.lastStatusChangeTime = lastStatusChangeTime;
        this.lastStatus = lastStatus;
        this.currentStatus = currentStatus;
        this.code = code;
        this.machineId = machineId;
        this.componentTypeId = componentTypeId;
        this.model = model;
        this.isDeleted = isDeleted;
        this.composantCreatedDate = composantCreatedDate;
        this.composantModifiedDate = composantModifiedDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getLastStatusChangeTime() {
        return lastStatusChangeTime;
    }

    public void setLastStatusChangeTime(LocalDateTime lastStatusChangeTime) {
        this.lastStatusChangeTime = lastStatusChangeTime;
    }

    public String getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(String lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getMachineId() {
        return machineId;
    }

    public void setMachineId(UUID machineId) {
        this.machineId = machineId;
    }

    public int getComponentTypeId() {
        return componentTypeId;
    }

    public void setComponentTypeId(int componentTypeId) {
        this.componentTypeId = componentTypeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public LocalDateTime getComposantCreatedDate() {
        return composantCreatedDate;
    }

    public void setComposantCreatedDate(LocalDateTime composantCreatedDate) {
        this.composantCreatedDate = composantCreatedDate;
    }

    public LocalDateTime getComposantModifiedDate() {
        return composantModifiedDate;
    }

    public void setComposantModifiedDate(LocalDateTime composantModifiedDate) {
        this.composantModifiedDate = composantModifiedDate;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
