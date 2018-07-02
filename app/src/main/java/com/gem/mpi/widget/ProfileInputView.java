package com.gem.mpi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileInputView extends ConstraintLayout {

  @BindView(R.id.viewprofileinput_tv_title)
  TextView mTitleTv;
  @BindView(R.id.viewprofileinput_et_content)
  EditText mContentEt;
  @BindView(R.id.viewprofileinput_iv_content_drawable_right)
  ImageView mContentDrawableRight;

  public ProfileInputView(Context context) {
    super(context);
    init(null, 0);
  }

  public ProfileInputView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public ProfileInputView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr);
  }

  private void init(AttributeSet attrs, int defStyleAttr) {
    LayoutInflater.from(getContext()).inflate(R.layout.view_profile_input, this, true);
    ButterKnife.bind(this);

    TypedArray input = getContext().obtainStyledAttributes(attrs, R.styleable.ProfileInputView, 0, 0);

    String title = input.getString(R.styleable.ProfileInputView_profileinputview_title);
    setTitle(title);

    String content = input.getString(R.styleable.ProfileInputView_profileinputview_content);
    setContent(content);

    String contentHint = input.getString(R.styleable.ProfileInputView_profileinputview_content_hint);
    setContentHint(contentHint);

    boolean contentFocusable = input.getBoolean(R.styleable.ProfileInputView_profileinputview_content_focusable, true);
    setContentFocusable(contentFocusable);

    Drawable contentDrawableRight = input.getDrawable(R.styleable.ProfileInputView_profileinputview_content_drawable_right);
    setContentDrawableRight(contentDrawableRight);

    boolean contentDrawableRightShow = input.getBoolean(R.styleable.ProfileInputView_profileinputview_content_drawable_right_show, false);
    setContentDrawableRightShow(contentDrawableRightShow);

    // Init listener
    mContentEt.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mOnContentListener != null) {
          mOnContentListener.onContentClick();
        }
      }
    });

    input.recycle();
  }


  public void setTitle(String title) {
    mTitleTv.setText(title);
  }

  public String getTitle() {
    return mTitleTv.getText().toString();
  }

  public void setContent(String content) {
    mContentEt.setText(content);
  }

  public String getContent() {
    return mContentEt.getText().toString();
  }

  public void setContentHint(String contentHint) {
    mContentEt.setHint(contentHint);
  }

  public String getContentHint() {
    return mContentEt.getHint().toString();
  }

  public void setContentFocusable(boolean contentFocusable) {
    mContentEt.setFocusable(contentFocusable);
  }

  public boolean getContentFocusable() {
    return mContentEt.isFocusable();
  }

  public void setContentDrawableRight(Drawable drawableRight) {
    mContentDrawableRight.setImageDrawable(drawableRight);
  }

  public Drawable getContentDrawableRight() {
    return mContentDrawableRight.getDrawable();
  }

  public void setContentDrawableRightShow(boolean contentDrawableRightShow) {
    if (contentDrawableRightShow) {
      mContentEt.setPadding((int) (getResources().getDimension(R.dimen.tiny_padding)),
          (int) (getResources().getDimension(R.dimen.tiny_padding)),
          (int) (getResources().getDimension(R.dimen.large_padding)),
          (int) (getResources().getDimension(R.dimen.tiny_padding))
      );
      mContentDrawableRight.setVisibility(VISIBLE);
    } else {
      mContentEt.setPadding((int) (getResources().getDimension(R.dimen.tiny_padding)),
          (int) (getResources().getDimension(R.dimen.tiny_padding)),
          (int) (getResources().getDimension(R.dimen.tiny_padding)),
          (int) (getResources().getDimension(R.dimen.tiny_padding))
      );
      mContentDrawableRight.setVisibility(GONE);
    }
  }

  public void setOnContentListener(OnContentListener onContentListener) {
    this.mOnContentListener = onContentListener;
  }

  private OnContentListener mOnContentListener;

  public interface OnContentListener {
    void onContentClick();
  }
}
