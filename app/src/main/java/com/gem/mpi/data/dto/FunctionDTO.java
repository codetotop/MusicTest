package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FunctionDTO implements Serializable {
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("type")
    @Expose
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
