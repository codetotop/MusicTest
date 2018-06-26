package com.gem.mpi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

public class ProfileView extends ConstraintLayout {

  @BindView(R.id.viewprofile_iv_avatar) ImageView mAvatarIv;
  @BindView(R.id.viewprofile_tv_name) TextView mNameTv;
  @BindView(R.id.viewprofile_tv_duty) TextView mDutyTv;
  @BindView(R.id.viewprofile_tv_department) TextView mDepartment;
  @BindView(R.id.viewprofile_iv_action) ImageView mAction;
  OnActionListener mOnActionListener;

  public ProfileView(Context context) {
    super(context);
    init(null, 0);
  }

  public ProfileView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(attrs, 0);
  }

  public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(attrs, defStyleAttr);
  }

  private void init(AttributeSet attrs, int defStyleAttr) {
    LayoutInflater.from(getContext()).inflate(R.layout.view_profile, this, true);
    ButterKnife.bind(this);

    TypedArray input = getContext().obtainStyledAttributes(attrs, R.styleable.ProfileView, 0, 0);

    if (input.hasValue(R.styleable.ProfileView_profileview_avatar)) {
      Drawable avatar = input.getDrawable(R.styleable.ProfileView_profileview_avatar);
      setAvatar(avatar);
    } else {
      Drawable avatar = new ColorDrawable(Color.GRAY);
      setAvatar(avatar);
    }

    String name = input.getString(R.styleable.ProfileView_profileview_name);
    setName(name);

    String duty = input.getString(R.styleable.ProfileView_profileview_duty);
    setDuty(duty);

    String department = input.getString(R.styleable.ProfileView_profileview_department);
    setDepartment(department);

    int actionVisibility = input.getInt(R.styleable.ProfileView_profileview_action_visibility, 0);
    setActionVisibility(Visibility.getVisibility(actionVisibility).getValue());

    // Listener
    mAction.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mOnActionListener != null) {
          mOnActionListener.onActionClick();
        }
      }
    });

    input.recycle();
  }

  public void setAvatar(Drawable avatar) {
    mAvatarIv.setImageDrawable(avatar);
  }

  public Drawable getAvatar() {
    return mAvatarIv.getDrawable();
  }

  public void setName(String name) {
    mNameTv.setText(name);
  }

  public String getName() {
    return mNameTv.getText().toString();
  }

  public void setDuty(String duty) {
    mDutyTv.setText(duty);
  }

  public String getDuty() {
    return mDutyTv.getText().toString();
  }

  public void setDepartment(String department) {
    mDepartment.setText(department);
  }

  public String getDepartment() {
    return mDepartment.getText().toString();
  }

  public void setActionVisibility(int visibility) {
    mAction.setVisibility(visibility);
  }

  public int getActionVisibility() {
    return mAction.getVisibility();
  }

  public void setOnActionListener(OnActionListener onActionListener) {
    mOnActionListener = onActionListener;
  }

  public interface OnActionListener {
    void onActionClick();
  }


  public enum Visibility {
    VISIBLE(0, View.VISIBLE), INVISIBLE(1, View.INVISIBLE), GONE(2, View.GONE);
    int input;
    int value;

    Visibility(int input, int value) {
      this.input = input;
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    public static Visibility getVisibility(int input) {
      for (Visibility visibility : values()) {
        if (visibility.input == input) {
          return visibility;
        }
      }
      return VISIBLE;
    }
  }
}
