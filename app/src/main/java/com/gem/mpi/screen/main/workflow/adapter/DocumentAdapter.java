package com.gem.mpi.screen.main.workflow.adapter;

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

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {
    private Context context;
    private ArrayList<String> documents;

    public DocumentAdapter(Context context, ArrayList<String> documents) {
        this.context = context;
        this.documents = documents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.view_document, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String documentName = documents.get(position);
        holder.mDocumentNameTv.setText(documentName);
        if (position == (documents.size()-1))
            holder.mDecorationTv.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mAvatarDocumentImg;
        TextView mDocumentNameTv;
        ImageView mDownloadDocumentImg;
        TextView mDecorationTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mDocumentNameTv = itemView.findViewById(R.id.viewdocument_tv_namedocument);
            mAvatarDocumentImg = itemView.findViewById(R.id.viewdocument_img_avatardocument);
            mDownloadDocumentImg = itemView.findViewById(R.id.viewdocument_img_downloaddocument);
            mDecorationTv = itemView.findViewById(R.id.viewdocument_tv_decorationline);
        }
    }
}
