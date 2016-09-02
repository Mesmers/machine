package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseObjectListAdapter;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.ProduceProcessSpecEntity;

import java.util.List;

/**
 * Created by hehe on 2016/7/15.
 */
public class ProduceProcessSpecAdapter extends BaseObjectListAdapter<ProduceProcessSpecEntity> {

    public ProduceProcessSpecAdapter(BaseApplication application, Context context, List<ProduceProcessSpecEntity> datas) {
        super(application, context, datas);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_produce_process_spec_spec, parent, false);
            viewHolder.mTvMachineName = (TextView) convertView.findViewById(R.id.tv_item_produce_process_spec_spec_machine_name);
            viewHolder.mTvActualOutput = (TextView) convertView.findViewById(R.id.tv_item_produce_process_spec_spec_actual_output);
            viewHolder.mTvPlanOutput = (TextView) convertView.findViewById(R.id.tv_item_produce_process_spec_spec_plan_output);
            viewHolder.mTvFinishChance = (TextView) convertView.findViewById(R.id.tv_item_produce_process_spec_spec_finish_chance);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.mTvMachineName.setText(mDatas.get(position).getMachineName());
        viewHolder.mTvActualOutput.setText(mDatas.get(position).getActualOutput());
        viewHolder.mTvPlanOutput.setText(mDatas.get(position).getPlanOutput());
        viewHolder.mTvFinishChance.setText(mDatas.get(position).getFinshChance());
        return convertView;
    }

    class ViewHolder {
        TextView mTvMachineName, mTvActualOutput, mTvPlanOutput, mTvFinishChance;
    }
}