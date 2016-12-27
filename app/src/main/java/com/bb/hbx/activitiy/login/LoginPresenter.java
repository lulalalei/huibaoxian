package com.bb.hbx.activitiy.login;

import android.os.CountDownTimer;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/12/5.
 */

public class LoginPresenter extends LoginContract.Presenter {


    private CountDownTimer mCountDownTimer = new CountDownTimer(60000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) millisUntilFinished / 1000;
            Log.i(TAG, "progress:" + progress);
            mView.processTime(progress);


        }

        @Override
        public void onFinish() {
            mView.endTime();
        }
    };


    @Override
    public void login(String name, String pass) {

    }

    @Override
    public void startTime() {
        mCountDownTimer.start();
    }

    @Override
    public void cancelTime() {
        if(mCountDownTimer!=null){
            mCountDownTimer.cancel();
        }
    }
}
