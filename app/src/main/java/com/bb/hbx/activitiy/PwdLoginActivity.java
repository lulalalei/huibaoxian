package com.bb.hbx.activitiy;

import android.database.Cursor;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bb.hbx.R;
import com.bb.hbx.activitiy.login.LoginActivity;
import com.bb.hbx.activitiy.login.LoginContract;
import com.bb.hbx.activitiy.login.LoginModel;
import com.bb.hbx.activitiy.login.LoginPresenter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.interfaces.LoginTextWatcher;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.LoginAnimHelp;
import com.bb.hbx.utils.MyUsersSqlite;
import com.bb.hbx.utils.ShareSPUtils;
import com.bb.hbx.widget.LoginPswEdit;
import com.bb.hbx.widget.LoginTelEdit;

import butterknife.BindView;

/**
 * 密码登录
 * fancl
 */


public class PwdLoginActivity extends BaseActivity<LoginPresenter, LoginModel>
        implements LoginContract.View, View.OnClickListener, View.OnLayoutChangeListener {


    @BindView(R.id.activity_smss_login)
    LinearLayout activity_smss_login;

    @BindView(R.id.back_iv)
    ImageView back_iv;

    @BindView(R.id.scrollView)
    ScrollView scrollView;


    @BindView(R.id.logoIcon_iv)
    ImageView logoIcon_iv;

    @BindView(R.id.logoText_iv)
    ImageView logoText_iv;

    @BindView(R.id.et_phone)
    LoginTelEdit et_phone;

    @BindView(R.id.et_psw)
    LoginPswEdit et_psw;




    @BindView(R.id.tv_login)
    TextView tv_login;

    @BindView(R.id.tv_yzmlogin)
    TextView tv_yzmlogin;

    @BindView(R.id.tv_regist)
    TextView tv_regist;

    @BindView(R.id.iv_wechat)
    ImageView iv_wechat;

    @BindView(R.id.lin_ed)
    LinearLayout lin_ed;

    @BindView(R.id.tv_losspsw)
    TextView tv_losspsw;


    //屏幕高度
    private int screenHeight = 0;
    //软件盘弹起后所占高度阀值
    private int keyHeight = 0;


    @Override
    public void loginSuccess() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        //添加layout大小发生改变监听器
        activity_smss_login.addOnLayoutChangeListener(this);
    }


    @Override
    public boolean isverTel() {
        if (!TextUtils.isEmpty(et_phone.getText()) && et_phone.getText().toString().trim().length() == 11) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isverCode() {
        return true;
    }

    @Override
    public boolean isverpassword() {
        if (!TextUtils.isEmpty(et_psw.getText()) && et_psw.getText().toString().trim().length() >= 6
                && et_psw.getText().toString().trim().length() <= 20) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCheckbx() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_pwd_login;
    }

    @Override
    public void initView() {
        //获取屏幕高度
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        //阀值设置为屏幕高度的1/3
        keyHeight = screenHeight / 3;
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    @Override
    public void initListener() {
        back_iv.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_yzmlogin.setOnClickListener(this);
        back_iv.setOnClickListener(this);
        tv_losspsw.setOnClickListener(this);
        tv_regist.setOnClickListener(this);
        et_phone.addTextChangedListener(new LoginTextWatcher(tv_login, this));
        et_psw.addTextChangedListener(new LoginTextWatcher(tv_login, this));

    }

    @Override
    public void initdata() {

    }

    @Override
    public void showMsg(String msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                finish();
                break;
            case R.id.tv_regist:
                AppManager.getInstance().showActivity(RegisteActivity.class, null);
                break;
            case R.id.tv_login:
                if (isverTel() && isverCode()) {
                    //mPresenter.login(et_phone.getText().toString().trim(), et_psw.getText().toString().trim());
                    String phone = et_phone.getText().toString();
                    String pwd = et_psw.getText().toString();
                    Cursor cursor = MyUsersSqlite.db.rawQuery("select * from userstb where phone = ? and pwd = ?", new String[]{phone, pwd});
                    if (cursor!=null)
                    {
                        if (cursor.moveToNext())//存在此用户,说明登录成功
                        {
                            ShareSPUtils.writeShareSp(true, "默认用户名", phone, pwd);
                            Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
                            AppManager.getInstance().showActivity(HomeActivity.class, null);
                        }
                        else
                        {
                            Toast.makeText(this,"手机号或密码错误",Toast.LENGTH_SHORT).show();
                        }
                    }
                } else
                    showTip("手机号码或验证码有误");
                break;

            case R.id.tv_yzmlogin:
                AppManager.getInstance().showActivity(LoginActivity.class, null);
                break;

            case R.id.tv_losspsw:
                AppManager.getInstance().showActivity(GetPswActivity.class, null);
                break;
        }
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        //现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起
        if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
            startAnimator();

        } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
            resetAnimator();
        }
    }


    private void startAnimator() {
        LoginAnimHelp helpstart = new LoginAnimHelp();

        helpstart.addTranslationY(lin_ed, 0, -60);
        //helpstart.addTranslationY(scrollView, 0, -60);
        helpstart.addTranslationY(logoIcon_iv, 0, -40);
        helpstart.addTranslationY(logoText_iv, 0, -120);
        helpstart.addScaleX(logoIcon_iv, 1, 0.5f);
        helpstart.addScaleX(logoText_iv, 1, 0.5f);
        helpstart.addScaleY(logoIcon_iv, 1, 0.5f);
        helpstart.addScaleY(logoText_iv, 1, 0.5f);
        helpstart.addRotation(logoIcon_iv, 0, 180);
        helpstart.startAnim(300);
    }

    private void resetAnimator() {
        LoginAnimHelp helpstart = new LoginAnimHelp();
        helpstart.addTranslationY(lin_ed, -60, 0);
        //helpstart.addTranslationY(scrollView, -60, 0);
        helpstart.addTranslationY(logoIcon_iv, -40, 0);
        helpstart.addTranslationY(logoText_iv, -120, 0);
        helpstart.addScaleX(logoIcon_iv, 0.5f, 1);
        helpstart.addScaleX(logoText_iv, 0.5f, 1);
        helpstart.addScaleY(logoIcon_iv, 0.5f, 1);
        helpstart.addScaleY(logoText_iv, 0.5f, 1);
        helpstart.addRotation(logoIcon_iv, 180, 0);
        helpstart.startAnim(300);
    }


}
