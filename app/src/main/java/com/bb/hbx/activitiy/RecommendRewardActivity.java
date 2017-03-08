package com.bb.hbx.activitiy;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.bb.hbx.R;
import com.bb.hbx.adapter.InviteFriendsListviewAdapter;
import com.bb.hbx.base.BaseActivity;
import com.bb.hbx.utils.AppManager;

import butterknife.BindView;

public class RecommendRewardActivity extends BaseActivity implements View.OnClickListener{

    private InviteFriendsListviewAdapter mAdapter;

    @BindView(R.id.back_layout)
    RelativeLayout back_layout;

    @BindView(R.id.lv_invitefriends)
    ListView lv_invitefriends;

    @BindView(R.id.bt_checkerule)
    Button bt_checkerule;

    @BindView(R.id.btn_gotoinvitefriend)
    Button btn_gotoinvitefriend;

    @Override
    public int getLayoutId() {
        return R.layout.activity_invite_friend;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
        back_layout.setOnClickListener(this);
        bt_checkerule.setOnClickListener(this);
        btn_gotoinvitefriend.setOnClickListener(this);
    }

    @Override
    public void initdata() {
        mAdapter = new InviteFriendsListviewAdapter(this);
        lv_invitefriends.setAdapter(mAdapter);
        setListViewHeightByChildren(lv_invitefriends);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back_layout:
                finish();
                break;
            case R.id.bt_checkerule:
                startActivity(new Intent(mContext,CheckRuleActivity.class));
                break;
            case R.id.btn_gotoinvitefriend:
                break;
            default:
                break;
        }
    }

    /**
     * 根据listview的条目高度计算listview的高度，解决scrollview嵌套listview的冲突
     * @param listView
     */
    public void setListViewHeightByChildren(ListView listView) {
        mAdapter = (InviteFriendsListviewAdapter) listView.getAdapter();
        if (mAdapter == null) {
            return;
        }

        int toalHeight = 0;
        for (int i = 0 , len = mAdapter.getCount(); i < len; i++) {
            View listItem = mAdapter.getView(i,null,listView);
            listItem.measure(0,0);
//            Log.i("ZXY","RecommendRewardActivity.setListViewHeightByChildren.Height:" + listItem.getMeasuredHeight() );
            toalHeight += AppManager.sp2px(mContext,68);
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
//        Log.i("ZXY","RecommendRewardActivity.setListViewHeightByChildren.di:" + listView.getDividerHeight());
        params.height = toalHeight + (listView.getDividerHeight() * (mAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
