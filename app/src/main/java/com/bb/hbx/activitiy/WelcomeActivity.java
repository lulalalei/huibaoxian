package com.bb.hbx.activitiy;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.KeyEvent;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.bean.User;
import com.bb.hbx.service.DownloadIconService;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.DeviceUtils;
import com.bb.hbx.utils.LocationService;
import com.bb.hbx.utils.MyUsersSqlite;
import com.bb.hbx.utils.PermissionUtils;
import com.bb.hbx.utils.ShareSPUtils;


public class WelcomeActivity extends BaseActivity {

    private LocationService locationService;

    private PermissionUtils utils;

    boolean isOnce=false;
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
        MyApplication.user = new User();
        MyApplication.user.setUserId("");
        utils = new PermissionUtils(this);
        ShareSPUtils.initShareSP(this);
        MyUsersSqlite.initUsersdb(this);

        Intent intentService = new Intent(this, DownloadIconService.class);
        startService(intentService);
        //boolean hasLogined = ShareSPUtils.sp.getBoolean("hasLogined", false);
        Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where currentUser = ?", new String[]{"currentUser"});
        if (cursor!=null)
        {
            if (!cursor.moveToNext())//没有数据,则首次使用,初始化部分数据
            {
                ContentValues values = new ContentValues();
                values.put("currentUser","currentUser");
                values.put("hasLogined","false");//默认false,未登录
                values.put("isBClient",false);//默认false
                values.put("sessionId","");
                values.put("userId","");
                values.put("gender","0");//默认为0
                long flag = MyUsersSqlite.db.insert("userstb", null, values);
                //Toast.makeText(this,"插入新用户成功:"+flag,Toast.LENGTH_SHORT).show();
                values.clear();
                MyApplication.user.setUserId("");
                MyApplication.user.setSessionId("");
                MyApplication.user.setIsBClient(false);
            }
            else
            {
                String hasLogined = cursor.getString(cursor.getColumnIndex("hasLogined"));
                if (hasLogined.equals("true"))//首次登陆后,数据会被刷新
                {
                    String userId = cursor.getString(cursor.getColumnIndex("userId"));
                    String sessionId = cursor.getString(cursor.getColumnIndex("sessionId"));
                    String isBClient = cursor.getString(cursor.getColumnIndex("isBClient"));
                    MyApplication.user.setUserId(userId);
                    MyApplication.user.setSessionId(sessionId);
                    MyApplication.user.setIsBClient(isBClient.equals("true")?true:false);
                }
                else
                {
                    MyApplication.user.setUserId("");
                    MyApplication.user.setSessionId("");
                    MyApplication.user.setIsBClient(false);
                }
            }
        }
        comm();
    }


    private void comm() {
        boolean isGo = true;
        if (utils.isM()) {
            if (utils.checkPermissions(Manifest.permission.READ_PHONE_STATE)) {
                DeviceUtils.getDeviceIdentification(this);
            } else {
                isGo = false;
            }
            if (utils.checkPermissions(Manifest.permission.ACCESS_FINE_LOCATION)) {
                initLocationService();
            } else {
                isGo = false;
            }
            if (utils.checkPermissions(Manifest.permission.ACCESS_COARSE_LOCATION)) {

            }
            utils.startPermission();

        } else {
            DeviceUtils.getDeviceIdentification(this);
            initLocationService();

        }

        if (isGo) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppManager.getInstance().showActivity(HomeActivity.class, null);
                    finish();
                }
            }, 3000);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void initLocationService() {
//        locationService = ((MyApplication) getApplication()).locationService;
//        locationService.registerListener(mListener);
//        locationService.setLocationOption(locationService.getDefaultLocationClientOption());
//        locationService.start();// 定位SDK
    }


    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                StringBuffer sb = new StringBuffer(256);
                sb.append("time : ");
                /**
                 * 时间也可以使用systemClock.elapsedRealtime()方法 获取的是自从开机以来，每次回调的时间；
                 * location.getTime() 是指服务端出本次结果的时间，如果位置不发生变化，则时间不变
                 */
                sb.append(location.getTime());
                sb.append("\nlocType : ");// 定位类型
                sb.append(location.getLocType());
                sb.append("\nlocType description : ");// *****对应的定位类型说明*****
                sb.append(location.getLocTypeDescription());
                sb.append("\nlatitude : ");// 纬度
                sb.append(location.getLatitude());
                sb.append("\nlontitude : ");// 经度
                sb.append(location.getLongitude());
                sb.append("\nradius : ");// 半径
                sb.append(location.getRadius());
                sb.append("\nCountryCode : ");// 国家码
                sb.append(location.getCountryCode());
                sb.append("\nCountry : ");// 国家名称
                sb.append(location.getCountry());
                sb.append("\ncitycode : ");// 城市编码
                sb.append(location.getCityCode());
                sb.append("\ncity : ");// 城市
                sb.append(location.getCity());
                sb.append("\nDistrict : ");// 区
                sb.append(location.getDistrict());
                sb.append("\nStreet : ");// 街道
                sb.append(location.getStreet());
                sb.append("\naddr : ");// 地址信息
                sb.append(location.getAddrStr());
                sb.append("\nUserIndoorState: ");// *****返回用户室内外判断结果*****
                sb.append(location.getUserIndoorState());
                sb.append("\nDirection(not all devices have value): ");
                sb.append(location.getDirection());// 方向
                sb.append("\nlocationdescribe: ");
                sb.append(location.getLocationDescribe());// 位置语义化信息
                sb.append("\nPoi: ");// POI信息
                if (location.getPoiList() != null && !location.getPoiList().isEmpty()) {
                    for (int i = 0; i < location.getPoiList().size(); i++) {
                        Poi poi = (Poi) location.getPoiList().get(i);
                        sb.append(poi.getName() + ";");
                    }
                }
                if (location.getLocType() == BDLocation.TypeGpsLocation) {// GPS定位结果
                    sb.append("\nspeed : ");
                    sb.append(location.getSpeed());// 速度 单位：km/h
                    sb.append("\nsatellite : ");
                    sb.append(location.getSatelliteNumber());// 卫星数目
                    sb.append("\nheight : ");
                    sb.append(location.getAltitude());// 海拔高度 单位：米
                    sb.append("\ngps status : ");
                    sb.append(location.getGpsAccuracyStatus());// *****gps质量判断*****
                    sb.append("\ndescribe : ");
                    sb.append("gps定位成功");
                } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {// 网络定位结果
                    // 运营商信息
                    if (location.hasAltitude()) {// *****如果有海拔高度*****
                        sb.append("\nheight : ");
                        sb.append(location.getAltitude());// 单位：米
                    }
                    sb.append("\noperationers : ");// 运营商信息
                    sb.append(location.getOperators());
                    sb.append("\ndescribe : ");
                    sb.append("网络定位成功");
                } else if (location.getLocType() == BDLocation.TypeOffLineLocation) {// 离线定位结果
                    sb.append("\ndescribe : ");
                    sb.append("离线定位成功，离线定位结果也是有效的");
                } else if (location.getLocType() == BDLocation.TypeServerError) {
                    sb.append("\ndescribe : ");
                    sb.append("服务端网络定位失败，可以反馈IMEI号和大体定位时间到loc-bugs@baidu.com，会有人追查原因");
                } else if (location.getLocType() == BDLocation.TypeNetWorkException) {
                    sb.append("\ndescribe : ");
                    sb.append("网络不同导致定位失败，请检查网络是否通畅");
                } else if (location.getLocType() == BDLocation.TypeCriteriaException) {
                    sb.append("\ndescribe : ");
                    sb.append("无法获取有效定位依据导致定位失败，一般是由于手机的原因，处于飞行模式下一般会造成这种结果，可以试着重启手机");
                }
                Log.i("fancl", sb.toString());
            }
        }

    };

    /***
     * Stop location service
     */
    @Override
    protected void onStop() {
        super.onStop();
//        // TODO Auto-generated method stub
//        locationService.unregisterListener(mListener); //注销掉监听
//        locationService.stop(); //停止定位服务
//        super.onStop();
//        Log.i("fancl", "onstop");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        boolean isGOHome = utils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (utils.getPermissions(Manifest.permission.READ_PHONE_STATE)) {
            DeviceUtils.getDeviceIdentification(this);
        }

        if (utils.getPermissions(Manifest.permission.ACCESS_FINE_LOCATION)
                || utils.getPermissions(Manifest.permission.ACCESS_COARSE_LOCATION)) {
            initLocationService();
        }

        if (isGOHome) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppManager.getInstance().showActivity(HomeActivity.class, null);
                    finish();
                }
            }, 3000);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PermissionUtils.REQUEST_SETTING_CODE) {
            comm();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        } else
            return super.onKeyDown(keyCode, event);

    }
}
