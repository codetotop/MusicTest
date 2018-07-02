package com.gem.mpi.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class HandleIdeaDTO implements Serializable {

  @SerializedName("Comments")
  @Expose
  private ArrayList<CommentDTO> commentDTOS;

  public ArrayList<CommentDTO> getCommentDTOS() {
    return commentDTOS;
  }

  public void setCommentDTOS(ArrayList<CommentDTO> commentDTOS) {
    this.commentDTOS = commentDTOS;
  }

  public HandleIdeaDTO() {
  }

  public HandleIdeaDTO(ArrayList<CommentDTO> commentDTOS) {
    this.commentDTOS = commentDTOS;
  }
}
