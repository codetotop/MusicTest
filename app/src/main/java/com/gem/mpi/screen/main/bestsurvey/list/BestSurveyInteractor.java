package com.gem.mpi.screen.main.bestsurvey.list;

import com.gem.mpi.data.dto.SurveyListDTO;
import com.gem.mpi.data.remote.ServiceBuilder;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gemvietnam.base.viper.Interactor;

/**
 * The BestSurvey interactor
 */
class BestSurveyInteractor extends Interactor<BestSurveyContract.Presenter>
    implements BestSurveyContract.Interactor {

  BestSurveyInteractor(BestSurveyContract.Presenter presenter) {
    super(presenter);
  }

  @Override
  public void getSurveyList(CommonCallback<SurveyListDTO> callback) {
    ServiceBuilder.getSurveyService().getSurveyList("").enqueue(callback);
  }
}
