package com.bb.hbx.activitiy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bb.hbx.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBankCardActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.warn_iv)
    ImageView warn_iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank_card);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    public void backMethod(View view) {
        finish();
    }

    public void showWarnMethod(View view) {
        Toast.makeText(this,"警告信息",Toast.LENGTH_SHORT).show();
    }

    public void choseBankMethod(View view) {
        Toast.makeText(this,"选择银行",Toast.LENGTH_SHORT).show();
    }

   /* public void nextStepMethod(View view) {
        Intent intent = new Intent(this, SetPwdActivity.class);
        startActivity(intent);
    }*/
}
