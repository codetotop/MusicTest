package com.gem.mpi.screen.main.main;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;

import java.util.ArrayList;
import java.util.List;

public class SlideMenuAdaper extends BaseQuickAdapter<MenuItem, BaseViewHolder> {

  public SlideMenuAdaper(@Nullable List<MenuItem> data) {
    super(R.layout.item_slide_menu, data);
    List<MenuItem> listFake = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      listFake.add(new MenuItem());
    }
    setNewData(listFake);
  }

  @Override
  protected void convert(BaseViewHolder helper, MenuItem item) {

  }
}
