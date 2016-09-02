package com.tetris.djj.machine_m.activity.main.home.power;

import android.os.Bundle;
import android.view.View;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.widget.MyLineChart;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/19.
 */
public class PowerManagerSearchActivity extends BaseActivity implements View.OnClickListener{

    @Bind(R.id.widget_power_manager_search_time)//当X车间X分步图
    MyLineChart mLineChartTime;
    @Bind(R.id.widget_power_manager_search_every_time)//车间X每X分步图
    MyLineChart mLineChartEveryTime;

    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_manager_search);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        //当X车间X分步图
        mLineChartTime.setDatas(0,0,30,0,30,30);
        mLineChartTime.drawLinear("1120","1894");

        //车间X每X分步图
        mLineChartEveryTime.setDatas(0,0,1200,0,12,1200);
    }

    @OnClick({R.id.btn_power_manager_search_time_expand,R.id.btn_power_manager_search_every_time_expand})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_power_manager_search_time_expand:
                if (mLineChartTime.getVisibility() == View.GONE)
                    mLineChartTime.setVisibility(View.VISIBLE);
                else
                    mLineChartTime.setVisibility(View.GONE);
                break;
            case R.id.btn_power_manager_search_every_time_expand:
                if (mLineChartEveryTime.getVisibility() == View.GONE)
                    mLineChartEveryTime.setVisibility(View.VISIBLE);
                else
                    mLineChartEveryTime.setVisibility(View.GONE);
                break;
        }
    }
}
