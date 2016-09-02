package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
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
 * Created by hehe on 2016/7/20.
 */
public class MaterialPie extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;

    @Bind(R.id.tv_widget_cost_manager_material_shop_num)//订单号
            TextView mTvShopNum;
    @Bind(R.id.tv_widget_cost_manager_material_spec_num)//规格号
            TextView mTvSpecNum;
    @Bind(R.id.tv_widget_cost_manager_material_target_num)//目标数量
            TextView mTvTargetNum;
    @Bind(R.id.tv_widget_cost_manager_material_cost)//材料成本
            TextView mTvCost;
    @Bind(R.id.pie_chart_widget_cost_manager_material)//材料成本分步图
            PieChart mPieChartMaterial;
    @Bind(R.id.tv_widget_cost_manager_material_cost_name)
    TextView mTvCostName;

    private DecimalFormat df;

    public MaterialPie(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_cost_manager_material_pie, this, true);
        ButterKnife.bind(this, mView);
        df = new java.text.DecimalFormat("#.#");
    }

    public void setCostName(String data){
        mTvCostName.setText(data);
    }

    public void setDatas(String... datas) {
        mTvShopNum.setText(datas[0]);
        mTvSpecNum.setText(datas[1]);
        mTvTargetNum.setText(datas[2]);
        mTvCost.setText(datas[3]);
    }

    public void setPie(String description,ArrayList<Integer> colors,String[] labels,float... data) {
        mPieChartMaterial.setHoleRadius(0);  //实心圆
        mPieChartMaterial.setTransparentCircleRadius(0f);// 设置中间透明圈的大小
        mPieChartMaterial.setDescription(description);
        mPieChartMaterial.setDescriptionTextSize(15);
        mPieChartMaterial.setDrawSliceText(false);
        mPieChartMaterial.setDrawHoleEnabled(true);
        mPieChartMaterial.setRotationEnabled(true); // 可以手动旋转
        mPieChartMaterial.setUsePercentValues(true);  //显示成百分比
        mPieChartMaterial.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight) {

            }

            @Override
            public void onNothingSelected() {

            }
        });
        PieData mPieData = getPieData(colors,labels, data);
        mPieChartMaterial.setData(mPieData);
        Legend mLegend = mPieChartMaterial.getLegend();  //设置比例图
        mLegend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        mLegend.setForm(Legend.LegendForm.SQUARE);  //设置比例图的形状，默认是方形
        mPieChartMaterial.animateXY(2000, 2000);  //设置动画
    }

    /**
     * @param colors
     * @param data
     */
    private PieData getPieData(ArrayList<Integer> colors,String[] labels ,float... data) {

        ArrayList<Entry> yValues = new ArrayList<>();  //yVals用来表示封装每个饼块的实际数据

        String[] des = labels;
        // 饼图数据
        for (int i = 0; i < data.length; i++) {
            yValues.add(new Entry(data[i], i));
        }
        //y轴的集合
        PieDataSet pieDataSet = new PieDataSet(yValues, "");/*显示在比例图上*/
        pieDataSet.setSliceSpace(0f); //设置个饼状图之间的距离

        pieDataSet.setColors(colors);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float px = 5 * (metrics.densityDpi / 160f);
        pieDataSet.setSelectionShift(px); // 选中态多出的长度
        PieData pieData = new PieData(des, pieDataSet);
        pieData.setValueTextSize(10);
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
