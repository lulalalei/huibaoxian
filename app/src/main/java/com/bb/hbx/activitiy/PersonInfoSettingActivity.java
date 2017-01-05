package com.bb.hbx.activitiy;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.utils.CompressBitmap;
import com.bb.hbx.utils.ShareSPUtils;
import com.bumptech.glide.Glide;

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
    @BindView(R.id.countSafe_layout)
    RelativeLayout countSafe_layout;

    TextView camera_tv;
    TextView mapstorage_tv;

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
                        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
                        {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            //以下为了获得原图
                            String cameraPath= Can.getDefaultUsersIconFile();
                            File file = new File(cameraPath);
                            picPath=new File(file,System.currentTimeMillis()+".jpg").getAbsolutePath();
                            Uri uri = Uri.fromFile(new File(picPath));
                            //为拍摄的图片指定一个存储的路径
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
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
            Glide.with(PersonInfoSettingActivity.this).load(new File(picPath)).into(userIcon_civ);
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
    }
}
