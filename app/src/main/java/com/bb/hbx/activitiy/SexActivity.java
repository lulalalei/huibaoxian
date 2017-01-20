package com.bb.hbx.activitiy;

import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.utils.MyUsersSqlite;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SexActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;
    @BindView(R.id.boy_layout)
    RelativeLayout boy_layout;
    @BindView(R.id.girl_layout)
    RelativeLayout girl_layout;
    @BindView(R.id.save_tv)
    TextView save_tv;
    @BindView(R.id.boy_iv)
    ImageView boy_iv;
    @BindView(R.id.girl_iv)
    ImageView girl_iv;

    String userId;
    String gender;

    String sex;
    @Override
    public int getLayoutId() {
        return R.layout.activity_sex;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        save_tv.setOnClickListener(this);
        back_layout.setOnClickListener(this);
        boy_layout.setOnClickListener(this);
        girl_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where currentUser = ?", new String[]{"currentUser"});
        if (cursor!=null)
        {
            if (cursor.moveToNext())
            {
                userId = cursor.getString(cursor.getColumnIndex("userId"));
                gender = cursor.getString(cursor.getColumnIndex("gender"));
                if (gender==null||gender.equals("0"))//表示为男
                {
                    boy_iv.setImageResource(R.drawable.check);
                    girl_iv.setImageBitmap(null);
                }
                else
                {
                    girl_iv.setImageResource(R.drawable.check);
                    boy_iv.setImageBitmap(null);
                }
            }
            else
            {
                Toast.makeText(mContext,"cursor下一条不存在",Toast.LENGTH_SHORT);
            }
        }
        else
        {
            Toast.makeText(mContext,"cursor为空",Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.save_tv:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("是否确认更改用性别");
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        updateGender(gender);
                    }
                });
                dialog.setNegativeButton("取消",null);
                dialog.show();
                break;
            case R.id.boy_layout:
                boy_iv.setImageResource(R.drawable.check);
                girl_iv.setImageBitmap(null);
                gender="0";
                break;
            case R.id.girl_layout:
                girl_iv.setImageResource(R.drawable.check);
                boy_iv.setImageBitmap(null);
                gender="1";
                break;
            default:
                break;
        }
    }

    public void updateGender(final String gender)
    {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.updateUserInfoSex(userId,gender);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                //更新表数据
                MyUsersSqlite.db.execSQL("update userstb set gender=? where currentUser=currentUser ",
                        new String[]{gender});
                showTip("更新成功!");
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}
