package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.content.Intent;
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
import com.github.mikephil.charting.utils.ValueFormatter;
import com.tetris.djj.machine_m.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/17.
 */
public class WorkShopPie extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;

    private DecimalFormat df;

    @Bind(R.id.pie_chart_widget_actual_monitor_search_workshop)
    PieChart mPieWorkShop;
    @Bind(R.id.tv_widget_actual_monitor_search_pie_workshop_status)//车间状态
            TextView mTvWorkshopStatus;
    @Bind(R.id.tv_widget_actual_monitor_search_pie_machine_num)//机台数
            TextView mTvMachineNum;
    @Bind(R.id.tv_widget_actual_monitor_search_pie_normal_machine)//正常机台
            TextView mTvNormalMachine;
    @Bind(R.id.tv_widget_actual_monitor_search_pie_halt_machine)//停机机台
            TextView mTvHaltMachine;
    @Bind(R.id.tv_widget_actual_monitor_search_pie_error_machine)//故障机台
            TextView mTvErrorMachine;

    public WorkShopPie(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_actual_monitor_search_pie, this, true);
        ButterKnife.bind(this, mView);
        df = new java.text.DecimalFormat("#.#");
    }

    public void setData(String... datas) {
        mTvWorkshopStatus.setText(datas[0]);
        mTvMachineNum.setText(datas[1] + "台");
        mTvNormalMachine.setText(datas[2] + "台");
        mTvHaltMachine.setText(datas[3] + "台");
        mTvErrorMachine.setText(datas[4] + "台");
        setPie(Float.parseFloat(datas[2]), Float.parseFloat(datas[3]), Float.parseFloat(datas[4]));
    }

    private void setPie(float... data) {
        mPieWorkShop.setHoleRadius(0);  //实心圆
        mPieWorkShop.setTransparentCircleRadius(0f);// 设置中间透明圈的大小
        mPieWorkShop.setDescription("");
        mPieWorkShop.setDrawSliceText(false);
        mPieWorkShop.setDrawHoleEnabled(true);
        mPieWorkShop.getLegend().setEnabled(false);
        mPieWorkShop.setRotationEnabled(true); // 可以手动旋转
        mPieWorkShop.setUsePercentValues(true);  //显示成百分比
        mPieWorkShop.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {

            }

            @Override
            public void onNothingSelected() {

            }
        });
        ArrayList<Integer> colors = new ArrayList<>();

        // 饼图颜色
        colors.add(ContextCompat.getColor(mContext, R.color.normal_machine));
        colors.add(ContextCompat.getColor(mContext, R.color.halt_machine));
        colors.add(ContextCompat.getColor(mContext, R.color.error_machine));
        PieData mPieData = getPieData(colors, data);
        mPieWorkShop.setData(mPieData);
        mPieWorkShop.animateXY(2000, 2000);  //设置动画
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
        pieData.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float v) {
                return df.format(v) + "%";
            }
        });
        return pieData;
    }

    @Override
    public void onClick(View v) {

    }
}
