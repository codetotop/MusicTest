package com.gem.mpi.screen.main.home;

import android.os.Bundle;

import com.gem.mpi.data.dto.LocationDTO;
import com.gem.mpi.data.remote.callback.BaseResponse;
import com.gem.mpi.data.remote.callback.CommonCallback;
import com.gem.mpi.event.SettingUpdateEvent;
import com.gem.mpi.mapper.LocationMapper;
import com.gem.mpi.pref.PrefWrapper;
import com.gem.mpi.screen.SubActivity;
import com.gemvietnam.base.viper.Presenter;
import com.gemvietnam.base.viper.interfaces.ContainerView;
import com.gemvietnam.eventbus.EventBusWrapper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * The Home Presenter
 */
public class HomePresenter extends Presenter<HomeContract.View, HomeContract.Interactor>
    implements HomeContract.Presenter {

  private LocationDTO mLocationDTO;

  public HomePresenter(ContainerView containerView) {
    super(containerView);
  }

  @Override
  public HomeContract.View onCreateView(Bundle data) {
    return HomeFragment.getInstance(data);
  }

  @Override
  public void start() {
    mLocationDTO = PrefWrapper.getLocationSetting(getViewContext());
    if (mLocationDTO != null) {
      mView.updateLocationView(LocationMapper.transform(mLocationDTO));
    }
    mView.showProgress();
    getLocationSetting();
  }

  @Override
  public HomeContract.Interactor onCreateInteractor() {
    return new HomeInteractor(this);
  }

  private void getLocationSetting() {
    mInteractor.getLocationSetting(new CommonCallback<LocationDTO>(getViewContext()) {
      @Override
      public void onSuccess(BaseResponse<LocationDTO> responseBody) {
        PrefWrapper.saveLocationSetting(getViewContext(), responseBody.getData());
        EventBusWrapper.post(new SettingUpdateEvent(SettingUpdateEvent.Type.LOCATION));
      }
    });
  }

  @Override
  public void onBestSurveySelected() {
    if (mLocationDTO != null) {
      SubActivity.start(getViewContext(), SubActivity.FirstScreen.SURVEY_LIST);
    }
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onSettingUpdate(SettingUpdateEvent event) {
    if (event.getType() == SettingUpdateEvent.Type.LOCATION) {
      mLocationDTO = PrefWrapper.getLocationSetting(getViewContext());
      if (mLocationDTO != null) {
        mView.updateLocationView(LocationMapper.transform(mLocationDTO));
      }
    }
  }
}
