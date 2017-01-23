package com.bb.hbx.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.MyAssertActivity;
import com.bb.hbx.activitiy.PerInsuOrderActivity;
import com.bb.hbx.activitiy.PersonInfoSettingActivity;
import com.bb.hbx.activitiy.PurchaseDetailActivity;
import com.bb.hbx.activitiy.RedPacketActivity;
import com.bb.hbx.activitiy.ScoreActivity;
import com.bb.hbx.activitiy.login.LoginActivity;
import com.bb.hbx.api.ApiService;
import com.bb.hbx.api.Result_Api;
import com.bb.hbx.api.RetrofitFactory;
import com.bb.hbx.base.BaseFragment;
import com.bb.hbx.bean.Account;
import com.bb.hbx.bean.UserInfo;
import com.bb.hbx.utils.MyUsersSqlite;
import com.bb.hbx.utils.ShareSPUtils;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/12/20.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener{

    @BindView(R.id.setting_iv)
    ImageView setting_iv;
    @BindView(R.id.message_iv)
    ImageView message_iv;
    @BindView(R.id.userIcon_civ)
    CircleImageView userIcon_civ;
    @BindView(R.id.scrollView)
    ScrollView scrollView;
    @BindView(R.id.pInsurance_layout)
    RelativeLayout pInsurance_layout;
    @BindView(R.id.myAsset_tv)
    TextView myAsset_tv;
    @BindView(R.id.score_layout)
    RelativeLayout score_layout;
    @BindView(R.id.canCash_tv)
    TextView canCash_tv;
    @BindView(R.id.leftMoney_tv)
    TextView leftMoney_tv;
    @BindView(R.id.score_tv)
    TextView score_tv;
    @BindView(R.id.redPacket_tv)
    TextView redPacket_tv;
    @BindView(R.id.identify_layout)
    FrameLayout identify_layout;
    @BindView(R.id.redPacket_layout)
    RelativeLayout redPacket_layout;
    @BindView(R.id.notLogin_layout)
    RelativeLayout notLogin_layout;
    @BindView(R.id.userName)
    TextView userName;
    @BindView(R.id.identify_tv)
    TextView identify_tv;
    /*@BindView(R.id.hasLogin_tv)
    TextView hasLogin_tv;*/
    @BindView(R.id.pCount_tv)
    TextView pCount_tv;

    @BindView(R.id.service_layout)
    RelativeLayout service_layout;
    Context mContext;

    boolean isOnce=true;
    TextView hasLogin_tv;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_host;
    }

    @Override
    public void initView() {

        setting_iv.setOnClickListener(this);
        message_iv.setOnClickListener(this);
        userIcon_civ.setOnClickListener(this);
        pInsurance_layout.setOnClickListener(this);
        myAsset_tv.setOnClickListener(this);
        score_layout.setOnClickListener(this);
        redPacket_layout.setOnClickListener(this);
        notLogin_layout.setOnClickListener(this);

        service_layout.setOnClickListener(this);

        ShareSPUtils.readShareSP(notLogin_layout,userIcon_civ,/*,hasLogin_tv,*/mContext);
        hasLoginShow();
        //updateMyAccount();
    }



    @Override
    protected void initdate(Bundle savedInstanceState) {

    }

    @Override
    public void onResume() {
        super.onResume();
        ShareSPUtils.readShareSP(notLogin_layout,userIcon_civ,/*hasLogin_tv,*/mContext);
        hasLoginShow();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId())
        {
           case R.id.message_iv:
                Toast.makeText(mContext,"消息",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting_iv:
                Toast.makeText(mContext,"设置",Toast.LENGTH_SHORT).show();
                break;
            case R.id.pInsurance_layout:
                intent.setClass(mContext,PerInsuOrderActivity.class);
                startActivity(intent);
                break;
            case R.id.userIcon_civ:
                boolean hasLogined = ShareSPUtils.sp.getBoolean("hasLogined", false);
                if (hasLogined)
                {
                    intent.setClass(mContext,PersonInfoSettingActivity.class);
                }
                else
                {
                    intent.setClass(mContext, LoginActivity.class);
                }
                startActivity(intent);
                break;
            case R.id.myAsset_tv:
                intent.setClass(mContext,MyAssertActivity.class);
                startActivity(intent);
                break;
            case R.id.score_layout:
                intent.setClass(mContext, ScoreActivity.class);
                startActivity(intent);
                break;
            case R.id.redPacket_layout:
                intent.setClass(mContext, RedPacketActivity.class);
                startActivity(intent);
                break;
            case R.id.notLogin_layout:
                intent.setClass(mContext, LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_from_bottom,R.anim.activity_stay);
                break;
           /* case hasLogin_tv:
                Toast.makeText(mContext,"点了我",Toast.LENGTH_SHORT).show();

                break;*/
            case R.id.service_layout:
                intent.setClass(mContext, PurchaseDetailActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    //用户已经登录后,更改显示的页面
    public void hasLoginShow()
    {
        boolean hasLogined = ShareSPUtils.sp.getBoolean("hasLogined", false);
        if (hasLogined)
        {
            identify_tv.setVisibility(View.VISIBLE);
            String userName=null;
            Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where currentUser = ?", new String[]{"currentUser"});
            if (cursor!=null)
            {
                if (cursor.moveToNext())
                {
                    final String userId = cursor.getString(cursor.getColumnIndex("userId"));
                    final String sessionId = cursor.getString(cursor.getColumnIndex("sessionId"));
                    userName = cursor.getString(cursor.getColumnIndex("name"));
                    if (!TextUtils.isEmpty(userId)&&!TextUtils.isEmpty(sessionId))
                    {
                        //调用更新账户方法
                        updateMyAccount(userId);
                        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
                        Call call=service.getUserInfo(sessionId,userId);
                        call.enqueue(new Callback() {
                            @Override
                            public void onResponse(Call call, Response response) {
                                //Toast.makeText(mContext,"userId:"+userId+"  sessionId:"+sessionId,Toast.LENGTH_SHORT);
                                //正常,,不吐司
                                Result_Api body = (Result_Api) response.body();
                                if (body!=null)
                                {
                                    UserInfo userInfo = (UserInfo) body.getOutput();
                                    String userName1 = userInfo.getUserName();
                                }
                                else
                                {
                                    Toast.makeText(mContext,"服务器异常!",Toast.LENGTH_SHORT);
                                }
                            }

                            @Override
                            public void onFailure(Call call, Throwable t) {
                                Toast.makeText(mContext,"error",Toast.LENGTH_SHORT);
                            }
                        });
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
            if (isOnce)
            {
                hasLogin_tv = new TextView(mContext);
                FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                params.gravity= Gravity.CENTER;
                hasLogin_tv.setLayoutParams(params);
                identify_layout.addView(hasLogin_tv);
                isOnce=false;
                hasLogin_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"点了我",Toast.LENGTH_SHORT).show();
                    }
                });
            }
            if (!TextUtils.isEmpty(userName))
            {
                hasLogin_tv.setText(userName);
            }
            else
            {
                Toast.makeText(mContext,"用户名为空",Toast.LENGTH_SHORT);
            }
        }
    }
    //更新我的资产
    private void updateMyAccount(String userId) {
        ApiService service = RetrofitFactory.getINSTANCE().create(ApiService.class);
        Call call=service.getAccount(userId);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                Result_Api body = (Result_Api) response.body();
                Account account = (Account) body.getOutput();
                String acctBalance = account.getAcctBalance();//可提现????
                String acctSum = account.getAcctSum();//余额????
                String accountScore = account.getAccountScore();
                String bonusCount = account.getBonusCount();
                canCash_tv.setText(TextUtils.isEmpty(acctBalance)?"0":acctBalance);
                leftMoney_tv.setText(TextUtils.isEmpty(acctSum)?"0":acctSum);
                score_tv.setText(TextUtils.isEmpty(accountScore)?"0":accountScore);
                redPacket_tv.setText(TextUtils.isEmpty(bonusCount)?"0":bonusCount);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                showTip("服务器返回出错啦!");
            }
        });
    }
}
