package com.gem.mpi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gem on 6/22/18.
 */

public class ToolbarView extends ConstraintLayout implements View.OnClickListener {

  @BindView(R.id.viewtoolbar_iv_action_left)
  ImageView mActionLeftIv;
  @BindView(R.id.viewtoolbar_tv_action_left)
  TextView mActionLeftTv;
  @BindView(R.id.viewtoolbar_iv_action_right)
  ImageView mActionRightIv;
  @BindView(R.id.viewtoolbar_tv_action_right)
  TextView mActionRightTv;
  @BindView(R.id.viewtoolbar_tv_title)
  TextView mTitleTv;

  OnActionLeftListener mOnActionLeftListener;
  OnActionRightListener mOnActionRightListener;

  public ToolbarView(Context context) {
    super(context);
    init(null, 0);
  }

  public ToolbarView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public ToolbarView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr);
  }

  private void init(AttributeSet attrs, int defStyleAttr) {
    LayoutInflater.from(getContext()).inflate(R.layout.view_toolbar, this, true);
    ButterKnife.bind(this);
    TypedArray input = getContext().obtainStyledAttributes(attrs, R.styleable.ToolbarView, 0, 0);

    mActionLeftIv.setOnClickListener(this);
    mActionRightIv.setOnClickListener(this);
    mActionRightTv.setOnClickListener(this);

    input.recycle();
  }

  public void init(ActionStyle actionLeftStyle, ActionStyle actionRightStyle, Integer titleId,
                   Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId,
                   OnActionLeftListener onActionLeftListener, OnActionRightListener onActionRightListener) {
    setTitle(titleId);
    initActionStyle(actionLeftStyle, actionRightStyle);
    initActionContent(actionLeftDrawbleId, actionLeftStringId, actionRightDrawableId, actionRightStringId);
    initListener(onActionLeftListener, onActionRightListener);
  }

  public void initActionStyle(ActionStyle actionLeftStyle, ActionStyle actionRightStyle) {
    resetView();

    switch (actionLeftStyle) {
      case NONE:
        break;
      case TEXT:
        setTextActionLeftVisibility(VISIBLE);
        break;
      case IMAGE:
        setImageActionLeftVisibility(VISIBLE);
        break;
      default:
        break;
    }

    switch (actionRightStyle) {
      case NONE:
        break;
      case TEXT:
        setTextActionRightVisibility(VISIBLE);
        break;
      case IMAGE:
        setImageActionRightVisibility(VISIBLE);
        break;
      default:
        break;
    }
  }

  public void initActionContent(Integer actionLeftDrawbleId, Integer actionLeftStringId, Integer actionRightDrawableId, Integer actionRightStringId) {
    setImageActionLeft(actionLeftDrawbleId);
    setTextActionLeft(actionLeftStringId);
    setImageActionRight(actionRightDrawableId);
    setTextActionRight(actionRightStringId);
  }

  public void initListener(OnActionLeftListener onActionLeftListener, OnActionRightListener onActionRightListener) {
    setOnActionLeftListener(onActionLeftListener);
    setOnActionRightListener(onActionRightListener);
  }

  private void resetView() {
    setImageActionLeftVisibility(View.INVISIBLE);
    setTextActionLeftVisibility(View.GONE);
    setImageActionRightVisibility(View.INVISIBLE);
    setTextActionRightVisibility(View.GONE);
  }

  public void setImageActionLeft(Drawable drawable) {
    mActionLeftIv.setImageDrawable(drawable);
  }

  public void setImageActionLeft(Integer idRes) {
    if (idRes != null) {
      mActionLeftIv.setImageResource(idRes);
    }
  }

  public void setTextActionLeft(String action) {
    mActionLeftTv.setText(action);
  }

  public void setTextActionLeft(Integer actionLeftStringId) {
    if (actionLeftStringId != null) {
      mActionLeftTv.setText(getResources().getString(actionLeftStringId));
    }
  }

  public String getTextActionLeft() {
    return mActionLeftTv.getText().toString();
  }

  public void setImageActionRight(Drawable drawable) {
    mActionRightIv.setImageDrawable(drawable);
  }

  public void setImageActionRight(Integer idRes) {
    if (idRes != null) {
      mActionRightIv.setImageResource(idRes);
    }
  }

  public void setTextActionRight(String action) {
    mActionRightTv.setText(action);
  }

  public void setTextActionRight(Integer actionRightStringId) {
    if (actionRightStringId != null) {
      mActionRightTv.setText(getResources().getString(actionRightStringId));
    }
  }

  public String getTextActionRight() {
    return mActionRightTv.getText().toString();
  }

  public void setTitle(String title) {
    mTitleTv.setText(title);
  }

  public void setTitle(Integer idRes) {
    if (idRes != null) {
      mTitleTv.setText(getResources().getString(idRes));
    }
  }

  public String getTitle() {
    return mTitleTv.getText().toString();
  }

  public void setTextActionLeftVisibility(int visibility) {
    mActionLeftTv.setVisibility(visibility);
  }

  public void setImageActionLeftVisibility(int visibility) {
    mActionLeftIv.setVisibility(visibility);
  }

  public void setTextActionRightVisibility(int visibility) {
    mActionRightTv.setVisibility(visibility);
  }

  public void setImageActionRightVisibility(int visibility) {
    mActionRightIv.setVisibility(visibility);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.viewtoolbar_iv_action_left:
      case R.id.viewtoolbar_tv_action_left:
        if (mOnActionLeftListener != null) {
          mOnActionLeftListener.onActionLeftClick();
        }
        break;
      case R.id.viewtoolbar_iv_action_right:
      case R.id.viewtoolbar_tv_action_right:
        if (mOnActionRightListener != null) {
          mOnActionRightListener.onActionRightClick();
        }
        break;
      default:
        break;
    }
  }

  public void setOnActionLeftListener(OnActionLeftListener onActionLeftListener) {
    if (onActionLeftListener != null) {
      this.mOnActionLeftListener = onActionLeftListener;
    }
  }

  public void setOnActionRightListener(OnActionRightListener onActionRightListener) {
    if (onActionRightListener != null) {
      this.mOnActionRightListener = onActionRightListener;
    }
  }

  public interface OnActionLeftListener {
    void onActionLeftClick();
  }

  public interface OnActionRightListener {
    void onActionRightClick();
  }

  public enum ActionStyle {
    IMAGE, TEXT, NONE
  }
}
