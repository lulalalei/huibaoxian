package com.bb.hbx.activitiy;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.utils.CompressBitmap;
import com.bb.hbx.utils.MyUsersSqlite;
import com.bb.hbx.utils.ShareSPUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
    @BindView(R.id.realNameIdentify_layout)
    RelativeLayout realNameIdentify_layout;
    @BindView(R.id.countSafe_layout)
    RelativeLayout countSafe_layout;

    @BindView(R.id.name_tv)
    TextView name_tv;
    @BindView(R.id.sex_tv)
    TextView sex_tv;
    @BindView(R.id.phone_tv)
    TextView phone_tv;

    TextView camera_tv;
    TextView mapstorage_tv;

    File picFile;
    String picPath;
    @Override
    public int getLayoutId() {
        return R.layout.activity_person_info_setting;
    }

    @Override
    public void initView() {
        //ShareSPUtils.readShareSP();
        Can.hasLogined=ShareSPUtils.sp.getBoolean("hasLogined",false);
        Can.userName=ShareSPUtils.sp.getString("userName",null);
        Can.userPhone=ShareSPUtils.sp.getString("userPhone",null);
        Can.userPwd=ShareSPUtils.sp.getString("userPwd",null);
        Can.userIcon= ShareSPUtils.sp.getString("userIcon", null);
        userIcon_civ.setImageBitmap(BitmapFactory.decodeFile(Can.userIcon));
    }

    @Override
    public void initListener() {
        userIcon_layout.setOnClickListener(this);
        name_layout.setOnClickListener(this);
        sex_layout.setOnClickListener(this);
        address_layout.setOnClickListener(this);
        realNameIdentify_layout.setOnClickListener(this);
        countSafe_layout.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        updateUserInfo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUserInfo();
    }

    private void updateUserInfo() {
        Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where currentUser = ?", new String[]{"currentUser"});
        if (cursor!=null)
        {
            if (cursor.moveToNext())
            {
                /*String userId = cursor.getString(cursor.getColumnIndex("userId"));
                String sessionId = cursor.getString(cursor.getColumnIndex("sessionId"));*/
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String gender = cursor.getString(cursor.getColumnIndex("gender"));
                String phone = cursor.getString(cursor.getColumnIndex("phone"));
                name_tv.setText(name);
                if (TextUtils.isEmpty(phone))//用户可能是通过短信的方式登录
                {
                    phone_tv.setText("请绑定手机号");
                }
                else
                {
                    phone_tv.setText(phone);
                }
                if (gender.equals("0"))
                {
                    sex_tv.setText("男");
                }
                else if (gender.equals("1"))
                {
                    sex_tv.setText("女");
                }
                else
                {
                    sex_tv.setText("性别未知");
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
                        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
                        {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            //以下为了获得原图
                            String cameraPath= Can.getDefaultUsersIconFile();
                            File file = new File(cameraPath);
                            picFile = new File(file, System.currentTimeMillis() + ".jpg");
                            picPath=picFile.getAbsolutePath();
                            //Uri uri = Uri.fromFile(picFile);
                            //为拍摄的图片指定一个存储的路径
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, picFile);
                            //intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
                            startActivityForResult(intent,101);
                        }
                        else
                        {
                            Toast.makeText(PersonInfoSettingActivity.this,"请检查您的sdk",Toast.LENGTH_SHORT).show();
                        }
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
                startActivityForResult(intent,103);
                break;
            case R.id.sex_layout:
                intent.setClass(PersonInfoSettingActivity.this,SexActivity.class);
                startActivity(intent);
                break;
            case R.id.address_layout:
                intent.setClass(PersonInfoSettingActivity.this,AddressManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.realNameIdentify_layout:
                intent.setClass(PersonInfoSettingActivity.this,RealNameIdentifyActivity.class);
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
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                            String mapPath = Can.getDefaultUsersIconFile();
                            File file = new File(mapPath);
                            mapPath = new File(file, System.currentTimeMillis() + ".jpg").getAbsolutePath();
                            FileOutputStream fos = null;
                            BufferedOutputStream bos = null;
                            try {
                                fos = new FileOutputStream(mapPath);
                                bos = new BufferedOutputStream(fos);
                                //compressBitmap(mapPath, fos);
                                bitmap.compress(Bitmap.CompressFormat.JPEG,80,bos);
                                bos.close();
                                //fos在压缩完毕后关闭
                                Bitmap compressBitmap = CompressBitmap.compressBitmap(mapPath, fos,3);
                                ShareSPUtils.edit.putString("userIcon", mapPath);
                                ShareSPUtils.edit.commit();
                                if (compressBitmap!=null)
                                {
                                    userIcon_civ.setImageBitmap(compressBitmap);
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Toast.makeText(PersonInfoSettingActivity.this, "请检查您的sdk", Toast.LENGTH_SHORT).show();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else if (requestCode==101)
        {
                Bundle bundle = data.getExtras();
                if (bundle!=null)
                {
                    try {
                        Bitmap bitmap = (Bitmap) bundle.get("data");
                        userIcon_civ.setImageBitmap(bitmap);
                        ShareSPUtils.edit.putString("userIcon", picPath);
                        ShareSPUtils.edit.commit();
                        if (picFile.exists())
                        {
                            picFile.delete();
                        }
                        picFile.createNewFile();
                        FileOutputStream fos = new FileOutputStream(picFile);//fos 为毛是null
                        bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
                        fos.flush();
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                //Glide.with(PersonInfoSettingActivity.this).load(new File(picPath)).into(userIcon_civ);
            }
            /*if (resultCode!=0)
            {
                try {
                    Bitmap bitmap = BitmapFactory.decodeFile(picPath);
                    File file = new File(Can.getDefaultUsersIconFile());
                    picPath=new File(file,System.currentTimeMillis()+".jpg").getAbsolutePath();
                    FileOutputStream fos = new FileOutputStream(picPath);
                    BufferedOutputStream bos = new BufferedOutputStream(fos);
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos);
                    bos.close();
                    Bitmap compressBitmap = CompressBitmap.compressBitmap(picPath,fos,3);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
        }
        else if (requestCode==103)
        {
            if (resultCode==Can.RESULT_NAME)
            {
                if (data!=null)
                {
                    String name = data.getStringExtra("name");
                    if (!TextUtils.isEmpty(name))
                    {
                        name_tv.setText(name);
                    }
                }
            }
        }
    }
}
