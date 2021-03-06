package com.bb.hbx.db;

import com.bb.hbx.bean.HomePageInfo;
import com.bb.hbx.bean.LishiSearchBean;
import com.bb.hbx.bean.User;

import java.util.List;

/**
 * Created by fancl.
 * 数据库接口类
 */

public interface Database {


    //添加历史记录
    public void addHistory(LishiSearchBean bean);

    //删除一条记录
    public void deleteHistory(LishiSearchBean bean);

    //删除全部
    public void deleteAllHis();

    //查询所有
    public List<LishiSearchBean> getListHis();

    public void addHomepageInfo(HomePageInfo info);

    public boolean updateUser(String authority);

    public User getUser();

}
