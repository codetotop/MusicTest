package com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.screen.main.main.workfollowlist.workfollowdetail.model.DocumentModel;

import java.util.ArrayList;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.ViewHolder> {
  private Context context;
  private ArrayList<DocumentModel> documents;

  public DocumentAdapter(Context context, ArrayList<DocumentModel> documents) {
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
    DocumentModel document = documents.get(position);
    holder.mDocumentNameTv.setText(document.getDocumentName());
    if (document.getImgDocumentAvatar() != null)
      holder.mAvatarDocumentImg.setBackgroundResource(document.getImgDocumentAvatar());
    if (document.getImgDocumentDownload() != null)
      holder.mDownloadDocumentImg.setBackgroundResource(document.getImgDocumentDownload());
    if (position == (documents.size() - 1))
      holder.mDecorationTv.setVisibility(View.INVISIBLE);
//    if (hideIconDownload)
//      holder.mDownloadDocumentImg.setVisibility(View.INVISIBLE);//set hide icon download when ...
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

  public void refreshData(ArrayList<DocumentModel> documents) {
    this.documents.clear();
    this.documents.addAll(documents);
    notifyDataSetChanged();
  }


}
