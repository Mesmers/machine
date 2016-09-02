package com.tetris.djj.machine_m.activity.main.home.actual;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.ActualErrorEntity;
import com.tetris.djj.machine_m.widget.actual.ActualMonitorList;
import com.tetris.djj.machine_m.widget.MyLineChart;
import com.tetris.djj.machine_m.widget.actual.ActualMonitorStatusMachine;
import com.tetris.djj.machine_m.widget.actual.ActualMonitorStatusProcess;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/17.
 */
public class ActualMonitorProductStatusActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.scroll_actual_monitor_product_status)
    ScrollView mScrollProductStatus;


    @Bind(R.id.widget_actual_monitor_status_machine_time)//运作时间图
            ActualMonitorStatusMachine mWidgetTime;
    @Bind(R.id.widget_actual_monitor_status_machine_process)//生产进度
            ActualMonitorStatusProcess mWidgetProcess;
    @Bind(R.id.widget_actual_monitor_status_machine_error_list)//异常情况列表
            ActualMonitorList mWidgetErrorList;
    @Bind(R.id.widget_actual_monitor_status_machine_dimension_procedure)//工艺尺寸图
            MyLineChart mWidgetProcedureDimension;
    @Bind(R.id.widget_actual_monitor_status_machine_speed)//机台速度图
            MyLineChart mWidgetSpeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_monitor_product_status);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {
        mScrollProductStatus.smoothScrollTo(0, 0);
        //监听ScrollView和ListView的滑动
        mWidgetErrorList.getmListError().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mWidgetErrorList.getmListError().getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        mScrollProductStatus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mWidgetErrorList.getmListError().getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
    }

    @Override
    protected void initDatas() {
        //运作时间图初始化
        mWidgetTime.setDatas("良好", "0.1", "0.5", "1.4", "10.0");
        //生产进度初始化
        mWidgetProcess.setDatas("2000", "1480", "2016-7-12");
        //异常情况列表初始化
        List<ActualErrorEntity> errorEntities = new ArrayList<>();
        for (int i = 1; i <= 10; i++)
            errorEntities.add(new ActualErrorEntity("温度" + i, "低温", "13:45", "0.2"));
        mWidgetErrorList.setDatas(errorEntities);
        //工艺尺寸初始化
        mWidgetProcedureDimension.setDatas(5,2,10,0,30,10);
        //机台速度初始化
        mWidgetSpeed.setDatas(3,1,5,0,36,5);
    }

    @OnClick({R.id.btn_actual_monitor_status_machine_time_expand, R.id.btn_actual_monitor_status_machine_process_expand, R.id.btn_actual_monitor_status_machine_error_expand, R.id.btn_actual_monitor_status_machine_dimension_expand, R.id.btn_actual_monitor_status_machine_speed_expand})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_actual_monitor_status_machine_time_expand:
                if (mWidgetTime.getVisibility() == View.GONE) {
                    mWidgetTime.startAnimation();
                    mWidgetTime.setVisibility(View.VISIBLE);
                } else
                    mWidgetTime.setVisibility(View.GONE);
                break;
            case R.id.btn_actual_monitor_status_machine_process_expand:
                if (mWidgetProcess.getVisibility() == View.GONE) {
                    mWidgetProcess.setVisibility(View.VISIBLE);
                    mWidgetProcess.show(true);
                } else {
                    mWidgetProcess.setVisibility(View.GONE);
                    mWidgetProcess.show(false);
                }
                break;
            case R.id.btn_actual_monitor_status_machine_error_expand:
                if (mWidgetErrorList.getVisibility() == View.GONE)
                    mWidgetErrorList.setVisibility(View.VISIBLE);
                else
                    mWidgetErrorList.setVisibility(View.GONE);
                break;
            case R.id.btn_actual_monitor_status_machine_dimension_expand:
                if (mWidgetProcedureDimension.getVisibility() == View.GONE)
                    mWidgetProcedureDimension.setVisibility(View.VISIBLE);
                else
                    mWidgetProcedureDimension.setVisibility(View.GONE);
                break;
            case R.id.btn_actual_monitor_status_machine_speed_expand:
                if (mWidgetSpeed.getVisibility() == View.GONE)
                    mWidgetSpeed.setVisibility(View.VISIBLE);
                else
                    mWidgetSpeed.setVisibility(View.GONE);
                break;
        }
    }

}
