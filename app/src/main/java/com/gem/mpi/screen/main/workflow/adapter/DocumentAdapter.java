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
        holder.tvDocumentName.setText(documentName);
        if (position == (documents.size()-1))
            holder.tvDecoration.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return documents.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatarDocument;
        TextView tvDocumentName;
        ImageView imgDownloadDocument;
        TextView tvDecoration;

        public ViewHolder(View itemView) {
            super(itemView);
            tvDocumentName = itemView.findViewById(R.id.tvNameDocument);
            imgAvatarDocument = itemView.findViewById(R.id.imgAvatarDocument);
            imgDownloadDocument = itemView.findViewById(R.id.imgDownloadDocument);
            tvDecoration = itemView.findViewById(R.id.tvDecorationLineIdea);
        }
    }
}
