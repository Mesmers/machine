package com.tetris.djj.machine_m.widget.actual;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.ActualMonitorErrorListAdapter;
import com.tetris.djj.machine_m.entity.ActualErrorEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/18.
 */
public class ActualMonitorList extends LinearLayout implements View.OnClickListener{

    private Context mContext;
    private View mView;

    @Bind(R.id.list_actual_monitor_status_error)
    ListView mListError;

    private ActualMonitorErrorListAdapter adapter;

    private List<ActualErrorEntity> errorEntities ;

    public ActualMonitorList(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(mContext).inflate(R.layout.widget_viewgroup_actual_monitor_status_list,this,true);
        ButterKnife.bind(this,mView);
        initDatas();
    }

    public ListView getmListError() {
        return mListError;
    }

    public void setmListError(ListView mListError) {
        this.mListError = mListError;
    }

    private void initDatas(){
        errorEntities = new ArrayList<>();
        adapter = new ActualMonitorErrorListAdapter((BaseApplication) mContext.getApplicationContext(),mContext,errorEntities);
        mListError.setAdapter(adapter);
    }

    public void setDatas(List<ActualErrorEntity> entities){
        errorEntities = entities;
        adapter.setmDatas(errorEntities);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

    }
}
