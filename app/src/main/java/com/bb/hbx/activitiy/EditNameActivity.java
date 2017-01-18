package com.bb.hbx.activitiy;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.utils.MyUsersSqlite;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditNameActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.back_iv)
    ImageView back_iv;
    @BindView(R.id.save_tv)
    TextView save_tv;
    @BindView(R.id.name_et)
    EditText name_et;

    Intent nameIntent;
    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_name;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        save_tv.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        nameIntent= getIntent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_iv:
                finish();
                break;
            case R.id.save_tv:
                final String name = name_et.getText().toString();
                if (!TextUtils.isEmpty(name))
                {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                    dialog.setTitle("是否确认更改用户名");
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String userId=null;
                            Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where currentUser = ?", new String[]{"currentUser"});
                            if (cursor!=null)
                            {
                                if (cursor.moveToNext())
                                {
                                    userId = cursor.getString(cursor.getColumnIndex("userId"));
                                }
                            }
                            if (!TextUtils.isEmpty(userId))
                            {
                                ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                                Call call=service.updateUserInfo(userId,name);
                                call.enqueue(new Callback() {
                                    @Override
                                    public void onResponse(Call call, Response response) {
                                        showTip("更新用户名成功!");
                                        MyUsersSqlite.db.execSQL("update userstb set name=? where currentUser=currentUser ",
                                                new String[]{name});
                                        nameIntent.putExtra("name",name);
                                        setResult(Can.RESULT_NAME,nameIntent);
                                        finish();
                                    }

                                    @Override
                                    public void onFailure(Call call, Throwable t) {
                                        Toast.makeText(EditNameActivity.this,"服务器连接异常!",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                    dialog.setNegativeButton("取消", null);
                    dialog.show();
                }
                else
                {
                    showTip("用户名不能为空!");
                }
                break;
            default:
                break;
        }
    }
}
