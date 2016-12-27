package com.bb.hbx.base.p;

import android.os.CountDownTimer;
import android.util.Log;

import com.bb.hbx.base.v.RegistContract;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2016/12/5.
 */

public class RegistPresenter extends RegistContract.Presenter {


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
    public void onAttached() {

    }


    @Override
    public void regist(String tel, String pass, String code) {

    }

    @Override
    public void startTime() {
        mCountDownTimer.start();
    }

    @Override
    public void cancelTime() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }
}
