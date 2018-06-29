package com.gem.mpi.screen.main.workflow.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        .into(holder.imgEmployeeAvatar);
    holder.tvEmployeeName.setText(handleIdeaModel.getEmployeeName());
    holder.tvTimeSendData.setText(handleIdeaModel.getTimeSendIdea());
    holder.tvDescIdea.setText(handleIdeaModel.getDescIdea());
    holder.tvPersonSign.setText(handleIdeaModel.getPersonSign());
    holder.documentViewHandleIdea.setDocumentName(handleIdeaModel.getDocumentRelationName());
    holder.documentViewHandleIdea.setVisibilityDecorationLine(false);//Hide decorationline of document
    holder.documentViewHandleIdea.setDownloadDocumentVisibility(false);
    if (position == (handleIdeaModels.size() - 1))
      holder.tvDecoration.setVisibility(View.INVISIBLE);
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
    ImageView imgEmployeeAvatar;
    TextView tvEmployeeName, tvTimeSendData, tvDescIdea, tvPersonSign, tvDecoration;
    DocumentView documentViewHandleIdea;

    public ViewHolder(View itemView) {
      super(itemView);
      imgEmployeeAvatar = itemView.findViewById(R.id.imgEmployeeAvatar);
      tvEmployeeName = itemView.findViewById(R.id.tvEmployeeName);
      tvTimeSendData = itemView.findViewById(R.id.tvTimeSendIdea);
      tvDescIdea = itemView.findViewById(R.id.tvDescIdea);
      tvPersonSign = itemView.findViewById(R.id.tvPersonSign);
      documentViewHandleIdea = itemView.findViewById(R.id.documentViewHandleIdea);
      tvDecoration = itemView.findViewById(R.id.tvDecorationLineIdea);
    }

  }
}
