package com.gem.mpi.screen.main.workflow.model;

import java.io.Serializable;

public class HandleFlowModel implements Serializable {
    private String nameStaff;
    private String duty;
    private String descWorkFlow;
    private String timeHandle;


    public HandleFlowModel() {
    }

    public HandleFlowModel(String nameStaff, String duty, String descWorkFlow, String timeHandle) {
        this.nameStaff = nameStaff;
        this.duty = duty;
        this.descWorkFlow = descWorkFlow;
        this.timeHandle = timeHandle;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDescWorkFlow() {
        return descWorkFlow;
    }

    public void setDescWorkFlow(String descWorkFlow) {
        this.descWorkFlow = descWorkFlow;
    }

    public String getTimeHandle() {
        return timeHandle;
    }

    public void setTimeHandle(String timeHandle) {
        this.timeHandle = timeHandle;
    }
}
