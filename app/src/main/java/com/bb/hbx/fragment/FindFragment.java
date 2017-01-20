package com.bb.hbx.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by fancl
 * 发现页面
 */

public class FindFragment extends BaseFragment {


    @BindView(R.id.rg_select)
    RadioGroup rg_select;

    @BindView(R.id.rb_yxhd)
    RadioButton rb_yxhd;

    @BindView(R.id.rb_ztlb)
    RadioButton rb_ztlb;

    @BindView(R.id.rb_bktj)
    RadioButton rb_bktj;

    private ActivitFragment activitFragment;

    private TopiclistFragment topiclistFragment;

    private RecommendFragment recommendFragment;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initView() {


        rg_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                hideFragments(ft);
                switch (checkedId) {
                    case R.id.rb_bktj:
                        if (recommendFragment == null) {
                            recommendFragment = new RecommendFragment();
                            ft.add(R.id.tab_content2, recommendFragment, RecommendFragment.class.getName());
                        } else {
                            ft.show(recommendFragment);
                        }
                        break;
                    case R.id.rb_yxhd:
                        if (activitFragment == null) {
                            activitFragment = new ActivitFragment();
                            ft.add(R.id.tab_content2, activitFragment, ActivitFragment.class.getName());
                        } else {
                            ft.show(activitFragment);
                        }
                        break;
                    case R.id.rb_ztlb:
                        if (topiclistFragment == null) {
                            topiclistFragment = new TopiclistFragment();
                            ft.add(R.id.tab_content2, topiclistFragment, TopiclistFragment.class.getName());
                        } else {
                            ft.show(topiclistFragment);
                        }
                        break;
                    default:
                        break;
                }

                ft.commit();
            }
        });

        rb_bktj.setChecked(true);
    }

    @Override
    protected void initdate(Bundle savedInstanceState) {

    }

    private void hideFragments(FragmentTransaction transaction) {
        if (activitFragment != null) {
            transaction.hide(activitFragment);
        }
        if (recommendFragment != null) {
            transaction.hide(recommendFragment);
        }
        if (topiclistFragment != null) {
            transaction.hide(topiclistFragment);
        }

    }


}
