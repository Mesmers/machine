package com.tetris.djj.machine_m.activity.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.order.OrderFormManagerSearchActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.订单管理
 */
public class OrderFormManagerActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.spinner_order_form_manager_choose)
    Spinner mSpinnerChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form_manager);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        String[] items = getResources().getStringArray(R.array.order_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerChoose.setAdapter(adapter);
    }

    @OnClick({R.id.i_btn_order_form_manager_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_order_form_manager_search:
                Intent intent = new Intent(this, OrderFormManagerSearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
