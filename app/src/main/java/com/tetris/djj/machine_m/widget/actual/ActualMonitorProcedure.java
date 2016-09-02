package com.tetris.djj.machine_m.widget.actual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.ActualProcedureEntity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/17.
 */
public class ActualMonitorProcedure extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private View mView;

    @Bind(R.id.tv_widget_actual_monitor_search_procedure_procedure)
    TextView mTvProcedure;
    @Bind(R.id.tl_widget_actual_monitor_search_procedure_procedure)
    TableLayout mTbProcedure;

    private TableRow mTrMachine = null;

    private ActualMonitorMachine mWidgetMachine;

    private static int[] colors = new int[]{R.color.normal_machine, R.color.halt_machine, R.color.error_machine};

    private TableRow.LayoutParams mLlParams;
    private TableLayout.LayoutParams mTrParams;

    private float density;

    public ActualMonitorProcedure(Context context) {
        super(context);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_actual_monitor_search_procedure, this, true);
        ButterKnife.bind(this, mView);
        density = mContext.getResources().getDisplayMetrics().density;
        initParams();
        initView();
    }

    private void initParams() {
        mLlParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT, 1);

        mTrParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTrParams.setMargins(0,0,0, (int) (10*density));
    }

    private void initView() {
        if (!(mTrMachine != null && mTrMachine.getChildCount() < 4)) {
            mTrMachine = new TableRow(mContext);
            mTrMachine.setLayoutParams(mTrParams);
            mTrMachine.setWeightSum(4);
        }

        mWidgetMachine = new ActualMonitorMachine(mContext);
        mWidgetMachine.setLayoutParams(mLlParams);

    }

    public void setData(String text, List<ActualProcedureEntity> entities) {
        mTvProcedure.setText(text);
        int size = entities.size();
        ActualProcedureEntity entity;
        for (int i = 0; i < size; i++) {
            entity = entities.get(i);
            initView();
            mWidgetMachine.setData(colors[entity.getStatus()],entity.getMachineName());
            if (i != size - 1)
                addTrView(false);
            else
                addTrView(true);
        }
    }

    private void addTrView(boolean end) {
        mTrMachine.addView(mWidgetMachine);
        if (!end && mTrMachine.getChildCount() == 4) {
            mTbProcedure.addView(mTrMachine);
        }
        if (end) {
            int count = mTrMachine.getChildCount();
            LinearLayout linearLayout;
            for (int i = count; i <= 4; i++) {
                linearLayout = new LinearLayout(mContext);
                linearLayout.setOrientation(VERTICAL);
                linearLayout.setLayoutParams(mLlParams);
                mTrMachine.addView(linearLayout);
            }
            mTbProcedure.addView(mTrMachine);
        }
    }

    @Override
    public void onClick(View v) {

    }

}
