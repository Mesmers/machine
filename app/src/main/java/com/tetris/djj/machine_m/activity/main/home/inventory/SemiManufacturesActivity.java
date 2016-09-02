package com.tetris.djj.machine_m.activity.main.home.inventory;

import android.os.Bundle;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;

import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/22.
 */
public class SemiManufacturesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_management);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {

    }
}
