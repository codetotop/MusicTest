package com.gem.mpi.screen.main.main.foreign_investment_data;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;
import com.gem.mpi.model.ForeignInvestmentDataModel;

import java.util.List;

public class ForeignInvestmentDataAdapter extends BaseQuickAdapter<ForeignInvestmentDataModel, BaseViewHolder> {

  public ForeignInvestmentDataAdapter(@Nullable List<ForeignInvestmentDataModel> data) {
    super(R.layout.item_foreign_investment_data, data);
  }

  @Override
  protected void convert(BaseViewHolder helper, ForeignInvestmentDataModel item) {
    helper.setText(R.id.itemforeigninvestmentdata_tv_month, item.getTitle())

        .setText(R.id.itemforeigninvestmentdata_tv_realized_capital,item.getVonThucHien())

        .setText(R.id.itemforeigninvestmentdata_tv_registered_new,item.getVdkDangKyCapMoi())
        .setText(R.id.itemforeigninvestmentdata_tv_registered_additional,item.getVdkDangKyTangThem())
        .setText(R.id.itemforeigninvestmentdata_tv_registered_capital_contribution_share_purchase,item.getVdkGopVonMuaCoPhan())

        .setText(R.id.itemforeigninvestmentdata_tv_projects_new_level,item.getSdanCapMoi())
        .setText(R.id.itemforeigninvestmentdata_tv_projects_capital_increase,item.getSdanTangVon())
        .setText(R.id.itemforeigninvestmentdata_tv_projects_capital_contribution_share_purchase,item.getSdanGopVon())

        .setText(R.id.itemforeigninvestmentdata_tv_export_inc_cru_oil,item.getXkXuatKhauCaDauTho())
        .setText(R.id.itemforeigninvestmentdata_tv_export_exc_cru_oil,item.getXkXuatKhauKhongDauTho())

        .setText(R.id.itemforeigninvestmentdata_tv_import,item.getNhapKhau());
  }
}
