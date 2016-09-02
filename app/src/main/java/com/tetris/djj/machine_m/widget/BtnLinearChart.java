package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.tetris.djj.machine_m.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/22.
 */
public class BtnLinearChart extends LinearLayout implements View.OnClickListener{

    private Context mContext;
    private View mView;

    @Bind(R.id.line_chart_widget_btn_linear_expand)
    MyLineChart mLineChartExpand;

    public BtnLinearChart(Context context, AttributeSet attrs) {
        super(context,attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_view_group_btn_linear, this, true);
        ButterKnife.bind(this, mView);
    }

    public MyLineChart getmLineChartExpand() {
        return mLineChartExpand;
    }

    @OnClick({R.id.btn_widget_btn_linear_expand})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_widget_btn_linear_expand:
                if (mLineChartExpand.getVisibility() == View.GONE)
                    mLineChartExpand.setVisibility(View.VISIBLE);
                else
                    mLineChartExpand.setVisibility(View.GONE);
                break;
        }
    }
}
