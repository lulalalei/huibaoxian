package com.bb.hbx.observable;

import com.bb.hbx.bean.KeyBean;

import java.util.Observable;

/**
 * Created by Administrator on 2017/2/24.
 */

public class KeyBeanObservable extends Observable {

    private KeyBean bean;



    public KeyBean getBean() {
        return bean;
    }

    public void setBean(KeyBean bean) {
        this.bean = bean;
    }

    public void add(String s) {
        bean.add(s);
    }

    public void set(int index, String s) {
        bean.set(index, s);
    }

}
