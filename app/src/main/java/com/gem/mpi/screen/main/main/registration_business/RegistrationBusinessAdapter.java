package com.gem.mpi.screen.main.main.registration_business;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;

import java.util.ArrayList;
import java.util.List;

public class RegistrationBusinessAdapter extends BaseQuickAdapter<RegistrationBusinessItem, BaseViewHolder> {

  public RegistrationBusinessAdapter(@Nullable List<RegistrationBusinessItem> data) {
    super(R.layout.item_registration_business, data);
    List<RegistrationBusinessItem> fakeList = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      fakeList.add(new RegistrationBusinessItem());
    }
    setNewData(fakeList);
  }

  @Override
  protected void convert(BaseViewHolder helper, RegistrationBusinessItem item) {
    Log.d("Test","abc");
  }
}
