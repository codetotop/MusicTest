package com.gem.mpi.screen.main.workflowlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.util.Constants;

import java.util.ArrayList;

public class WorkFlowListAdapter extends RecyclerView.Adapter<WorkFlowListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<WorkFlowListModel> workFlowModels;

    public WorkFlowListAdapter(Context context, ArrayList<WorkFlowListModel> workFlowModels) {
        this.context = context;
        this.workFlowModels = workFlowModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_work_flow_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkFlowListModel workFlowModel = workFlowModels.get(position);
        holder.tvTitle.setText(workFlowModel.getTitle());
        holder.tvDocSymbol.setText(Constants.PREFIX_DOC_SYMBOL + workFlowModel.getDocSymbol());
        holder.tvNewIdea.setText(Constants.PREFIX_NEW_IDEA + workFlowModel.getNewIdea());
        holder.tvDuration.setText(Constants.PREFIX_DURATION + workFlowModel.getDuration());
        String status = workFlowModel.getStatus();
        if (status.equals("warning")) {
            holder.imgStatus.setBackgroundResource(R.drawable.ic_warning);
        } else if (status.equals("error")) {
            holder.imgStatus.setBackgroundResource(R.drawable.ic_error);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void refreshData(ArrayList<WorkFlowListModel> workFlowModels) {
        this.workFlowModels.clear();
        this.workFlowModels.addAll(workFlowModels);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return workFlowModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDocSymbol, tvNewIdea, tvDuration;
        ImageView imgStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDocSymbol = itemView.findViewById(R.id.tvDocSymbol);
            tvNewIdea = itemView.findViewById(R.id.tvNewIdea);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            imgStatus = itemView.findViewById(R.id.imgStatus);
        }
    }
}
