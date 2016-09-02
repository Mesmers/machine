package com.tetris.djj.machine_m.activity.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.power.PowerManagerDayActivity;
import com.tetris.djj.machine_m.activity.main.home.power.PowerManagerSearchActivity;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.WheelView;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.adapters.ArrayWheelAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.能耗管理
 */
public class PowerManagerActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.wheel_power_manager_left)
    WheelView mWheelTime;
    @Bind(R.id.wheel_power_manager_right)
    WheelView mWheelWorkshop;

    private String[] dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_manager);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        dates = getResources().getStringArray(R.array.power_time_array);
        mWheelTime.setViewAdapter(new ArrayWheelAdapter<>(this,dates));
        mWheelWorkshop.setViewAdapter(new ArrayWheelAdapter<>(this,getResources().getStringArray(R.array.actual_array)));
    }

    @OnClick({R.id.i_btn_power_manager_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_power_manager_search:
                Intent intent =null;
                if (dates[mWheelTime.getCurrentItem()].equals("当天"))
                    intent = new Intent(this, PowerManagerDayActivity.class);
                else
                    intent = new Intent(this, PowerManagerSearchActivity.class);
                startActivity(intent);
                break;
        }
    }
}
