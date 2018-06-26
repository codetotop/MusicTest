package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.FunctionDTO;
import com.gem.mpi.model.FunctionModel;

public class FunctionMapper {
    public static FunctionModel transform(FunctionDTO functionDTO){
        if(functionDTO!=null){
            FunctionModel functionModel = new FunctionModel();
            functionModel.setDesc(functionDTO.getDesc());
            functionModel.setType(functionDTO.getType());
            return functionModel;
        }
        return null;
    }

    public static FunctionDTO transform(FunctionModel functionModel){
        if(functionModel!=null){
            FunctionDTO functionDTO = new FunctionDTO();
            functionDTO.setDesc(functionModel.getDesc());
            functionDTO.setType(functionModel.getType());
            return functionDTO;
        }

        return null;
    }
}
