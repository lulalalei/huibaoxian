package com.bb.hbx.service;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bb.hbx.cans.Can;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/1/20.
 */

public class DownloadIconService extends Service{

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String path;
        new Thread() {
            @Override
            public void run() {
                super.run();
                ByteArrayOutputStream baos = null;
                String parentPath = null;
                String iconPath = null;
                FileOutputStream fos = null;
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
                            Toast.makeText(DownloadIconService.this, "请检查sdk", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                        try {
                            if (baos != null) {
                                baos.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                }
            }
        }.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
