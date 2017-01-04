package com.bb.hbx.activitiy;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

public class PersonInfoSettingActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.userIcon_civ)
    CircleImageView userIcon_civ;

    @BindView(R.id.userIcon_layout)
    RelativeLayout userIcon_layout;
    @BindView(R.id.name_layout)
    RelativeLayout name_layout;
    @BindView(R.id.sex_layout)
    RelativeLayout sex_layout;
    @BindView(R.id.address_layout)
    RelativeLayout address_layout;
    @BindView(R.id.countSafe_layout)
    RelativeLayout countSafe_layout;

    TextView camera_tv;
    TextView mapstorage_tv;
    @Override
    public int getLayoutId() {
        return R.layout.activity_person_info_setting;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initListener() {
        userIcon_layout.setOnClickListener(this);
        name_layout.setOnClickListener(this);
        sex_layout.setOnClickListener(this);
        address_layout.setOnClickListener(this);
        countSafe_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
            case R.id.userIcon_layout:
                View view = LayoutInflater.from(this).inflate(R.layout.layout_change_usericon, null);
                camera_tv = (TextView) view.findViewById(R.id.camera_tv);
                mapstorage_tv = (TextView) view.findViewById(R.id.mapstorage_tv);
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("请选择:");
                builder.setView(view);
                final AlertDialog dialog = builder.create();
                dialog.show();
                camera_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PersonInfoSettingActivity.this,"相机",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(intent,101);
                        dialog.dismiss();
                    }
                });
                mapstorage_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(PersonInfoSettingActivity.this,"图库",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_PICK);
                        startActivityForResult(intent,102);
                        dialog.dismiss();
                    }
                });
                break;
            case R.id.name_layout:
                intent.setClass(PersonInfoSettingActivity.this,EditNameActivity.class);
                startActivity(intent);
                break;
            case R.id.sex_layout:
                intent.setClass(PersonInfoSettingActivity.this,SexActivity.class);
                startActivity(intent);
                break;
            case R.id.address_layout:
                intent.setClass(PersonInfoSettingActivity.this,AddressManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.countSafe_layout:
                Toast.makeText(PersonInfoSettingActivity.this,"点击",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //打开系统图库请求
        if (requestCode==102)
        {
            if (resultCode==RESULT_OK)
            {
            if (data!=null)
                {
                    Uri uri = data.getData();

                }
            }
        }
    }
}
