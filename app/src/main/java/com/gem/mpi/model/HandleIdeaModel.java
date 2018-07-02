package com.gem.mpi.model;

import java.io.Serializable;
import java.util.ArrayList;

public class HandleIdeaModel implements Serializable {

  private ArrayList<CommentModel> commentModels;

  public HandleIdeaModel(ArrayList<CommentModel> commentModels) {
    this.commentModels = commentModels;
  }

  public HandleIdeaModel() {
  }

  public ArrayList<CommentModel> getCommentModels() {
    return commentModels;
  }

  public void setCommentModels(ArrayList<CommentModel> commentModels) {
    this.commentModels = commentModels;
  }

  @Override
  public String toString() {
    return "HandleIdeaModel{" +
        "commentModels=" + commentModels +
        '}';
  }
}
