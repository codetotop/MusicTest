package com.gem.mpi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.util.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FormInputView extends ConstraintLayout implements View.OnFocusChangeListener {
    @BindView(R.id.viewforminput_tv_label)
    TextView mLabeltv;
    @BindView(R.id.viewforminput_edt_value)
    EditText mValueEdt;
    @BindView(R.id.viewforminput_img_event)
    ImageView mEventImg;

    public FormInputView(Context context) {
        super(context);
        init(null, 0);
    }

    public FormInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public FormInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attributeSet, int defStyleAttr) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_form_input, this, true);
        ButterKnife.bind(this);

        TypedArray input = getContext().obtainStyledAttributes(attributeSet, R.styleable.FormInputView, defStyleAttr, 0);
        final String title = input.getString(R.styleable.FormInputView_tvlabel_name);
        mLabeltv.setText(title);
        Drawable drawable = input.getDrawable(R.styleable.FormInputView_imgevent_source);
        mEventImg.setImageDrawable(drawable);
       setVisibilityEvent(false);
       setInputType(InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        mValueEdt.setOnFocusChangeListener(this);
        mEventImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getTag().equals(Constants.LOGIN_ACTION_DELETE)) {
                    setText("");
                } else if (view.getTag().equals(Constants.LOGIN_ACTION_VIEW)) {
                    setInputType(InputType.TYPE_CLASS_NUMBER);
                    setAction(Constants.LOGIN_ACTION_UNVIEW);
                    setEventImg(getResources().getDrawable(R.drawable.ic_view));
                } else if (view.getTag().equals(Constants.LOGIN_ACTION_UNVIEW)) {
                    setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                    setAction(Constants.LOGIN_ACTION_VIEW);
                    setEventImg(getResources().getDrawable(R.drawable.ic_un_view));
                }
            }
        });

        input.recycle();
    }

    public String getLabel() {
        return mLabeltv.getText().toString();
    }

    public void setLabel(String label) {
        this.mLabeltv.setText(label);
    }

    public String getText() {
        return mValueEdt.getText().toString();
    }

    public void setText(String edtValue) {
        this.mValueEdt.setText(edtValue);
    }

    public void setInputType(int inputType) {
        this.mValueEdt.setInputType(inputType);
    }

    public void setAction(String action) {
        this.mEventImg.setTag(action);
    }

    public void setEventImg(Drawable drawable) {
        this.mEventImg.setImageDrawable(drawable);
    }

    public void setVisibilityEvent(Boolean bool) {
        if (bool)
            mEventImg.setVisibility(VISIBLE);
        else
            mEventImg.setVisibility(INVISIBLE);
    }

    @Override
    public void onFocusChange(View view, boolean b) {
            setVisibilityEvent(b);
    }
}
