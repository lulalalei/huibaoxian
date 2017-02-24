package com.bb.hbx.observable;

import com.bb.hbx.bean.KeyBean;

import java.util.Observable;

/**
 * Created by fancl
 */

public class KeyBeanObservable extends Observable {

    private KeyBean bean = new KeyBean();//计价因子


    private int count = 1;//份数

    public KeyBean getBean() {
        return bean;
    }

    public void setBean(KeyBean bean) {
        this.bean = bean;
    }

    public void add(String s) {
        bean.add(s);
        setChanged();
        notifyObservers();
    }

    public int size() {
        return bean.size();
    }

    public void set(int index, String s) {
        bean.set(index, s);
        setChanged();
        notifyObservers();
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return bean.toString();
    }
}
