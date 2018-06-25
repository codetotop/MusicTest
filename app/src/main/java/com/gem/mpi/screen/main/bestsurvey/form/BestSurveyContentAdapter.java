package com.gem.mpi.screen.main.bestsurvey.form;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gem.mpi.R;
import com.gem.mpi.data.dto.SurveyDTO;
import com.gem.mpi.screen.model.SurveyBlockModel;
import com.gem.mpi.util.CommonUtils;
import com.gem.mpi.widget.survey.SurveyFormQuestionView;
import com.gemvietnam.base.adapter.RecyclerBaseAdapter;
import com.gemvietnam.utils.StringUtils;
import com.gemvietnam.widget.BaseViewHolder;

import java.util.List;

import butterknife.BindView;

/**
 * Created by BaVV on 03/20/2018.
 * BestSurveyContentAdapter
 */
public class BestSurveyContentAdapter extends RecyclerBaseAdapter<SurveyBlockModel, BestSurveyContentAdapter.ViewHolder> {

  public BestSurveyContentAdapter(Context context) {
    super(context);
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.item_survey_form_block, parent, false);
    return new ViewHolder(view);
  }

  class ViewHolder extends BaseViewHolder<SurveyBlockModel> {

    @BindView(R.id.tv_item_best_survey_form_block_description)
    TextView mDescriptionTv;
    @BindView(R.id.ll_item_best_survey_form_block_question_list)
    LinearLayout mQuestionsLayout;

    ViewHolder(View itemView) {
      super(itemView);
    }

    @Override
    public void bindView(SurveyBlockModel data, int position) {
      SurveyDTO.SurveyBlock surveyBlock = data.getSurveyBlock();
      if (!StringUtils.isEmpty(surveyBlock.getDescription())) {
        CommonUtils.setTextHtml(mDescriptionTv, surveyBlock.getDescription());
        mDescriptionTv.setVisibility(View.VISIBLE);
      } else {
        mDescriptionTv.setVisibility(View.GONE);
      }
      List<SurveyDTO.Question> questions = surveyBlock.getQuestions();
      if (questions == null || questions.size() == 0) {
        mQuestionsLayout.setVisibility(View.GONE);
      } else {
        mQuestionsLayout.removeAllViews();
        for (int i = 0; i < questions.size(); i++) {
          SurveyDTO.Question question = questions.get(i);
          mQuestionsLayout.addView(new SurveyFormQuestionView(mContext, question, i + 1 + data.getQuestionOffset()));
        }
        mQuestionsLayout.setVisibility(View.VISIBLE);
      }
    }
  }
}

