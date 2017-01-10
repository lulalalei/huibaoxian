package com.bb.hbx.activitiy;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.cans.Can;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.MyUsersSqlite;
import com.bb.hbx.utils.ShareSPUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WelcomeActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initdata() {
        ShareSPUtils.initShareSP(this);
        MyUsersSqlite.initUsersdb(this);

        if (!ShareSPUtils.sp.getBoolean("hasLogined", false)) {
            new MyAsynctask(this).execute(Can.userIconDefault);

        } else {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    class MyAsynctask extends AsyncTask<String, Void, String> {

        Context context;
        String iconPath = null;
        FileOutputStream fos = null;

        public MyAsynctask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... params) {
            ByteArrayOutputStream baos = null;
            String parentPath = null;

            try {
                URL url = new URL(Can.userIconDefault);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                if (conn.getResponseCode() == 200) {
                    InputStream is = conn.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    baos = new ByteArrayOutputStream();
                    while ((len = is.read(bytes)) != -1) {
                        baos.write(bytes, 0, len);
                        baos.flush();
                    }
                    byte[] array = baos.toByteArray();
                    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                        parentPath = Can.getDefaultUsersIconFile();
                        File file = new File(parentPath);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        iconPath = new File(file, Can.userIconDefault.substring(Can.userIconDefault.lastIndexOf("/") + 1)).getAbsolutePath();
                        fos = new FileOutputStream(iconPath);
                        fos.write(array);
                        fos.close();
                    } else {
                        Toast.makeText(context, "请检查sdk", Toast.LENGTH_SHORT).show();
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return iconPath;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (!TextUtils.isEmpty(s)) {
                Intent intent = new Intent(context, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(context, "图片出错啦", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
