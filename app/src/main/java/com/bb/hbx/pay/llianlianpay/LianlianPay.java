package com.bb.hbx.pay.llianlianpay;

import android.os.Handler;
import android.os.Message;
import android.util.Log;


import com.bb.hbx.interfaces.Pay;
import com.bb.hbx.pay.llianlianpay.utils.BaseHelper;
import com.bb.hbx.pay.llianlianpay.utils.Constants;
import com.bb.hbx.pay.llianlianpay.utils.MobileSecurePayer;
import com.bb.hbx.pay.llianlianpay.utils.PayOrder;
import com.bb.hbx.utils.AppManager;

import org.json.JSONObject;


/**
 * Created by Administrator on 2017/3/9.
 */

public class LianlianPay implements Pay<PayOrder> {

    private final static String TAG = LianlianPay.class.getSimpleName();


    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String strRet = (String) msg.obj;
            switch (msg.what) {
                case Constants.RQF_PAY: {
                    JSONObject objContent = BaseHelper.string2JSON(strRet);
                    String retCode = objContent.optString("ret_code");
                    String retMsg = objContent.optString("ret_msg");

                    Log.i(TAG, "objContent=" + objContent.toString());

                    // 成功
                    if (Constants.RET_CODE_SUCCESS.equals(retCode)) {

                    } else if (Constants.RET_CODE_PROCESS.equals(retCode)) {
                        // TODO 处理中，掉单的情形
                        String resulPay = objContent.optString("result_pay");
                        if (Constants.RESULT_PAY_PROCESSING
                                .equalsIgnoreCase(resulPay)) {

                        }

                    } else {
                        // TODO 失败

                    }
                }
                break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void pay(PayOrder order) {
        String content4Pay = BaseHelper.toJSONString(order);
        MobileSecurePayer msp = new MobileSecurePayer();
        boolean bRet = msp.payAuth(content4Pay, handler,
                Constants.RQF_PAY, AppManager.getInstance().currentActivity(), false);
    }
}
