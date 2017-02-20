package com.bb.hbx.activitiy;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.DatePickerDialog;
import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.AddInsured;
import com.bb.hbx.utils.GetPhoneContactsUtil;
import com.smarttop.library.bean.City;
import com.smarttop.library.bean.County;
import com.smarttop.library.bean.Province;
import com.smarttop.library.bean.Street;
import com.smarttop.library.utils.LogUtil;
import com.smarttop.library.widget.AddressSelector;
import com.smarttop.library.widget.BottomDialog;
import com.smarttop.library.widget.OnAddressSelectedListener;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddContactActivity extends BaseActivity implements View.OnClickListener,OnAddressSelectedListener,AddressSelector.OnDialogCloseListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.birth_layout)
    RelativeLayout birth_layout;
    @BindView(R.id.area_layout)
    RelativeLayout area_layout;
    @BindView(R.id.fromContacts_tv)
    TextView fromContacts_tv;
    @BindView(R.id.name_et)
    EditText name_et;
    @BindView(R.id.sex_et)
    EditText sex_et;
    @BindView(R.id.birth_et)
    EditText birth_et;
    @BindView(R.id.phone_et)
    EditText phone_et;
    @BindView(R.id.idType_et)
    EditText idType_et;
    @BindView(R.id.idNumber_et)
    EditText idNumber_et;
    @BindView(R.id.area_et)
    EditText area_et;
    @BindView(R.id.address_et)
    EditText address_et;
    @BindView(R.id.email_et)
    EditText email_et;
    @BindView(R.id.more_et)
    EditText more_et;
    @BindView(R.id.verify_tv)
    TextView verify_tv;

    private BottomDialog dialogAddress;
    private String provinceCode;
    private String cityCode;
    private String countyCode;
    private String streetCode;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_contact;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String phone = intent.getStringExtra("phone");
        if (!TextUtils.isEmpty(name))
        {
            name_et.setText(name);
        }
        if (!TextUtils.isEmpty(phone))
        {
            phone_et.setText(phone);
        }
    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        birth_layout.setOnClickListener(this);
        fromContacts_tv.setOnClickListener(this);
        area_layout.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
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
            case R.id.fromContacts_tv:
                //showTip("从联系人导入");
                Uri uri = ContactsContract.Contacts.CONTENT_URI;
                Intent intent = new Intent(Intent.ACTION_PICK,uri);
                startActivityForResult(intent,0);
                break;
            case R.id.birth_layout:
                DatePickerDialog dialog = new DatePickerDialog(mContext);
                dialog.setDialogMode(DatePickerDialog.DIALOG_MODE_BOTTOM);
                dialog.show();
                dialog.setDatePickListener(new DatePickerDialog.OnDatePickListener() {
                    @Override
                    public void onClick(String year, String month, String day) {
                        birth_et.setText(year + "-" + month + "-" + day);
                    }

                    @Override
                    public void ondissmiss() {
                        //il_up3.setdownImageResource();
                    }
                });
                break;
            case R.id.area_layout:
                if (dialogAddress != null) {
                    dialogAddress.show();
                } else {
                    dialogAddress = new BottomDialog(this);
                    dialogAddress.setOnAddressSelectedListener(this);
                    dialogAddress.setDialogDismisListener(this);
                    dialogAddress.setTextSize(14);//设置字体的大小
                    dialogAddress.setIndicatorBackgroundColor(android.R.color.holo_orange_light);//设置指示器的颜色
                    dialogAddress.setTextSelectedColor(android.R.color.holo_orange_light);//设置字体获得焦点的颜色
                    dialogAddress.setTextUnSelectedColor(android.R.color.holo_blue_light);//设置字体没有获得焦点的颜色
                    dialogAddress.show();
                }
                break;
            case R.id.verify_tv:
                String name = name_et.getText().toString();
                String phone = phone_et.getText().toString().trim();
                String idType = idType_et.getText().toString();
                String idNumber = idNumber_et.getText().toString();
                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(phone)/*&&!TextUtils.isEmpty(idType)*/&&!TextUtils.isEmpty(idNumber))
                {
                    ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                    Call call=service.addInsured(MyApplication.user.getUserId(),name,phone,"1",idNumber);
                    call.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            Result_Api body = (Result_Api) response.body();
                            AddInsured addInsured = (AddInsured) body.getOutput();
                            showTip("添加联系人成功!");
                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            showTip("新增联系人失败,改用户已添加");
                        }
                    });
                }
                else
                {
                    showTip("用户名,手机号,证件类型和证件号码不能为空!");
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 0:
                if(data==null)
                {
                    return;
                }
                //处理返回的data,获取选择的联系人信息
                Uri uri=data.getData();
                String[] contacts= GetPhoneContactsUtil.getPhoneContacts(this,uri);
                name_et.setText(contacts[0]);
                phone_et.setText(contacts[1]);
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void dialogclose() {
        if(dialogAddress!=null){
            dialogAddress.dismiss();
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
        /*address_tv.setText(s);
        address_tv.setTextColor(getResources().getColor(R.color.A3));*/
        area_et.setText(s);
        if (dialogAddress != null) {
            dialogAddress.dismiss();
        }
    }
}
