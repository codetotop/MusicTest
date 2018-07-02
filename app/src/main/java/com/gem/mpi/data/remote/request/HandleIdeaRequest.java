package com.gem.mpi.data.remote.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HandleIdeaRequest implements Serializable {
  @SerializedName("work_follow_id")
  @Expose
  String workFlowId;

  @SerializedName("y_kien_xu_ly")
  @Expose
  String handleIdea;

  @SerializedName("type")
  @Expose
  Integer type;

  public HandleIdeaRequest() {
  }

  public HandleIdeaRequest(String work_flow_id, String handle_idea,Integer type) {
    this.workFlowId = work_flow_id;
    this.handleIdea = handle_idea;
    this.type = type;
  }

  public String getWorkFlowId() {
    return workFlowId;
  }

  public void setWorkFlowId(String workFlowId) {
    this.workFlowId = workFlowId;
  }

  public String getHandleIdea() {
    return handleIdea;
  }

  public void setHandleIdea(String handleIdea) {
    this.handleIdea = handleIdea;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
