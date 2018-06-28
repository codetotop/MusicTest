package com.gem.mpi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gem.mpi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileInformationView extends LinearLayout {

  @BindView(R.id.viewprofileinformation_tv_title)
  TextView mTitleTv;
  @BindView(R.id.viewprofileinformation_tv_content)
  TextView mContentTv;

  public ProfileInformationView(Context context) {
    super(context);
    init(null, 0);
  }

  public ProfileInformationView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public ProfileInformationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr);
  }

  private void init(AttributeSet attrs, int defStyleAttr) {
    LayoutInflater.from(getContext()).inflate(R.layout.view_profile_information, this, true);
    ButterKnife.bind(this);

    TypedArray input = getContext().obtainStyledAttributes(attrs, R.styleable.ProfileInformationView, 0, 0);

    String title = input.getString(R.styleable.ProfileInformationView_profileinformation_title);
    setTitle(title);

    String content = input.getString(R.styleable.ProfileInformationView_profileinformation_content);
    setContent(content);

    input.recycle();
  }

  public void setTitle(String title) {
    mTitleTv.setText(title);
  }

  public String getTitle() {
    return mTitleTv.getText().toString();
  }

  public void setContent(String content) {
    mContentTv.setText(content);
  }

  public String getContent() {
    return mContentTv.getText().toString();
  }
}
