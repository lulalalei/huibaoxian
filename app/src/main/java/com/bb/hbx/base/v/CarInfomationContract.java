package com.bb.hbx.base.v;

import com.bb.hbx.base.m.BaseModel;
import com.bb.hbx.base.p.BasePresenter;
import com.bb.hbx.bean.Area;
import com.bb.hbx.widget.multitype.data.Item;

import java.util.List;

import retrofit2.Callback;


/**
 * Created by Administrator on 2017/1/9.
 */

public interface CarInfomationContract {


    interface Model extends BaseModel {

        void getAvaCarAreas(String companyCode, String areaCode, Callback callback);

    }


    interface View extends BaseView {

        void getProvices(List<Area> prvoinces);

        void getCities(List<Area> cities);
    }

    abstract class Presenter extends BasePresenter<CarInfomationContract.Model, CarInfomationContract.View> {

        public abstract void getProvicesCarAreas(String companyCode);

        public abstract void getcitiesCarAreas(String companyCode, String areaCode);

    }
}
