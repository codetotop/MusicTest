package com.gem.mpi.screen.main.main.foreign_investment_data;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;

import java.util.ArrayList;
import java.util.List;

public class ForeignInvestmentDataAdapter extends BaseQuickAdapter<ForeignInvestmentDataItem, BaseViewHolder> {
  public ForeignInvestmentDataAdapter(@Nullable List<ForeignInvestmentDataItem> data) {
    super(R.layout.item_foreign_investment_data, data);
    List<ForeignInvestmentDataItem> listFake = new ArrayList<>();
    for (int i = 0; i < 4; i++) {
      listFake.add(new ForeignInvestmentDataItem());
    }
    setNewData(listFake);
  }

  @Override
  protected void convert(BaseViewHolder helper, ForeignInvestmentDataItem item) {

  }
}
