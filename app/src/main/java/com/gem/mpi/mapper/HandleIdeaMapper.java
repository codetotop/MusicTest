package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.HandleIdeaDTO;
import com.gem.mpi.model.CommentModel;
import com.gem.mpi.model.HandleIdeaModel;


public class HandleIdeaMapper {

  public static HandleIdeaModel transform(HandleIdeaDTO handleIdeaDTO) {
    if (handleIdeaDTO != null) {
      HandleIdeaModel handleIdeaModel = new HandleIdeaModel();
      handleIdeaModel.setCommentModels(CommentMapper.transform(handleIdeaDTO.getCommentDTOS()));

      return handleIdeaModel;
    }

    return new HandleIdeaModel();
  }

  public static HandleIdeaDTO transform(HandleIdeaModel handleIdeaModel) {
    if (handleIdeaModel != null) {
      HandleIdeaDTO handleIdeaDTO = new HandleIdeaDTO();
      for (CommentModel commentModel : handleIdeaModel.getCommentModels()) {
        handleIdeaDTO.getCommentDTOS().add(CommentMapper.transform(commentModel));
      }

      return handleIdeaDTO;
    }

    return new HandleIdeaDTO();
  }
}
