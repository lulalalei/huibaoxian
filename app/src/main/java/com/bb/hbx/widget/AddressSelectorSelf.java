package com.bb.hbx.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.Area;
import com.bb.hbx.interfaces.OnAreaSelectedListener;
import com.bb.hbx.utils.Lists;


import java.util.List;


/**
 * Created by smartTop on 2016/10/19.
 */

public class AddressSelectorSelf implements AdapterView.OnItemClickListener {
    private static final int INDEX_TAB_PROVINCE = 0;//省份标志
    private static final int INDEX_TAB_CITY = 1;//城市标志
    private int tabIndex = INDEX_TAB_PROVINCE; //默认是省份

    private static final int INDEX_INVALID = -1;
    private int provinceIndex = INDEX_INVALID; //省份的下标
    private int cityIndex = INDEX_INVALID;//城市的下标


    private Context context;
    private final LayoutInflater inflater;
    private View view;

    private View indicator;

    private LinearLayout layout_tab;
    private TextView textViewProvince;
    private TextView textViewCity;


    private ProgressBar progressBar;

    private ListView listView;
    private ProvinceAdapter provinceAdapter;
    private CityAdapter cityAdapter;
    private List<Area> provinces;
    private List<Area> cities;
    private OnAreaSelectedListener listener;
    private OnDialogCloseListener dialogCloseListener;

    private static final int WHAT_PROVINCES_PROVIDED = 0;
    private static final int WHAT_CITIES_PROVIDED = 1;
    private ImageView iv_colse;
    private int selectedColor;
    private int unSelectedColor;


    @SuppressWarnings("unchecked")
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_PROVINCES_PROVIDED: //更新省份列表
                    provinces = (List<Area>) msg.obj;
                    provinceAdapter.notifyDataSetChanged();
                    listView.setAdapter(provinceAdapter);

                    break;

                case WHAT_CITIES_PROVIDED: //更新城市列表
                    cities = (List<Area>) msg.obj;
                    cityAdapter.notifyDataSetChanged();
                    if (cities != null && !cities.isEmpty()) {
                        // 以次级内容更新列表
                        listView.setAdapter(cityAdapter);
                        // 更新索引为次级
                        tabIndex = INDEX_TAB_CITY;
                    } else {
                        // 次级无内容，回调
                        callbackInternal();
                    }

                    break;
            }

            updateTabsVisibility();
            updateProgressVisibility();
            updateIndicator();

            return true;
        }
    });


    public AddressSelectorSelf(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        initViews();
        initAdapters();
    }


    /**
     * 初始化布局
     */
    private void initViews() {
        view = inflater.inflate(R.layout.address_selector2, null);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);//进度条
        this.iv_colse = (ImageView) view.findViewById(R.id.iv_colse);
        this.listView = (ListView) view.findViewById(R.id.listView);//listview
        this.indicator = view.findViewById(R.id.indicator); //指示器
        this.layout_tab = (LinearLayout) view.findViewById(R.id.layout_tab);
        this.textViewProvince = (TextView) view.findViewById(R.id.textViewProvince);//省份
        this.textViewCity = (TextView) view.findViewById(R.id.textViewCity);//城市

        this.textViewProvince.setOnClickListener(new OnProvinceTabClickListener());
        this.textViewCity.setOnClickListener(new OnCityTabClickListener());

        this.listView.setOnItemClickListener(this);
        this.iv_colse.setOnClickListener(new onCloseClickListener());

        updateIndicator();
    }

    /**
     * 设置字体选中的颜色
     */
    public void setTextSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
    }

    /**
     * 设置字体没有选中的颜色
     */
    public void setTextUnSelectedColor(int unSelectedColor) {
        this.unSelectedColor = unSelectedColor;
    }

    /**
     * 设置字体的大小
     */
    public void setTextSize(float dp) {
        textViewProvince.setTextSize(dp);
        textViewCity.setTextSize(dp);

    }

    /**
     * 设置字体的背景
     */
    public void setBackgroundColor(int colorId) {
        layout_tab.setBackgroundColor(context.getResources().getColor(colorId));
    }

    /**
     * 设置指示器的背景
     */
    public void setIndicatorBackgroundColor(int colorId) {
        indicator.setBackgroundColor(context.getResources().getColor(colorId));
    }

    /**
     * 设置指示器的背景
     */
    public void setIndicatorBackgroundColor(String color) {
        indicator.setBackgroundColor(Color.parseColor(color));
    }

    /**
     * 初始化adapter
     */
    private void initAdapters() {
        provinceAdapter = new ProvinceAdapter();
        cityAdapter = new CityAdapter();
    }

    /**
     * 更新tab 指示器
     */
    private void updateIndicator() {
        view.post(new Runnable() {
            @Override
            public void run() {
                switch (tabIndex) {
                    case INDEX_TAB_PROVINCE: //省份
                        buildIndicatorAnimatorTowards(textViewProvince).start();
                        break;
                    case INDEX_TAB_CITY: //城市
                        buildIndicatorAnimatorTowards(textViewCity).start();
                        break;
                }
            }
        });
    }

    /**
     * tab 来回切换的动画
     *
     * @param tab
     * @return
     */
    private AnimatorSet buildIndicatorAnimatorTowards(TextView tab) {
        ObjectAnimator xAnimator = ObjectAnimator.ofFloat(indicator, "X", indicator.getX(), tab.getX());

        final ViewGroup.LayoutParams params = indicator.getLayoutParams();
        ValueAnimator widthAnimator = ValueAnimator.ofInt(params.width, tab.getMeasuredWidth());
        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.width = (int) animation.getAnimatedValue();
                indicator.setLayoutParams(params);
            }
        });

        AnimatorSet set = new AnimatorSet();
        set.setInterpolator(new FastOutSlowInInterpolator());
        set.playTogether(xAnimator, widthAnimator);

        return set;
    }

    /**
     * 更新tab显示
     */
    private void updateTabsVisibility() {
        textViewProvince.setVisibility(Lists.notEmpty(provinces) ? View.VISIBLE : View.GONE);
        textViewCity.setVisibility(Lists.notEmpty(cities) ? View.VISIBLE : View.GONE);

        //按钮能不能点击 false 不能点击 true 能点击
        textViewProvince.setEnabled(tabIndex != INDEX_TAB_PROVINCE);
        textViewCity.setEnabled(tabIndex != INDEX_TAB_CITY);
        if (selectedColor != 0 && unSelectedColor != 0) {
            updateTabTextColor();
        }
    }

    /**
     * 更新字体的颜色
     */
    private void updateTabTextColor() {
        if (tabIndex != INDEX_TAB_PROVINCE) {
            textViewProvince.setTextColor(context.getResources().getColor(selectedColor));
        } else {
            textViewProvince.setTextColor(context.getResources().getColor(unSelectedColor));
        }
        if (tabIndex != INDEX_TAB_CITY) {
            textViewCity.setTextColor(context.getResources().getColor(selectedColor));
        } else {
            textViewCity.setTextColor(context.getResources().getColor(unSelectedColor));
        }

    }

    /**
     * 点击省份的监听
     */
    class OnProvinceTabClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            tabIndex = INDEX_TAB_PROVINCE;
            listView.setAdapter(provinceAdapter);

            if (provinceIndex != INDEX_INVALID) {
                listView.setSelection(provinceIndex);
            }

            updateTabsVisibility();
            updateIndicator();
        }
    }

    /**
     * 点击城市的监听
     */
    class OnCityTabClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            tabIndex = INDEX_TAB_CITY;
            listView.setAdapter(cityAdapter);

            if (cityIndex != INDEX_INVALID) {
                listView.setSelection(cityIndex);
            }

            updateTabsVisibility();
            updateIndicator();
        }
    }


    /**
     * 点击右边关闭dialog监听
     */
    class onCloseClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (dialogCloseListener != null) {
                dialogCloseListener.dialogclose();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (tabIndex) {
            case INDEX_TAB_PROVINCE: //省份
                Area province = provinceAdapter.getItem(position);

                // 更新当前级别及子级标签文本
                textViewProvince.setText(province.getAreaName());
                textViewCity.setText("请选择");
                loadprogressBar();
                listener.onAreaProvinceSelected(province);

                // 清空子级数据
                cities = null;
                cityAdapter.notifyDataSetChanged();
                // 更新已选中项
                this.provinceIndex = position;
                this.cityIndex = INDEX_INVALID;
                // 更新选中效果
                provinceAdapter.notifyDataSetChanged();
                break;
            case INDEX_TAB_CITY://城市
                Area city = cityAdapter.getItem(position);
                textViewCity.setText(city.getAreaName());
                //根据城市的id,从数据库中查询城市列表
                // 清空子级数据
                this.cityIndex = position;
                // 更新选中效果
                cityAdapter.notifyDataSetChanged();
                callbackInternal();
                break;

        }
    }


    public void loadprogressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }


    /**
     * 查询省份列表
     */
    public void retrieveProvinces(List<Area> provinces) {
        handler.sendMessage(Message.obtain(handler, WHAT_PROVINCES_PROVIDED, provinces));

    }


    public void getCitylist(List<Area> cityList) {
        handler.sendMessage(Message.obtain(handler, WHAT_CITIES_PROVIDED, cityList));
    }


    /**
     * 省份 城市 乡镇 街道 都选中完 后的回调
     */
    private void callbackInternal() {
        if (listener != null) {
            Area province = provinces == null || provinceIndex == INDEX_INVALID ? null : provinces.get(provinceIndex);
            Area city = cities == null || cityIndex == INDEX_INVALID ? null : cities.get(cityIndex);
            listener.onAreaCitySelected(city);
        }
    }

    /**
     * 更新进度条
     */
    private void updateProgressVisibility() {
        ListAdapter adapter = listView.getAdapter();
        int itemCount = adapter.getCount();
        progressBar.setVisibility(itemCount > 0 ? View.GONE : View.VISIBLE);
    }

    /**
     * 获得view
     *
     * @return
     */
    public View getView() {
        return view;
    }

    /**
     * 省份的adapter
     */
    class ProvinceAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return provinces == null ? 0 : provinces.size();
        }

        @Override
        public Area getItem(int position) {
            return provinces.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_area, parent, false);

                holder = new Holder();
                holder.textView = (TextView) convertView.findViewById(R.id.textView);
                holder.imageViewCheckMark = (ImageView) convertView.findViewById(R.id.imageViewCheckMark);

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            Area item = getItem(position);
            holder.textView.setText(item.getAreaName());

            boolean checked = provinceIndex != INDEX_INVALID && provinces.get(provinceIndex).getAreaCode().equalsIgnoreCase(item.getAreaCode());
            holder.textView.setEnabled(checked);
            holder.imageViewCheckMark.setVisibility(checked ? View.VISIBLE : View.GONE);

            return convertView;
        }

        class Holder {
            TextView textView;
            ImageView imageViewCheckMark;
        }
    }

    /**
     * 城市的adaoter
     */
    class CityAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return cities == null ? 0 : cities.size();
        }

        @Override
        public Area getItem(int position) {
            return cities.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder;

            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_area, parent, false);

                holder = new Holder();
                holder.textView = (TextView) convertView.findViewById(R.id.textView);
                holder.imageViewCheckMark = (ImageView) convertView.findViewById(R.id.imageViewCheckMark);

                convertView.setTag(holder);
            } else {
                holder = (Holder) convertView.getTag();
            }

            Area item = getItem(position);
            holder.textView.setText(item.getAreaName());

            boolean checked = cityIndex != INDEX_INVALID && cities.get(cityIndex).getAreaCode().equalsIgnoreCase(item.getAreaCode());
            holder.textView.setEnabled(checked);
            holder.imageViewCheckMark.setVisibility(checked ? View.VISIBLE : View.GONE);

            return convertView;
        }

        class Holder {
            TextView textView;
            ImageView imageViewCheckMark;
        }
    }


    public void setListener(OnAreaSelectedListener listener) {
        this.listener = listener;
    }

    public interface OnDialogCloseListener {
        void dialogclose();
    }

    /**
     * 设置close监听
     */
    public void setOnDialogCloseListener(OnDialogCloseListener listener) {
        this.dialogCloseListener = listener;
    }

}
