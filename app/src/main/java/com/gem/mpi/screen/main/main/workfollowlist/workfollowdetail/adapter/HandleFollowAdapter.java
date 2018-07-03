package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.HandleFollowModel;

import java.util.ArrayList;

public class HandleFollowAdapter extends RecyclerView.Adapter<HandleFollowAdapter.ViewHolder>{
    private Context context;
    private ArrayList<HandleFollowModel> handleFollowModels;

    public HandleFollowAdapter(Context context, ArrayList<HandleFollowModel> handleFollowModels) {
        this.context = context;
        this.handleFollowModels = handleFollowModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_handle_follow,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      HandleFollowModel handleFollowModel = handleFollowModels.get(position);
      holder.mNameStaffTv.setText(handleFollowModel.getNameStaff());
      holder.mDutyTv.setText(handleFollowModel.getDuty());
      holder.mDescWorkFlowTv.setText(handleFollowModel.getDescWorkFlow());
      holder.mTimeHandleTv.setText(handleFollowModel.getTimeHandle());

        if (position == (handleFollowModels.size()-1))
            holder.mDecorationTv.setVisibility(View.INVISIBLE);
    }

    public void refreshData(ArrayList<HandleFollowModel> handleFollowModels){
        this.handleFollowModels.clear();
        this.handleFollowModels.addAll(handleFollowModels);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return handleFollowModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mNameStaffTv, mDutyTv, mDescWorkFlowTv, mTimeHandleTv, mDecorationTv;
        public ViewHolder(View itemView) {
            super(itemView);
            mNameStaffTv = itemView.findViewById(R.id.itemhandlefollow_tv_namestaff);
            mDutyTv = itemView.findViewById(R.id.itemhandlefollow_tv_duty);
            mDescWorkFlowTv = itemView.findViewById(R.id.itemhandlefollow_tv_desc_workfollow);
            mTimeHandleTv = itemView.findViewById(R.id.itemhandlefollow_tv_timehandle);
            mDecorationTv = itemView.findViewById(R.id.itemhandlefollow_tv_decorationline);
        }
    }
}
