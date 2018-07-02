package com.gem.mpi.data.remote.services;

import com.gem.mpi.data.dto.HandleIdeaDTO;
import com.gem.mpi.data.dto.WorkFlowDetailDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.request.HandleIdeaRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface WorkFlowServices {
  @POST("GetDetailWorkFollow")
  Call<BaseResponse<WorkFlowDetailDTO>> getWorkFlowDetailData(@Path("work_flow_id") String work_flow_id);
  @POST("AddCommentForProccessWork")
  Call<BaseResponse<HandleIdeaDTO>> handlleIdea(@Body HandleIdeaRequest handleIdeaRequest);
}
