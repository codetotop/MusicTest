package com.gem.mpi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FunctionModel implements Serializable {
    private String desc;
    private String type;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
