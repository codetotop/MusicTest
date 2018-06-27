package com.gem.mpi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DocumentView extends ConstraintLayout{
    @BindView(R.id.imgAvatarDocument)
    ImageView imgAvatarDocument;
    @BindView(R.id.tvNameDocument)
    TextView tvNameDocument;
    @BindView(R.id.imgDownloadDocument)
    ImageView imgDownloadDocument;
    public DocumentView(Context context) {
        super(context);
        init(null,0);
    }

    public DocumentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs,0);

    }

    public DocumentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,defStyleAttr);

    }

    private void init(AttributeSet attributeSet,int defStyleAttr){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_document,this,true);
        ButterKnife.bind(this);

        TypedArray input = getContext().obtainStyledAttributes(attributeSet, R.styleable.DocumentView,0,0);
        Drawable drawableAvatar = input.getDrawable(R.styleable.DocumentView_imgavatardocument_backgound);
        setAvatarDocument(drawableAvatar);

        String namedocument = input.getString(R.styleable.DocumentView_tvnamedocument_name);
        setDocumentName(namedocument);
        Drawable drawableDownload = input.getDrawable(R.styleable.DocumentView_imgdownloaddocument_backgound);
        setDownloadDocument(drawableDownload);

        input.recycle();
    }

    public void setAvatarDocument(Drawable drawable){
        imgAvatarDocument.setImageDrawable(drawable);
    }

    public void setDocumentName(String name){
        tvNameDocument.setText(name);
    }

    public String getDocumentName(){
        return tvNameDocument.getText().toString();
    }

    public void setDownloadDocument(Drawable drawable){
        imgDownloadDocument.setImageDrawable(drawable);
    }

    public void setDownloadDocumentVisibility(boolean bool){
        if(bool)
            imgDownloadDocument.setVisibility(VISIBLE);
        else
            imgDownloadDocument.setVisibility(INVISIBLE);
    }


}
