package com.gem.mpi.screen.main.workflow.model;

import java.io.Serializable;

public class HandleIdeaModel implements Serializable {
    private String employeeAvatar;
    private String employeeName;
    private String timeSendIdea;
    private String descIdea;
    private String personSign;
    private String documentRelationName;

    public HandleIdeaModel() {
    }

    public HandleIdeaModel(String employeeAvatar, String employeeName, String timeSendIdea, String descIdea, String personSign, String documentRelationName) {
        this.employeeAvatar = employeeAvatar;
        this.employeeName = employeeName;
        this.timeSendIdea = timeSendIdea;
        this.descIdea = descIdea;
        this.personSign = personSign;
        this.documentRelationName = documentRelationName;
    }

    public String getEmployeeAvatar() {
        return employeeAvatar;
    }

    public void setEmployeeAvatar(String employeeAvatar) {
        this.employeeAvatar = employeeAvatar;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getTimeSendIdea() {
        return timeSendIdea;
    }

    public void setTimeSendIdea(String timeSendIdea) {
        this.timeSendIdea = timeSendIdea;
    }

    public String getDescIdea() {
        return descIdea;
    }

    public void setDescIdea(String descIdea) {
        this.descIdea = descIdea;
    }

    public String getPersonSign() {
        return personSign;
    }

    public void setPersonSign(String personSign) {
        this.personSign = personSign;
    }

    public String getDocumentRelationName() {
        return documentRelationName;
    }

    public void setDocumentRelationName(String documentRelationName) {
        this.documentRelationName = documentRelationName;
    }
}
