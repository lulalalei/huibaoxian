package com.bb.hbx.observable;

import com.bb.hbx.utils.Utils;

import java.math.BigDecimal;
import java.util.Observable;

import static com.bb.hbx.utils.Utils.fromFenToYuanBd;

/**
 * Created by Administrator on 2017/2/24.
 */

public class PriceObservable extends Observable {


    private String allPrice = "0";//总价

    private String price_jf = "0";//积分

    private String price_ye = "0";//余额

    private String price_yhq = "0";//优惠券


    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
        String ret = Utils.fromFenToYuan(allPrice);
        setChanged();
        notifyObservers(new String[]{ret, "0"});
    }

    public String getPrice_yhq() {
        return price_yhq;
    }

    public void setPrice_yhq(String price_yhq) {
        this.price_yhq = price_yhq;
        String ret = calculation();
        setChanged();
        notifyObservers(new String[]{ret, addall2()});
    }

    public String getPrice_ye() {
        return price_ye;
    }

    public void setPrice_ye(String price_ye) {
        this.price_ye = price_ye;
        String ret = calculation();
        setChanged();
        notifyObservers(new String[]{ret, addall()});

    }

    public String getPrice_jf() {
        return price_jf;
    }

    public void setPrice_jf(String price_jf) {
        this.price_jf = price_jf;
        String ret = calculation();
        setChanged();
        notifyObservers(new String[]{ret, addall()});
    }

    public String calculation() {
        BigDecimal ret = Utils.fromFenToYuanBd(allPrice).subtract(Utils.fromFenToYuanBd(price_jf)).subtract(
                Utils.fromFenToYuanBd(price_ye)).subtract(
                Utils.fromFenToYuanBd(price_yhq));
        if (ret.compareTo(new BigDecimal(0)) <= 0) {//小于等于0时，都让支付0
            ret = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_DOWN);
        }
        return ret.toString();
    }

    public String addall() {
        BigDecimal ret = Utils.fromFenToYuanBd(price_jf).add(Utils.fromFenToYuanBd(price_ye));
        return ret.toString();
    }

    public String addall2() {
        BigDecimal ret = Utils.fromFenToYuanBd(allPrice).subtract(new BigDecimal(calculation())).setScale(2, BigDecimal.ROUND_DOWN);
        return ret.toString();
    }


}
