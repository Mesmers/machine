package com.tetris.djj.machine_m.activity.main.home.actual;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.ActualProcedureEntity;
import com.tetris.djj.machine_m.widget.actual.ActualMonitorProcedure;
import com.tetris.djj.machine_m.widget.WorkShopPie;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/17.
 */
public class ActualMonitorSearchActivity extends BaseActivity{

    @Bind(R.id.tv_actual_monitor_search_workshop)
    TextView mTvWorkshop;
    @Bind(R.id.widget_actual_monitor_search_workshop_pie)
    WorkShopPie mWidgetWorkshopPie;
    @Bind(R.id.ll_actual_monitor_search_procedure)
    LinearLayout mLlProcedure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_monitor_search);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        mWidgetWorkshopPie.setData("良好","32","25","5","2");

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        ActualMonitorProcedure actualMonitorProcedure;
        List<ActualProcedureEntity> entities;
        for (int i = 1 ; i <= 4 ; i ++){
            actualMonitorProcedure = new ActualMonitorProcedure(this);
            entities = new ArrayList<>();
            for (int j = 0 ;j < 7 ; j++)
            entities.add(new ActualProcedureEntity("机台-S"+((char)(i+65))+j+1,(int)(Math.random()*3)));
            actualMonitorProcedure.setData("工序"+i,entities);
            mLlProcedure.addView(actualMonitorProcedure,layoutParams);
        }
    }


}
