package com.bb.hbx.activitiy;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditInsuredInfoActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.sex_layout)
    RelativeLayout sex_layout;
    @BindView(R.id.birth_layout)
    RelativeLayout birth_layout;
    @BindView(R.id.idType_layout)
    RelativeLayout idType_layout;
    @BindView(R.id.area_layout)
    RelativeLayout area_layout;
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

    String [] itemBuf=new String[4];
    String [] infoBuf=new String[4];

    String name;
    String sex;
    String birth;
    String mobile;
    String idNo;
    String area;
    String email;
    String idType;
    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_insured_info;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        sex_layout.setOnClickListener(this);
        birth_layout.setOnClickListener(this);
        idType_layout.setOnClickListener(this);
        area_layout.setOnClickListener(this);
        verify_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        name_et.setText(MyCustomActivity.insuredInfolBean.getInsuredName());
        sex_et.setText(MyCustomActivity.insuredInfolBean.getGender());
        birth_et.setText(MyCustomActivity.insuredInfolBean.getBirthday());
        phone_et.setText(MyCustomActivity.insuredInfolBean.getMobile());
        idNumber_et.setText(MyCustomActivity.insuredInfolBean.getIdNo());
        area_et.setText(MyCustomActivity.insuredInfolBean.getInsuredAddress());
        address_et.setText("没有字段");
        email_et.setText(MyCustomActivity.insuredInfolBean.getEmail());
        more_et.setText("没有字段");
        switch (MyCustomActivity.insuredInfolBean.getIdType())
        {
            case "1":
                idType_et.setText("身份证");
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.sex_layout:

                break;
            case R.id.birth_layout:

                break;
            case R.id.idType_layout:

                break;
            case R.id.area_layout:

                break;
            case R.id.verify_tv:
                //showTip("保存");
                name = name_et.getText().toString();
                sex = sex_et.getText().toString();
                birth = birth_et.getText().toString();
                mobile = phone_et.getText().toString().trim();
                idNo = idNumber_et.getText().toString().trim();
                area = area_et.getText().toString().trim();
                email = email_et.getText().toString().trim();
                idType = idType_et.getText().toString().trim();

                itemBuf[0]=name;
                itemBuf[1]=mobile;
                itemBuf[2]=idType;
                itemBuf[3]=idNo;
                infoBuf[0]="姓名";
                infoBuf[1]="手机号";
                infoBuf[2]="证件类型";
                infoBuf[3]="证件号码";
                for (int i = 0; i < itemBuf.length; i++) {
                    if (TextUtils.isEmpty(itemBuf[i]))
                    {
                        showTip(infoBuf[i]+"不能为空!");
                        return;
                    }
                }
                ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                Call call=service.updateInsured(MyApplication.user.getUserId(),MyCustomActivity.insuredInfolBean.getInsuredId(),name,
                                    mobile,"1",idNo);
                call.enqueue(new Callback() {
                    @Override
                    public void onResponse(Call call, Response response) {
                        showTip("修改信息成功!");
                        MyCustomActivity.insuredInfolBean.setInsuredName(name);
                        MyCustomActivity.insuredInfolBean.setGender(sex);
                        MyCustomActivity.insuredInfolBean.setBirthday(birth);
                        MyCustomActivity.insuredInfolBean.setBirthday(mobile);
                        MyCustomActivity.insuredInfolBean.setIdNo(idNo);
                        MyCustomActivity.insuredInfolBean.setInsuredAddress(area);
                        MyCustomActivity.insuredInfolBean.setEmail(email);
                        switch (idType)
                        {
                            case "身份证":
                                MyCustomActivity.insuredInfolBean.setIdType("1");
                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call call, Throwable t) {
                        showTip("更新信息失败");
                    }
                });
                break;
            default:
                break;
        }
    }
}
