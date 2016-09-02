package com.tetris.djj.machine_m.widget.actual;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.view.RoundRectView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/18.生产进度
 */
public class ActualMonitorStatusProcess extends LinearLayout implements View.OnClickListener{

    private Context mContext;
    private View mView;
    private RoundRectView mRoundProcess=null;
    private RelativeLayout.LayoutParams params;

    private float plan=0,finish=0;

    @Bind(R.id.rl_widget_actual_monitor_status_process_process)
    RelativeLayout mRlProcess;
    @Bind(R.id.tv_widget_actual_monitor_status_process_plan_product)
    TextView mTvPlanProduct;
    @Bind(R.id.tv_widget_actual_monitor_status_process_finish_product)
    TextView mTvFinishProduct;
    @Bind(R.id.tv_widget_actual_monitor_status_process_delivery_time)
    TextView mTvDeliveryTime;

    public ActualMonitorStatusProcess(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_actual_monitor_status_process,this,true);
        ButterKnife.bind(this, mView);
        initDatas();
    }

    private void initDatas(){
        mRoundProcess = new RoundRectView(mContext);
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
    }

    public void setDatas(String... datas){
        mTvPlanProduct.setText(datas[0]+"米");
        mTvFinishProduct.setText(datas[1]+"米");
        mTvDeliveryTime.setText(datas[2]);

        plan = Float.parseFloat(datas[0]);
        finish = Float.parseFloat(datas[1]);

        mRoundProcess.setData(finish/plan);
    }

    public void show(boolean isShow){
        if (!isShow)
            mRlProcess.removeAllViews();
        else {
            mRoundProcess.setData(finish/plan);
            mRlProcess.addView(mRoundProcess, params);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
