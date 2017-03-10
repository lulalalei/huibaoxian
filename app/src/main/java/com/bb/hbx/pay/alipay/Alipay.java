package com.bb.hbx.pay.alipay;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.bb.hbx.activitiy.ConfirmpaymentActivity;
import com.bb.hbx.activitiy.PolicydetailsActivity;
import com.bb.hbx.activitiy.ProductDetailActivity;
import com.bb.hbx.api.GenApiHashUrl;
import com.bb.hbx.bean.PaySign;
import com.bb.hbx.interfaces.Pay;
import com.bb.hbx.utils.AppManager;
import com.bb.hbx.utils.TimeUtils;
import com.bb.hbx.utils.Utils;

import com.bb.hbx.widget.BaseAsyncTask;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/3/9.
 */

public class Alipay implements Pay<PaySign> {

    private static final int SDK_PAY_FLAG = 1;

    ReturnTask task;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        //Toast.makeText(PayDemoActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                        Log.i("fancl", "支付成功");
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            // Toast.makeText(PayDemoActivity.this, "支付结果确认中", Toast.LENGTH_SHORT).show();
                            Log.i("fancl", "支付结果确认中");

                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            //Toast.makeText(PayDemoActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
                            Log.i("fancl", "支付失败" + "resultStatus:" + resultStatus);

                            task.execute();
                        }
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };


    @Override
    public void pay(PaySign paySign) {
        getOrderInfo(paySign);
    }

    /**
     * create the order info. 创建订单信息
     */
    private String getOrderInfo(PaySign paySign) {


        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + paySign.getPartner() + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + paySign.getSellerid() + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + paySign.getOuttradeno() + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + paySign.getSubject() + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + paySign.getBody() + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + paySign.getTotalfee() + "\"";

        // 服务器异步通知页面路径
        //orderInfo += "&notify_url=" + "\"" + "http://notify.msp.hk/notify.htm" + "\"";
        orderInfo += "&notify_url=" + "\"" + paySign.getNotifyurl() + "\"";

        // 服务接口名称， 固定值
        // orderInfo += "&service=\"mobile.securitypay.pay\"";
        //orderInfo += "&service=\"mobile.securitypay.pay\"";
        orderInfo += "&service=" + "\"" + paySign.getService() + "\"";

        // 支付类型， 固定值
        //orderInfo += "&payment_type=\"1\"";
        orderInfo += "&payment_type=" + "\"" + paySign.getPaymenttype() + "\"";

        // 参数编码， 固定值
        //orderInfo += "&_input_charset=\"utf-8\"";
        orderInfo += "&_input_charset= " + "\"" + paySign.getInputcharset() + "\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        //orderInfo += "&it_b_pay=\"30m\"";
        //orderInfo += "&it_b_pay=" + "\"" + paySign.getItbpay() + "\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
        //orderInfo += "&return_url=\"m.alipay.com\"";


        orderInfo += "&sign=\"" + paySign.getSign() + "\"&" + getSignType();
        Log.i("fancl", "orderInfo:" + orderInfo);
        return orderInfo;
    }


    private String getSignType() {
        return "sign_type=\"RSA\"";
    }

    /**
     * 回调部分
     */
    private class ReturnTask extends BaseAsyncTask<Void, String> {

        private PaySign paySign;

        public ReturnTask(PaySign paySign) {
            this.paySign = paySign;
        }

        @Override
        public String doInBackground(Void... params) {
            String result = "";
//            try {
            JSONObject jsonObject = new JSONObject();
            HashMap<String, String> map = new HashMap<>();
            StringBuilder builder = new StringBuilder();
            builder.append("out_trade_no=" + paySign.getOuttradeno() + "&");
            builder.append("trade_no=" + "20170301101350000000&");
            builder.append("gmt_payment=" + TimeUtils.getCurrentTimeWithSecondAndSpace() + "&");
            builder.append("total_fee=" + Utils.fromYuanToFen2(paySign.getTotalfee()) + "&");
            builder.append("trade_status=" + "TRADE_SUCCESS");

            Log.i("fancl", "jsonObject:" + builder.toString());
            result = GenApiHashUrl.getInstance().Http_Post(builder.toString());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }


            Log.i("fancl", "result:" + result);
            return result;

        }

        @Override
        public void doStuffWithResult(String aVoid) {
            if ("success".equalsIgnoreCase(aVoid)) {
                Bundle bundle = new Bundle();
                bundle.putString("tradeId", paySign.getOuttradeno());
                AppManager.getInstance().finishParticularActivity(ConfirmpaymentActivity.class);
                AppManager.getInstance().finishParticularActivity(ProductDetailActivity.class);
                AppManager.getInstance().showActivity(PolicydetailsActivity.class, bundle);
            }
        }
    }


}
