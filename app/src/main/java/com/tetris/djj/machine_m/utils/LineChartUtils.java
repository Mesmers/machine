package com.tetris.djj.machine_m.utils;

import android.graphics.Color;
import android.graphics.Typeface;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by hehe on 2016/7/18.
 */
public class LineChartUtils {

    // 设置显示的样式
    public static void showChart(LineChart lineChart, LineData lineData) {

        lineChart.setDrawBorders(false);  //是否在折线图上添加边框

        // no description text
        lineChart.setDescription("");// 数据描述
        // 如果没有数据的时候，会显示这个，类似listview的emtpyview
        // lineChart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable / disable grid background
        lineChart.setDrawGridBackground(false); // 是否显示表格颜色
        lineChart.setGridBackgroundColor(Color.WHITE & 0x70FFFFFF); // 表格的的颜色，在这里是是给颜色设置一个透明度

        // enable touch gestures
        lineChart.setTouchEnabled(true); // 设置是否可以触摸

        // enable scaling and dragging
        lineChart.setDragEnabled(true);// 是否可以拖拽
        lineChart.setScaleEnabled(true);// 是否可以缩放
        lineChart.setScaleMinima(2,0);

        // if disabled, scaling can be done on x- and y-axis separately
        lineChart.setPinchZoom(false);
        //设置网格底下的那条线的颜色
        lineChart.setBorderColor(Color.rgb(213, 216, 214));
//        lineChart.setBackgroundColor(color);// 设置背景
        // add data
        lineChart.setData(lineData); // 设置数据
        // get the legend (only possible after setting data)
        Legend mLegend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        mLegend.setEnabled(false);
        // modify the legend ...
        // mLegend.setPosition(LegendPosition.LEFT_OF_CHART);
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(6f);// 字体
        mLegend.setTextColor(Color.WHITE);// 颜色
//      mLegend.setTypeface(mTf);// 字体

        lineChart.animateX(2500); // 立即执行的动画,x轴
    }

    /**
     * 生成一个数据
     *
     * @param count 表示图表中有多少个坐标点
     * @param range 用来生成range以内的随机数
     * @return
     */
    public static LineData getLineData(int color, float count, float range) {
        ArrayList<String> xValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // x轴显示的数据，这里默认使用数字下标显示
            xValues.add("" + i);
        }

        // y轴的数据
        ArrayList<Entry> yValues = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            float value = (float) (Math.random() * range);
            yValues.add(new Entry(value, i));
        }

        // create a dataset and give it a type
        // y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "" /*显示在比例图上*/);
        // mLineDataSet.setFillAlpha(110);
        // mLineDataSet.setFillColor(Color.RED);
        //用y轴的集合来设置参数
        lineDataSet.setLineWidth(1.75f); // 线宽
        lineDataSet.setColor(color);// 显示颜色
        lineDataSet.setCircleSize(0);

        ArrayList<LineDataSet> lineDataSets = new ArrayList<>();
        lineDataSets.add(lineDataSet); // add the datasets

        // create a data object with the datasets
        LineData lineData = new LineData(xValues, lineDataSets);
        return lineData;
    }

    public static void romance(LineChart chart, float up, float under, float max, float min, int color) {
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setEnabled(true);
        yAxis.setAxisLineColor(color);
        yAxis.setDrawAxisLine(true);
        yAxis.setDrawLabels(true);
        yAxis.setTextColor(Color.BLACK);
        yAxis.setAxisLineWidth(2);
        yAxis.setLabelCount(8);
        yAxis.setAxisMaxValue(max);
        yAxis.setAxisMinValue(min);
        yAxis.setDrawGridLines(true);
        yAxis.setGridColor(Color.BLACK);
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setStartAtZero(false);
        YAxis yAxis2 = chart.getAxisRight();
        yAxis2.setEnabled(false);
        LimitLine lt = new LimitLine(up);
        lt.setLineColor(Color.RED);
        lt.setLineWidth(2);
        lt.enableDashedLine(10, 5, 0);
        LimitLine ll = new LimitLine(under);
        ll.setLineColor(Color.RED);
        ll.setLineWidth(2);
        ll.enableDashedLine(10, 5, 0);
        yAxis.addLimitLine(ll);
        yAxis.addLimitLine(lt);
        XAxis xAxis = chart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setAxisLineColor(color);
        xAxis.setDrawLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(10);
        xAxis.setAvoidFirstLastClipping(false);
        xAxis.setAxisLineWidth(1);
        xAxis.setSpaceBetweenLabels(0);
//        xAxis.setAxisLineColor(Color.YELLOW);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTypeface(Typeface.SERIF);
        xAxis.setTextColor(Color.BLACK);
    }

}
