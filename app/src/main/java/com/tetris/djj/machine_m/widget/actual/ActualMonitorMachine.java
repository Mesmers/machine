package com.tetris.djj.machine_m.widget.actual;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.actual.ActualMonitorProductStatusActivity;
import com.tetris.djj.machine_m.view.ProcedureCircleView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/17.
 */
public class ActualMonitorMachine extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;

    @Bind(R.id.pro_circle_widget_actual_monitor_procedure_machine_machine)
    ProcedureCircleView mCircleView;
    @Bind(R.id.tv_widget_actual_monitor_procedure_machine_machine)
    TextView mTvMachine;

    public ActualMonitorMachine(Context context) {
        super(context);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_actual_monitor_procedure_machine, this, true);
        ButterKnife.bind(this, mView);
    }

    public void setData(int color, String text) {
        mCircleView.setStatusColor(color);
        mTvMachine.setText(text);
    }

    @OnClick({R.id.pro_circle_widget_actual_monitor_procedure_machine_machine})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pro_circle_widget_actual_monitor_procedure_machine_machine:
                Intent intent = new Intent(mContext,ActualMonitorProductStatusActivity.class);
                mContext.startActivity(intent);
                break;
        }
    }
}
