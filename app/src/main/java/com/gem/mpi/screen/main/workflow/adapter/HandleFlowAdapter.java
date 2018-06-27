package com.gem.mpi.screen.main.workflow.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.workflow.model.HandleFlowModel;

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
      holder.tvNameStaff.setText(handleFlowModel.getNameStaff());
      holder.tvDuty.setText(handleFlowModel.getDuty());
      holder.tvDescWorkFlow.setText(handleFlowModel.getDescWorkFlow());
      holder.tvTimeHandle.setText(handleFlowModel.getTimeHandle());
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
        TextView tvNameStaff,tvDuty,tvDescWorkFlow,tvTimeHandle;
        public ViewHolder(View itemView) {
            super(itemView);
            tvNameStaff = itemView.findViewById(R.id.tvNameStaff);
            tvDuty = itemView.findViewById(R.id.tvDuty);
            tvDescWorkFlow = itemView.findViewById(R.id.tvDescWorkFlow);
            tvTimeHandle = itemView.findViewById(R.id.tvTimeHandle);
        }
    }
}
