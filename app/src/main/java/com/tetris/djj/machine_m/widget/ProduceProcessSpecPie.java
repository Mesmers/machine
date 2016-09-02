package com.tetris.djj.machine_m.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.Highlight;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.tetris.djj.machine_m.R;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/15.
 */
public class ProduceProcessSpecPie extends LinearLayout implements View.OnClickListener{

    private Context mContext;
    private View mView;

    @Bind(R.id.tv_widget_produce_process_spec_spec)//规格号
    TextView mTvSpec;
    @Bind(R.id.tv_widget_produce_process_spec_target_yield)//目标产量
    TextView mTvTargetYield;
    @Bind(R.id.tv_widget_produce_process_spec_finish_yield)//已完成量
    TextView mTvFinishYield;
    @Bind(R.id.tv_widget_produce_process_spec_finish_chance)//完成率
    TextView mTvFinishChance;
    @Bind(R.id.pie_chart_widget_produce_process_spec_spec)//规格饼状图
    PieChart mPieChartSpec;

    public ProduceProcessSpecPie(Context context) {
        super(context);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_produce_process_spec,this,true);
        ButterKnife.bind(this, mView);
    }

    public ProduceProcessSpecPie(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_produce_process_spec,this,true);
        ButterKnife.bind(this,mView);
    }

    public void setData(String... datas){
        mTvSpec.setText(datas[0]);
        mTvTargetYield.setText(datas[1]+"M");
        mTvFinishYield.setText(datas[2]+"M");
        mTvFinishChance.setText(datas[3]);
        setPie(Float.parseFloat(datas[2]),Float.parseFloat(datas[1])-Float.parseFloat(datas[2]));
    }

    private void setPie(float finish,float notFinish){
//        mPieChartSpec.setHoleColorTransparent(true);
//        pieChart.setHoleRadius(60f);  //半径
//        pieChart.setTransparentCircleRadius(64f); // 半透明圈
        mPieChartSpec.setHoleRadius(0);  //实心圆
        mPieChartSpec.setTransparentCircleRadius(0f);// 设置中间透明圈的大小
        mPieChartSpec.setDescription("");
        mPieChartSpec.setDrawSliceText(false);
        // mChart.setDrawYValues(true);
//        mPieChartSpec.setDrawCenterText(true);  //饼状图中间可以添加文字
        mPieChartSpec.setDrawHoleEnabled(true);
//        mPieChartSpec.setRotationAngle(90); // 初始旋转角度
        mPieChartSpec.setRotationEnabled(true); // 可以手动旋转
//        mPieChartSpec.setUsePercentValues(true);  //显示成百分比
//        mPieChartSpec.setCenterText("机台工作状况");  //饼状图中间的文字
        mPieChartSpec.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {

            }
            @Override
            public void onNothingSelected() {

            }
        });
        PieData mPieData = getPieData(4, 100,finish,notFinish);
        mPieChartSpec.setData(mPieData);
        Legend mLegend = mPieChartSpec.getLegend();  //设置比例图
        mLegend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);  //最右边显示
//        mLegend.setForm(Legend.LegendForm.LINE);  //设置比例图的形状，默认是方形
        mLegend.setXEntrySpace(7f);
        mLegend.setYEntrySpace(5f);
        mLegend.setYOffset(25f);
        mPieChartSpec.animateXY(2000, 2000);  //设置动画
    }

    /**
     *
     * @param count 分成几部分
     * @param range
     */
    private PieData getPieData(int count, float range,float finish,float notFinish) {

//        ArrayList<String> xValues = new ArrayList<>();  //xVals用来表示每个饼块上的内容
//
//        for (int i = 0; i < count; i++) {
//            xValues.add("");  //饼块上显示成Quarterly1, Quarterly2, Quarterly3, Quarterly4
//        }
//        xValues.add(4,"未加工");

        ArrayList<Entry> yValues = new ArrayList<>();  //yVals用来表示封装每个饼块的实际数据

        // 饼图数据
        float quarterly1 = finish;
        float quarterly2 = notFinish;

        yValues.add(new Entry(quarterly1, 0));
        yValues.add(new Entry(quarterly2, 1));

        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "");/*显示在比例图上*/
        pieDataSet.setSliceSpace(4f); //设置个饼状图之间的距离

        ArrayList<Integer> colors = new ArrayList<>();

        // 饼图颜色
        colors.add(ContextCompat.getColor(mContext,R.color.produce_process_spec_finish));
        colors.add(ContextCompat.getColor(mContext, R.color.produce_process_spec_not_finish));

        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(new String[]{"已完成量","未完成量"},pieDataSet);
        pieData.setValueTextSize(15);
//        pieData.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getFormattedValue(float v) {
//                return String.valueOf(v).split(".")[0];
//            }
//        });
        return pieData;
    }

    @Override
    public void onClick(View v) {

    }

}
