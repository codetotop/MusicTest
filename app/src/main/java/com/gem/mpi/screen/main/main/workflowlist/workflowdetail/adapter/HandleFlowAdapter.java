package com.gem.mpi.screen.main.main.workflowlist.workflowdetail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.workflowlist.workflowdetail.model.HandleFlowModel;

import java.util.ArrayList;

public class HandleFlowAdapter extends RecyclerView.Adapter<HandleFlowAdapter.ViewHolder>{
    private Context context;
    private ArrayList<HandleFlowModel> handleFlowModels;

    public HandleFlowAdapter(Context context, ArrayList<HandleFlowModel> handleFlowModels) {
        this.context = context;
        this.handleFlowModels = handleFlowModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_handle_flow,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      HandleFlowModel handleFlowModel = handleFlowModels.get(position);
      holder.mNameStaffTv.setText(handleFlowModel.getNameStaff());
      holder.mDutyTv.setText(handleFlowModel.getDuty());
      holder.mDescWorkFlowTv.setText(handleFlowModel.getDescWorkFlow());
      holder.mTimeHandleTv.setText(handleFlowModel.getTimeHandle());

        if (position == (handleFlowModels.size()-1))
            holder.mDecorationTv.setVisibility(View.INVISIBLE);
    }

    public void refreshData(ArrayList<HandleFlowModel> handleFlowModels){
        this.handleFlowModels.clear();
        this.handleFlowModels.addAll(handleFlowModels);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return handleFlowModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mNameStaffTv, mDutyTv, mDescWorkFlowTv, mTimeHandleTv, mDecorationTv;
        public ViewHolder(View itemView) {
            super(itemView);
            mNameStaffTv = itemView.findViewById(R.id.itemhandleflow_tv_namestaff);
            mDutyTv = itemView.findViewById(R.id.itemhandleflow_tv_duty);
            mDescWorkFlowTv = itemView.findViewById(R.id.itemhandleflow_tv_desc_workflow);
            mTimeHandleTv = itemView.findViewById(R.id.itemhandleflow_tv_timehandle);
            mDecorationTv = itemView.findViewById(R.id.itemhandleflow_tv_decorationline);
        }
    }
}
