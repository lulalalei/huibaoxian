package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.smarttop.library.bean.City;
import com.smarttop.library.bean.County;
import com.smarttop.library.bean.Province;
import com.smarttop.library.bean.Street;
import com.smarttop.library.utils.LogUtil;
import com.smarttop.library.widget.AddressSelector;
import com.smarttop.library.widget.BottomDialog;
import com.smarttop.library.widget.OnAddressSelectedListener;

import butterknife.BindView;

public class ModifyAddressActivity extends BaseActivity implements View.OnClickListener,OnAddressSelectedListener,AddressSelector.OnDialogCloseListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.address_layout)
    RelativeLayout address_layout;
    @BindView(R.id.isNormalAddress_iv)
    ImageView isNormalAddress_iv;
    @BindView(R.id.isNormalAddress_layout)
    RelativeLayout isNormalAddress_layout;
    @BindView(R.id.name_et)
    EditText name_et;
    @BindView(R.id.phone_et)
    EditText phone_et;
    @BindView(R.id.post_et)
    EditText post_et;
    @BindView(R.id.street_et)
    EditText street_et;
    @BindView(R.id.address_tv)
    TextView address_tv;
    @BindView(R.id.save_tv)
    TextView save_tv;

    private BottomDialog dialog;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private String streetCode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_modify_address;
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
        Intent intent = getIntent();
        String cneeName = intent.getStringExtra("cneeName");
        String mobile = intent.getStringExtra("mobile");
        String areaCode = intent.getStringExtra("areaCode");
        String city = intent.getStringExtra("city");
        String address = intent.getStringExtra("address");
        String defaultFlag = intent.getStringExtra("defaultFlag");
        String userId = intent.getStringExtra("userId");
        String cneeId = intent.getStringExtra("cneeId");
        name_et.setText(cneeName);
        phone_et.setText(mobile);
        post_et.setText(areaCode);
        address_tv.setText(city);
        address_tv.setTextColor(getResources().getColor(R.color.A3));
        street_et.setText(address);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.address_layout:
                //showTip("address_layout");
                if (dialog != null) {
                    dialog.show();
                } else {
                    dialog = new BottomDialog(this);
                    dialog.setOnAddressSelectedListener(this);
                    dialog.setDialogDismisListener(this);
                    dialog.setTextSize(14);//设置字体的大小
                    dialog.setIndicatorBackgroundColor(android.R.color.holo_orange_light);//设置指示器的颜色
                    dialog.setTextSelectedColor(android.R.color.holo_orange_light);//设置字体获得焦点的颜色
                    dialog.setTextUnSelectedColor(android.R.color.holo_blue_light);//设置字体没有获得焦点的颜色
                    dialog.show();
                }
                break;
            case R.id.isNormalAddress_layout:
                showTip("isNormalAddress_layout");
                break;
            case R.id.save_tv:
                showTip("保存");
                break;
            default:
                break;
        }
    }

    @Override
    public void dialogclose() {
        if(dialog!=null){
            dialog.dismiss();
        }
    }

    @Override
    public void onAddressSelected(Province province, City city, County county, Street street) {
        provinceCode = (province == null ? "" : province.code);
        cityCode = (city == null ? "" : city.code);
        countyCode = (county == null ? "" : county.code);
        streetCode = (street == null ? "" : street.code);
        LogUtil.d("数据", "省份id=" + provinceCode);
        LogUtil.d("数据", "城市id=" + cityCode);
        LogUtil.d("数据", "乡镇id=" + countyCode);
        LogUtil.d("数据", "街道id=" + streetCode);
        String s = (province == null ? "" : province.name) + (city == null ? "" : city.name) + (county == null ? "" : county.name) +
                (street == null ? "" : street.name);
        //address=s;
        //areaId=city.id+"";
        address_tv.setText(s);
        address_tv.setTextColor(getResources().getColor(R.color.A3));
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
