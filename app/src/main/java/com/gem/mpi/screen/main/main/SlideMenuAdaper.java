package com.gem.mpi.screen.main.main;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;

import java.util.ArrayList;
import java.util.List;

public class SlideMenuAdaper extends BaseQuickAdapter<SlideMenuItem, BaseViewHolder> {

  public SlideMenuAdaper(@Nullable List<SlideMenuItem> data, String[] menuItems) {
    super(R.layout.item_slide_menu, data);
    List<SlideMenuItem> listFake = new ArrayList<>();
    for (int i = 0; i < 6; i++) {
      listFake.add(new SlideMenuItem(i, menuItems[i]));
    }
    setNewData(listFake);
  }

  @Override
  protected void convert(BaseViewHolder helper, SlideMenuItem item) {
    helper.setText(R.id.itemslidemenu_content_tv, item.getContent());
    helper.itemView.setTag(item.getId());
  }
}
