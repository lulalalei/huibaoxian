package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;

public class AddBankCardActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.warn_iv)
    ImageView warn_iv;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_bank_card;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {

    }

    public void backMethod(View view) {
        finish();
    }

    public void showWarnMethod(View view) {
        Toast.makeText(this,"警告信息",Toast.LENGTH_SHORT).show();
    }

    public void choseBankMethod(View view) {
        Toast.makeText(this,"选择银行",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }

}
