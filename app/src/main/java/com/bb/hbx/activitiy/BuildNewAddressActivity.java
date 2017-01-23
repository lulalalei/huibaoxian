package com.bb.hbx.activitiy;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuildNewAddressActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.address_layout)
    RelativeLayout address_layout;
    @BindView(R.id.isNormalAddress_iv)
    ImageView isNormalAddress_iv;
    @BindView(R.id.isNormalAddress_layout)
    RelativeLayout isNormalAddress_layout;
    @BindView(R.id.save_tv)
    TextView save_tv;

    boolean isNormalAddress;
    @Override
    public int getLayoutId() {
        return R.layout.activity_build_new_address;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        address_layout.setOnClickListener(this);
        isNormalAddress_layout.setOnClickListener(this);
        save_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.address_layout:
                ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                Call call=service.getAreaList(true);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {

                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {

                    }
                });
                break;
            case R.id.isNormalAddress_layout:
                if (isNormalAddress)
                {
                    isNormalAddress_iv.setSelected(false);
                    isNormalAddress=false;
                }
                else
                {
                    isNormalAddress_iv.setSelected(true);
                    isNormalAddress=true;
                }
                break;
            case R.id.save_tv:
                showTip("保存");
                break;
            default:
                break;
        }
    }
}
