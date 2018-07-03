package com.gem.mpi.screen.main.main.workfollowlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;

import java.util.ArrayList;

public class WorkFollowListAdapter extends RecyclerView.Adapter<WorkFollowListAdapter.ViewHolder> {

  private Context context;
  private ArrayList<WorkFollowListModel> workFlowModels;
  private OnItemClick onItemClick;

  public WorkFollowListAdapter(Context context, ArrayList<WorkFollowListModel> workFlowModels, OnItemClick onItemClick) {
    this.context = context;
    this.workFlowModels = workFlowModels;
    this.onItemClick = onItemClick;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View itemView = inflater.inflate(R.layout.item_work_follow_list, parent, false);
    return new ViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    WorkFollowListModel workFlowModel = workFlowModels.get(position);
    holder.mTitleTv.setText(workFlowModel.getTitle());
    holder.mDocSymbolTv.setText(context.getString(R.string.workfollowlist_prefix_doc_symbol) + workFlowModel.getDocSymbol());
    holder.mNewIdeaTv.setText(context.getString(R.string.workfollowlist_prefix_new_idea) + workFlowModel.getNewIdea());
    holder.mDurationTv.setText(context.getString(R.string.workfollowlist_prefix_duration) + workFlowModel.getDuration());
    String status = workFlowModel.getStatus();
    if (status.equals("warning")) {
      holder.mStatusImg.setBackgroundResource(R.drawable.ic_warning);
    } else if (status.equals("error")) {
      holder.mStatusImg.setBackgroundResource(R.drawable.ic_attention);
    }

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onItemClick.click(position);
      }
    });
  }

  public void refreshData(ArrayList<WorkFollowListModel> workFlowModels) {
    this.workFlowModels.clear();
    this.workFlowModels.addAll(workFlowModels);
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return workFlowModels.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    TextView mTitleTv, mDocSymbolTv, mNewIdeaTv, mDurationTv;
    ImageView mStatusImg;

    public ViewHolder(View itemView) {
      super(itemView);
      mTitleTv = itemView.findViewById(R.id.itemhandleidea_tv_title);
      mDocSymbolTv = itemView.findViewById(R.id.itemhandleidea_tv_docsymbol);
      mNewIdeaTv = itemView.findViewById(R.id.itemhandleidea_tv_newidea);
      mDurationTv = itemView.findViewById(R.id.itemhandleidea_tv_duration);
      mStatusImg = itemView.findViewById(R.id.itemhandleidea_img_status);
    }
  }

  interface OnItemClick {
    void click(int position);
  }
}
