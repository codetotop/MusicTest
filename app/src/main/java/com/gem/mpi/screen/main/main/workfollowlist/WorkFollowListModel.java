package com.gem.mpi.screen.main.main.workfollowlist;

import java.io.Serializable;

public class WorkFollowListModel implements Serializable {
    private String title;
    private String docSymbol;
    private String newIdea;
    private String duration;
    private String status;

    public WorkFollowListModel() {
    }

    public WorkFollowListModel(String title, String docSymbol, String newIdea, String duration, String status) {
        this.title = title;
        this.docSymbol = docSymbol;
        this.newIdea = newIdea;
        this.duration = duration;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocSymbol() {
        return docSymbol;
    }

    public void setDocSymbol(String docSymbol) {
        this.docSymbol = docSymbol;
    }

    public String getNewIdea() {
        return newIdea;
    }

    public void setNewIdea(String newIdea) {
        this.newIdea = newIdea;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
