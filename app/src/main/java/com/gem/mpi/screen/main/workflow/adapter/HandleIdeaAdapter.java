package com.gem.mpi.screen.main.workflow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gem.mpi.R;
import com.gem.mpi.screen.main.workflow.model.HandleIdeaModel;
import com.gem.mpi.widget.DocumentView;

import java.util.ArrayList;

public class HandleIdeaAdapter extends RecyclerView.Adapter<HandleIdeaAdapter.ViewHolder> {
  private Context context;
  private ArrayList<HandleIdeaModel> handleIdeaModels;

  public HandleIdeaAdapter(Context context, ArrayList<HandleIdeaModel> handleIdeaModels) {
    this.context = context;
    this.handleIdeaModels = handleIdeaModels;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View itemView = inflater.inflate(R.layout.item_handle_idea, parent, false);
    ViewHolder viewHolder = new ViewHolder(itemView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    HandleIdeaModel handleIdeaModel = handleIdeaModels.get(position);
    Glide
        .with(context)
        .load(handleIdeaModel.getEmployeeAvatar())
        .into(holder.mEmployeeAvatarImg);
    holder.mEmployeeNameTv.setText(handleIdeaModel.getEmployeeName());
    holder.mTimeSendDataTv.setText(handleIdeaModel.getTimeSendIdea());
    holder.mDescIdeaTv.setText(handleIdeaModel.getDescIdea());
    holder.mPersonSignTv.setText(handleIdeaModel.getPersonSign());
    holder.mdocumentViewHandleIdea.setDocumentName(handleIdeaModel.getDocumentRelationName());
    holder.mdocumentViewHandleIdea.setVisibilityDecorationLine(false);//Hide decorationline of document
    holder.mdocumentViewHandleIdea.setDownloadDocumentVisibility(false);
    if (position == (handleIdeaModels.size() - 1))
      holder.mDecorationTv.setVisibility(View.INVISIBLE);
  }

  public void refresh(ArrayList<HandleIdeaModel> handleIdeaModels) {
    this.handleIdeaModels.clear();
    this.handleIdeaModels.addAll(handleIdeaModels);
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return handleIdeaModels.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    ImageView mEmployeeAvatarImg;
    TextView mEmployeeNameTv, mTimeSendDataTv, mDescIdeaTv, mPersonSignTv, mDecorationTv;
    DocumentView mdocumentViewHandleIdea;

    public ViewHolder(View itemView) {
      super(itemView);
      mEmployeeAvatarImg = itemView.findViewById(R.id.itemhandleidea_img_employee_avatar);
      mEmployeeNameTv = itemView.findViewById(R.id.itemhandleidea_tv_employeename);
      mTimeSendDataTv = itemView.findViewById(R.id.itemhandleidea_tv_time_sendidea);
      mDescIdeaTv = itemView.findViewById(R.id.itemhandleidea_tv_descidea);
      mPersonSignTv = itemView.findViewById(R.id.itemhandleidea_tv_personsign);
      mdocumentViewHandleIdea = itemView.findViewById(R.id.itemhandleidea_documentview);
      mDecorationTv = itemView.findViewById(R.id.itemhandleidea_tv_decorationline);
    }

  }
}
