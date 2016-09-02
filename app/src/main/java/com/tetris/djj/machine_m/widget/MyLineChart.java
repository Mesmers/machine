package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.utils.LineChartUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/18.
 */
public class MyLineChart extends LinearLayout {

    private Context mContext;
    private View mView;

    @Bind(R.id.line_chart_widget_actual_monitor_status_machine_speed)
    LineChart mLineChartSpeed;

    @Bind(R.id.tv_widget_line_chart_date)
    TextView mTvDate;

    @Bind(R.id.ll_widget_power_manager_search)
    LinearLayout mLinearPowerManagerSearch;
    @Bind(R.id.tv_widget_power_manager_search_power_use_sum)//总能耗
            TextView mTvPowerUseSum;
    @Bind(R.id.tv_widget_power_manager_search_power_rate_sum)//总电费
            TextView mTvPowerRateSum;

    public MyLineChart(Context context) {
        super(context);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_line_chart, this, true);
        ButterKnife.bind(this, mView);
    }

    public MyLineChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_line_chart, this, true);
        ButterKnife.bind(this, mView);
    }

    public void setDatas(float... datas) {
        LineChartUtils.romance(mLineChartSpeed, datas[0], datas[1], datas[2], datas[3], ContextCompat.getColor(mContext, R.color.axis_line_color));
        LineData mLineData = LineChartUtils.getLineData(ContextCompat.getColor(mContext, R.color.line_chart_line_color), datas[4], datas[5]);
        LineChartUtils.showChart(mLineChartSpeed, mLineData);
    }

    public void drawLinear(String... datas) {
        mLinearPowerManagerSearch.setVisibility(VISIBLE);
        mTvPowerUseSum.setText(datas[0]);
        mTvPowerRateSum.setText(datas[1]);
    }

    public void setDate(String text){
        mTvDate.setText(text);
    }
}
