package com.bb.hbx.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.BaseDialog;
import com.bb.hbx.R;
import com.bb.hbx.adapter.AbstractWheelTextAdapter;
import com.bb.hbx.views.OnWheelChangedListener;
import com.bb.hbx.views.OnWheelScrollListener;
import com.bb.hbx.views.WheelView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.value;
import static com.bb.hbx.DatePickerDialog.DIALOG_MODE_BOTTOM;

/**
 * Created by Administrator on 2017/1/24.
 */

public class PickerDialogOneWheel extends BaseDialog implements
        View.OnClickListener, DialogInterface.OnDismissListener {


    public static final int DIALOG_MODE_CENTER = 0;
    public static final int DIALOG_MODE_BOTTOM = 1;

    private Context context;
    private ViewGroup VDialogPicker;

    private WheelView wheelView;
    private View vDialog;
    private View vDialogChild;
    private TextView tvTitle;
    private TextView btnSure;
    private TextView btnCancel;

    private OnTextListener listener;

    private boolean issetdata = false;

    private int maxTextSize = 24;
    private int minTextSize = 18;

    private String strTitle = "选择日期";

    public String getSelectValue() {
        return selectValue;
    }

    public void setSelectValue(String selectValue) {
        this.selectValue = selectValue;
    }

    private String selectValue;

    private List<String> arry_value;

    private TextAdapter textAdapter;

    private View parentView;


    public PickerDialogOneWheel(Context context, List<String> arry_value, View view) {
        super(context, R.layout.dialog_picker_center);
        this.context = context;
        this.arry_value = arry_value;
        this.parentView = view;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        VDialogPicker = (ViewGroup) findViewById(R.id.ly_dialog_picker);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        // 此处相当于布局文件中的Android:layout_gravity属性
        lp.gravity = Gravity.CENTER_VERTICAL;

        wheelView = new WheelView(context);
        wheelView.setLayoutParams(lp);
        VDialogPicker.addView(wheelView);
        vDialog = findViewById(R.id.ly_dialog);
        vDialogChild = findViewById(R.id.ly_dialog_child);
        tvTitle = (TextView) findViewById(R.id.tv_dialog_title);
        btnSure = (TextView) findViewById(R.id.btn_dialog_sure);
        btnCancel = (TextView) findViewById(R.id.btn_dialog_cancel);
        tvTitle.setText(strTitle);
        vDialog.setOnClickListener(this);
        vDialogChild.setOnClickListener(this);
        btnSure.setOnClickListener(this);
        this.setOnDismissListener(this);
        if (null != btnCancel) {
            btnCancel.setOnClickListener(this);
        }
        if (!issetdata) {
            initData();
        }
        textAdapter = new TextAdapter(mContext, arry_value, 0, maxTextSize, minTextSize);
        selectValue = arry_value.get(0);
        wheelView.setVisibleItems(5);
        wheelView.setViewAdapter(textAdapter);
        wheelView.setCurrentItem(0);

        wheelView.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                String currentText = (String) textAdapter.getItemText(wheel
                        .getCurrentItem());
                selectValue = currentText;
                setTextviewSize(currentText, textAdapter);

            }
        });
        wheelView.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {

            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                String currentText = (String) textAdapter.getItemText(wheel
                        .getCurrentItem());
                setTextviewSize(currentText, textAdapter);
            }
        });

    }

    public void setDialogMode(int dialogMode) {
        if (dialogMode == DIALOG_MODE_BOTTOM) {
            resetContent(R.layout.dialog_picker_bottom);
            setAnimation(R.style.AnimationBottomDialog);
            setGravity(Gravity.BOTTOM);
        }
    }

    @Override
    protected int dialogWidth() {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(metric);
        return metric.widthPixels;
    }


    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText,
                                PickerDialogOneWheel.TextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(maxTextSize);
            } else {
                textvew.setTextSize(minTextSize);
            }
        }
    }

    public void initData() {

    }


    @Override
    public void onClick(View v) {
        if (v == btnSure) {
            if (listener != null) {
                listener.onClick(parentView, selectValue);
            }
        } else if (v == btnCancel) {

        } else if (v == vDialogChild) {
            return;
        } else {
            dismiss();
        }
        dismiss();
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {

    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        if (listener != null) {
            listener.dissmiss(parentView);
        }
    }

    private class TextAdapter extends AbstractWheelTextAdapter {

        List<String> list;

        protected TextAdapter(Context context, List<String> list,
                              int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem,
                    maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.get(index) + "";
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }
    }

    public void setListener(OnTextListener listener) {
        this.listener = listener;
    }


    public interface OnTextListener {

        void onClick(View pv, String value);

        void dissmiss(View pv);
    }


}
