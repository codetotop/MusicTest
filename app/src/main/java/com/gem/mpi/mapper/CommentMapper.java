package com.gem.mpi.mapper;

import com.gem.mpi.data.dto.CommentDTO;
import com.gem.mpi.model.CommentModel;

import java.util.ArrayList;

public class CommentMapper {

  public static CommentModel transform(CommentDTO commentDTO) {
    if (commentDTO != null) {
      CommentModel model = new CommentModel();
      model.setIdYKien(commentDTO.getIdYKien());
      model.setAvatarNguoiGopY(commentDTO.getAvatarNguoiGopY());
      model.setNoiDung(commentDTO.getNoiDung());
      model.setTenNguoiGopY(commentDTO.getTenNguoiGopY());
      model.setIdNguoiGopY(commentDTO.getIdNguoiGopY());
      model.setThoiGian(commentDTO.getThoiGian());
      model.setDocumentsAttact(commentDTO.getDocumentsAttact());

      return model;
    }

    return new CommentModel();
  }



  public static CommentDTO transform(CommentModel commentModel) {
    if (commentModel != null) {
      CommentDTO commentDTO = new CommentDTO();
      commentDTO.setIdYKien(commentModel.getIdYKien());
      commentDTO.setAvatarNguoiGopY(commentModel.getAvatarNguoiGopY());
      commentDTO.setNoiDung(commentModel.getNoiDung());
      commentDTO.setTenNguoiGopY(commentModel.getTenNguoiGopY());
      commentDTO.setIdNguoiGopY(commentModel.getIdNguoiGopY());
      commentDTO.setThoiGian(commentModel.getThoiGian());
      commentDTO.setDocumentsAttact(commentModel.getDocumentsAttact());

      return commentDTO;
    }
    return new CommentDTO();
  }


  public static ArrayList<CommentModel> transform(ArrayList<CommentDTO> commentDTOS) {
    if (commentDTOS != null) {
      ArrayList<CommentModel> commentModels = new ArrayList<>();
      for (CommentDTO commentDTO : commentDTOS) {
        commentModels.add(transform(commentDTO));
      }

      return commentModels;
    }

    return new ArrayList<>();
  }
}