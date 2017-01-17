package com.bb.hbx.widget.freshlayout;

/**
 * Created by Administrator on 2016/12/16.
 */

public interface PullFooter {

    //上拉加载
    void onUpBefore(int scrollY);

    //松开加载
    void onUpAfter(int scrollY);

    //准备加载
    void onLoadScrolling(int scrollY);

    //正在加载……
    void onLoadDoing(int scrollY);

    //加载完成后，回到默认状态中
    void onLoadCompleteScrolling(int scrollY, boolean isLoadSuccess);

    //加载取消后，回到默认状态中
    void onLoadCancelScrolling(int scrollY);


}
