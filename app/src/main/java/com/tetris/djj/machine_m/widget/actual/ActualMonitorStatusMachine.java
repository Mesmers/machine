package com.tetris.djj.machine_m.widget.actual;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import com.tetris.djj.machine_m.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/18.运作时间图
 */
public class ActualMonitorStatusMachine extends LinearLayout {

    private Context mContext;
    private View mView;

    @Bind(R.id.pie_chart_widget_actual_monitor_status_machine)
    PieChart mPieChartMachine;
    @Bind(R.id.tv_widget_actual_monitor_status_pie_machine_status)//机台状态
            TextView mTvMachineStatus;
    @Bind(R.id.tv_widget_actual_monitor_status_pie_start_machine_hours_num)//总开机时间
            TextView mTvMachineStartHours;
    @Bind(R.id.tv_widget_actual_monitor_status_pie_prepare_time)//准备时间
            TextView mTvPrepareTime;
    @Bind(R.id.tv_widget_actual_monitor_status_pie_error_time)//机故时间
            TextView mTvErrorTime;
    @Bind(R.id.tv_widget_actual_monitor_status_pie_halt_time)//停机时间
            TextView mTvHaltTime;
    @Bind(R.id.tv_widget_actual_monitor_status_pie_work_time)//运行时间
            TextView mTvWorkTime;

    private float density;

    public ActualMonitorStatusMachine(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_actual_monitor_status_pie, this, true);
        ButterKnife.bind(this, mView);
        density = mContext.getResources().getDisplayMetrics().density;
    }

    public void startAnimation(){
        mPieChartMachine.animateXY(1000, 1000);  //设置动画
    }

    public void setDatas(String... datas) {
        mTvMachineStatus.setText(datas[0]);
        mTvPrepareTime.setText(datas[1]);
        mTvErrorTime.setText(datas[2]);
        mTvHaltTime.setText(datas[3]);
        mTvWorkTime.setText(datas[4]);
        float result = 0;
        for (int i = 1 ; i<=4 ; i++ )
            result+=Float.parseFloat(datas[i]);
        mTvMachineStartHours.setText(String.valueOf(result));
        setPie(Float.parseFloat(datas[1]),Float.parseFloat(datas[2]),Float.parseFloat(datas[3]),Float.parseFloat(datas[4]));
    }

    private void setPie(float... data) {
        mPieChartMachine.setHoleRadius(0);  //实心圆
        mPieChartMachine.setTransparentCircleRadius(0f);// 设置中间透明圈的大小
        mPieChartMachine.setDescriptionTextSize(15*density);
        mPieChartMachine.setDescription("单位：小时");
        mPieChartMachine.setDrawSliceText(false);
        mPieChartMachine.setDrawHoleEnabled(true);
        mPieChartMachine.getLegend().setEnabled(false);
        mPieChartMachine.setRotationEnabled(true); // 可以手动旋转
        mPieChartMachine.setUsePercentValues(false);  //显示成百分比
        mPieChartMachine.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {

            }

            @Override
            public void onNothingSelected() {

            }
        });
        ArrayList<Integer> colors = new ArrayList<>();

        // 饼图颜色
        colors.add(ContextCompat.getColor(mContext, R.color.prepare_machine));
        colors.add(ContextCompat.getColor(mContext, R.color.error_machine));
        colors.add(ContextCompat.getColor(mContext, R.color.halt_machine));
        colors.add(ContextCompat.getColor(mContext, R.color.normal_machine));
        PieData mPieData = getPieData(colors, data);
        mPieChartMachine.setData(mPieData);
    }

    /**
     * @param colors
     * @param data
     */
    private PieData getPieData(ArrayList<Integer> colors, float... data) {

        ArrayList<Entry> yValues = new ArrayList<>();  //yVals用来表示封装每个饼块的实际数据

        String[] des = new String[data.length];
        // 饼图数据
        for (int i = 0; i < data.length; i++) {
            yValues.add(new Entry(data[i], i));
            des[i] = "";
        }
        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "");/*显示在比例图上*/
        pieDataSet.setSliceSpace(4f); //设置个饼状图之间的距离

        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(des, pieDataSet);
        pieData.setValueTextSize(12);
        return pieData;
    }


}
