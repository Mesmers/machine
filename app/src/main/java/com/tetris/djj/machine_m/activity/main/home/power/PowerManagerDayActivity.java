package com.tetris.djj.machine_m.activity.main.home.power;

import android.os.Bundle;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.widget.BtnLinearChart;
import com.tetris.djj.machine_m.widget.MyLineChart;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/22.
 */
public class PowerManagerDayActivity extends BaseActivity {

    @Bind(R.id.widget_power_manager_day_line_chart)
    BtnLinearChart mWidgetLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_manager_day);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        MyLineChart mLineChartTime= mWidgetLineChart.getmLineChartExpand();

        //当X车间X分步图
        mLineChartTime.setDatas(0, 0, 5, 0, 24, 5);
        mLineChartTime.drawLinear("71.4","90");
        mLineChartTime.setDate("当天电费");

    }
}
