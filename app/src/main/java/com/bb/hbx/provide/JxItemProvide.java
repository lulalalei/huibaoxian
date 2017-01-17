package com.bb.hbx.provide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bb.hbx.MyApplication;
import com.bb.hbx.R;
import com.bb.hbx.bean.Special;
import com.bb.hbx.utils.GlideUtil;
import com.bb.hbx.widget.multitype.ItemViewProvider;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by fancl.
 */

public class JxItemProvide extends ItemViewProvider<Special, JxItemProvide.ViewHolder> {


    private Context context;

    public JxItemProvide(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.layout_jx, parent, false);
        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Special jxItem) {
        holder.setData(jxItem);
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        //
        @BindView(R.id.img_kind_res)
        ImageView img_kind_res;

        @BindView(R.id.lin_add)
        LinearLayout lin_add;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }


        void setData(@NonNull final Special jxItem) {

            GlideUtil.getInstance().loadImage(MyApplication.getAppContext(),
                    img_kind_res, jxItem.getSpecialLogo(), true);
            if (jxItem.getProductList() != null && jxItem.getProductList().size() > 0 && lin_add != null) {
                lin_add.removeAllViews();
                for (int i = 0; i < jxItem.getProductList().size(); i++) {
                    View view = View.inflate(itemView.getContext(), R.layout.layout_jx_item, null);

                    TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
                    TextView tv_detail = (TextView) view.findViewById(R.id.tv_detail);
                    TextView tv_price = (TextView) view.findViewById(R.id.tv_price);
                    ImageView img_right = (ImageView) view.findViewById(R.id.img_right);
                    TextView tv_added = (TextView) view.findViewById(R.id.tv_added);


                    View v_xx = view.findViewById(R.id.v_xx);

                    tv_name.setText(jxItem.getProductList().get(i).getProductName());
                    tv_detail.setText(jxItem.getProductList().get(i).getProductIntro());
                    tv_price.setText(context.getString(R.string.howPrice, jxItem.getProductList().get(i).getMinPremium()));
                    tv_added.setText(jxItem.getProductList().get(i).getCommisionValue1());

                    if (MyApplication.user.getIsBClient() ) {
                        tv_added.setVisibility(View.INVISIBLE);
                    } else if (MyApplication.user.getIsBClient() ) {
                        tv_added.setVisibility(View.VISIBLE);
                    } else {
                        tv_added.setVisibility(View.INVISIBLE);
                    }

                    GlideUtil.getInstance().loadImage(MyApplication.getAppContext(),
                            img_right, jxItem.getProductList().get(i).getProductLogo(), true);

                    lin_add.addView(view);
                    if (i == jxItem.getProductList().size() - 1) {
                        v_xx.setVisibility(View.GONE);
                    } else {
                        v_xx.setVisibility(View.VISIBLE);
                    }
                }


            }
        }
    }


}
