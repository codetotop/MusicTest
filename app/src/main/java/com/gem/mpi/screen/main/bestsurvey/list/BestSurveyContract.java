package com.gem.mpi.screen.main.bestsurvey.list;

import com.gem.mpi.data.dto.SurveyDTO;
import com.gem.mpi.data.dto.SurveyListDTO;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.model.LocationModel;
import com.gemvietnam.base.viper.interfaces.IInteractor;
import com.gemvietnam.base.viper.interfaces.IPresenter;
import com.gemvietnam.base.viper.interfaces.PresentView;

import java.util.List;

/**
 * The BestSurvey Contract
 */
interface BestSurveyContract {

  interface Interactor extends IInteractor<Presenter> {
    void getSurveyList(CommonCallback<SurveyListDTO> callback);
  }

  interface View extends PresentView<Presenter> {
    void updateLocationView(LocationModel locationSetting);

    void bindData(List<SurveyDTO> surveyList);
  }

  interface Presenter extends IPresenter<View, Interactor> {
    void openSurveyForm(SurveyDTO item);

    void searchSurveyTitle(String s);
  }
}