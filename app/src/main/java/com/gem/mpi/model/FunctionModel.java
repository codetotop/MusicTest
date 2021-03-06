package com.gem.mpi.model;

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

    @Override
    public String toString() {
        return "FunctionModel{" +
            "desc='" + desc + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
}
