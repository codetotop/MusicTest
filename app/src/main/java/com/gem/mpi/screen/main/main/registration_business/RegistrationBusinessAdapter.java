package com.gem.mpi.screen.main.main.registration_business;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.gem.mpi.R;
import com.gem.mpi.model.RegistrationBusinessModel;

import java.util.List;

public class RegistrationBusinessAdapter extends BaseQuickAdapter<RegistrationBusinessModel, BaseViewHolder> {

  public RegistrationBusinessAdapter(@Nullable List<RegistrationBusinessModel> data) {
    super(R.layout.item_registration_business, data);
  }

  @Override
  protected void convert(BaseViewHolder helper, RegistrationBusinessModel item) {
    helper.setText(R.id.itemregistrationbusiness_tv_month, item.getTitle())
        .setText(R.id.itemregistrationbusiness_tv_newly, item.getSoDoanhNghiepThanhLapMoi())
        .setText(R.id.itemregistrationbusiness_tv_regis_capital, item.getSoVonDangKy())
        .setText(R.id.itemregistrationbusiness_tv_employees_regis, item.getSoLaoDongDangKy())
        .setText(R.id.itemregistrationbusiness_tv_comple_procedure_dissolution, item.getSoDoanhNghiepHoanTatThuTucGiaiThe())
        .setText(R.id.itemregistrationbusiness_tv_difficulty_temporary_suspension, item.getSoDoanhNghiepGapKhoKhanCoDangKy())
        .setText(R.id.itemregistrationbusiness_tv_comple_returned_operation, item.getSoDoanhNghiepTroLaiHoatDong());
  }
}
