package com.bb.hbx.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.bb.hbx.R;
import com.bb.hbx.bean.BaseIndexPinyinBean;
import com.github.promeg.pinyinhelper.Pinyin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * Created by Administrator on 2016/12/2.
 */

public class IndexBar extends View{

    private static final String TAG = "zxt/IndexBar";
    public static String[] INDEX_STRING = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z", "#"};//#在最后面（默认的数据源）

    //索引数据源
    private List<String> mIndexDatas/*=new ArrayList<>()*/;
    //是否需要根据实际的数据来生成索引数据源(例如只有ABC三种tag,那么索引栏就ABC三项)
    private boolean isNeedRealIndex/*=true*/;

    private int mWidth, mHeight;//View的宽高
    private int mGapHeight;//每个index区域的高度

    private Paint mPaint;

    private int mPressedBackground;//手指按下时的背景色

    //以下变量需要外部set进来
    //用于特写显示正在被触摸的index值
    private TextView mPressedShowTextView;
    //Adapter的数据源
    private List<? extends BaseIndexPinyinBean> mSourceDatas;
    private LinearLayoutManager mLayoutManager;
    private Context mContext;

    public IndexBar(Context context) {
        this(context,null);
    }

    public IndexBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IndexBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        mContext=context;
        int textSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics());
        mPressedBackground= Color.BLACK;//默认按下时纯黑色
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.IndexBar, defStyleAttr, 0);
        int n = typedArray.getIndexCount();
        Log.d(TAG,typedArray.toString());
        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr)
            {
                case R.styleable.IndexBar_textSize:
                    textSize= typedArray.getDimensionPixelSize(attr, textSize);
                    break;
                case R.styleable.IndexBar_pressBackground:
                    mPressedBackground=typedArray.getColor(attr,mPressedBackground);
                    break;
                default:
                    break;
            }
        }
        typedArray.recycle();
        if (!isNeedRealIndex)
        {
            //不需要真实的索引数据源
            mIndexDatas= Arrays.asList(INDEX_STRING);
        }
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(textSize);
        mPaint.setColor(mContext.getResources().getColor(R.color.A1));

        setmOnIndexPressedListener(new onIndexPressedListener() {
            @Override
            public void onIndexPressed(int index, String text) {
                if (null!=mPressedShowTextView)
                {
                    //显示hintTextView
                    mPressedShowTextView.setVisibility(View.VISIBLE);
                    mPressedShowTextView.setText(text);
                }
                if (null!=mLayoutManager)
                {
                    int position=getPosByTag(text);
                    if (position!=-1)
                    {
                        mLayoutManager.scrollToPositionWithOffset(position,0);
                    }
                }
            }

            @Override
            public void onMotionEventEnd() {
                if (null!=mPressedShowTextView)
                {
                    mPressedShowTextView.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //android绘制text是以文本左下角的位置为绘制起点,因此我们需要计算每个字显示在自己分配的区域中间时的字的左下角的坐标
    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        int t = getPaddingTop();//top的基准点(支持padding)
        Rect indexBounds = new Rect();//存放每个绘制的index的Rect区域
        String index;//每个要绘制的index内容
        for (int i = 0; i < mIndexDatas.size(); i++) {
            index=mIndexDatas.get(i);
            mPaint.getTextBounds(index,0,index.length(),indexBounds);//测量文字所在矩形,可以得到宽高
            Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();//获得画笔的FontMetrics,用来计算baseLine.因为drawtext的y坐标,代表的是绘制文字的baseLine的位置
            int baseline = (int) ((mGapHeight - fontMetrics.bottom - fontMetrics.top) / 2);//计算出在每格index区域，竖直居中的baseLine值
            canvas.drawText(index, mWidth / 2 - indexBounds.width() / 2, t + mGapHeight * i + baseline, mPaint);//调用drawText，居中显示绘制index

        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                setBackgroundColor(mPressedBackground);//手指按下时背景变色
                //这里无需break,因为down时,也要计算落点,回调监听
            case MotionEvent.ACTION_MOVE:
                float y = event.getY();
                //通过计算判断落点在哪个区域
                int pressI= (int) ((y-getPaddingTop())/mGapHeight);
                //边界处理(在手指move时,有可能已经移除边界,防止越界)
                if (pressI<0)
                {
                    pressI=0;
                }
                else if (pressI>mIndexDatas.size())
                {
                    pressI=mIndexDatas.size()-1;
                }
                //回调监听
                if (null!=mOnIndexPressedListener)
                {
                    if (pressI<=mIndexDatas.size()-1)
                    {
                        mOnIndexPressedListener.onIndexPressed(pressI,mIndexDatas.get(pressI));
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                //break;
            case MotionEvent.ACTION_CANCEL:
                //break;
            default:
                setBackgroundResource(android.R.color.transparent);//手指抬起时背景恢复透明
                if (null!=mOnIndexPressedListener)
                {
                    mOnIndexPressedListener.onMotionEventEnd();
                }
                break;
        }
        //return super.onTouchEvent(event);
        return true;
    }

    public IndexBar setmPressedShowTextView(TextView mPressedShowTextView) {
        this.mPressedShowTextView = mPressedShowTextView;
        return this;
    }

    public IndexBar setmLayoutManager(LinearLayoutManager mLayoutManager) {
        this.mLayoutManager = mLayoutManager;
        return this;
    }

    public IndexBar setNeedRealIndex(boolean needRealIndex) {
        isNeedRealIndex = needRealIndex;
        if (null!=mIndexDatas)
        {
            mIndexDatas=new ArrayList<>();
        }
        return this;
    }

    public IndexBar setmSourceDatas(List<? extends BaseIndexPinyinBean> mSourceDatas) {
        this.mSourceDatas = mSourceDatas;
        initSourceDatas();//对数据源进行初始化
        return this;
    }

    /*
    * 初始化原始数据源,并取出索引数据源*/
    private void initSourceDatas() {
        int size = mSourceDatas.size();
        for (int i = 0; i < size; i++) {
            BaseIndexPinyinBean indexPinyinBean = mSourceDatas.get(i);
            StringBuilder pySb = new StringBuilder();
            String target = indexPinyinBean.getTarget();//取出需要被拼音化的字段
            //遍历target的每个char得到全拼音
            if (TextUtils.isEmpty(target))
            {
                return;
            }
            for (int i1 = 0; i1 < target.length(); i1++) {
                //pySb.append()
                //利用TinyPinyin将char转成拼音
                //查看源码，方法内 如果char为汉字，则返回大写拼音
                //如果c不是汉字，则返回String.valueOf(c)
                pySb.append(Pinyin.toPinyin(target.charAt(i1)));
                //pySb.append(target.charAt(i1));

            }
            indexPinyinBean.setPyCity(pySb.toString());//设置城市名全拼音
            String tagString = pySb.toString().substring(0, 1);
            if (tagString.matches("[A-Z]"))//如果是A-Z字母开头
            {
                indexPinyinBean.setTag(tagString);
                if (isNeedRealIndex)//如果需要真实的索引数据源
                {
                    if (!mIndexDatas.contains(tagString))//未添加则添加
                    {
                        mIndexDatas.add(tagString);
                    }
                }
            }
            else//特殊字母通一用#表示
            {
                indexPinyinBean.setTag("#");
                if (isNeedRealIndex)
                {
                    if (!mIndexDatas.contains("#"))
                    {
                        mIndexDatas.add("#");
                    }
                }
            }
        }
        sortData();
    }

    /*
    * 对数据源排序*/
    private void sortData() {
        Collections.sort(mIndexDatas, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.equals("#"))
                {
                    return 1;
                }
                else if (t1.equals("#"))
                {
                    return -1;
                }
                else
                {
                    return s.compareTo(t1);
                }
            }
        });
        Collections.sort(mSourceDatas, new Comparator<BaseIndexPinyinBean>() {
            @Override
            public int compare(BaseIndexPinyinBean lhs, BaseIndexPinyinBean rhs) {
                if (lhs.getTag().equals("#")) {
                    return 1;
                } else if (rhs.getTag().equals("#")) {
                    return -1;
                } else {
                    return lhs.getPyCity().compareTo(rhs.getPyCity());
                }
            }
        });
    }

    //应该是计算每个字显示所占据的控件大小.....当控件大小发生改变的时候都会调用onSizeChanged方法,
    // 因此我们可以在本方法中获取控件的测量高度和宽度
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mIndexDatas!=null&&mIndexDatas.size()>0)
        {
            mWidth = w;
            mHeight = h;
            mGapHeight = (mHeight - getPaddingTop() - getPaddingBottom()) / mIndexDatas.size();
        }
    }

    /*
                            * 当前被按下的index的监听器*/
    public interface onIndexPressedListener
    {

        //当某个Index被按下
        void onIndexPressed(int index, String text);
        //当触摸事件结束(UP CANCEL)
        void onMotionEventEnd();
    }
    private onIndexPressedListener mOnIndexPressedListener;

    public onIndexPressedListener getmOnIndexPressedListener() {
        return mOnIndexPressedListener;
    }

    public void setmOnIndexPressedListener(onIndexPressedListener mOnIndexPressedListener) {
        this.mOnIndexPressedListener = mOnIndexPressedListener;
    }

    /*
    * 根据传入的pos返回tag*/
    private int getPosByTag(String text) {
        if (TextUtils.isEmpty(text))
        {
            return -1;
        }
        for (int i = 0; i < mSourceDatas.size(); i++) {
            if (text.equals(mSourceDatas.get(i).getTag()))
            {
                return i;
            }
        }
        return -1;
    }
}
