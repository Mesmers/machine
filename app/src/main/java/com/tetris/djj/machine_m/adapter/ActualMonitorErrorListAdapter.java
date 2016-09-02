package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseObjectListAdapter;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.ActualErrorEntity;

import java.util.List;

/**
 * Created by hehe on 2016/7/18.
 */
public class ActualMonitorErrorListAdapter extends BaseObjectListAdapter<ActualErrorEntity> {

    public ActualMonitorErrorListAdapter(BaseApplication application, Context context, List<ActualErrorEntity> datas) {
        super(application, context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_actual_monitor_error, parent, false);
            viewHolder.mTvErrorPoint = (TextView) convertView.findViewById(R.id.tv_item_actual_monitor_error_point);
            viewHolder.mTvErrorType = (TextView) convertView.findViewById(R.id.tv_item_actual_monitor_error_type);
            viewHolder.mTvErrorTime = (TextView) convertView.findViewById(R.id.tv_item_actual_monitor_error_time);
            viewHolder.mTvHaltTime = (TextView) convertView.findViewById(R.id.tv_item_actual_monitor_halt_time);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        ActualErrorEntity entity = mDatas.get(position);
        viewHolder.mTvErrorPoint.setText(entity.getErrorPoint());
        viewHolder.mTvErrorType.setText(entity.getErrorType());
        viewHolder.mTvErrorTime.setText(entity.getErrorTime());
        viewHolder.mTvHaltTime.setText(entity.getHaltTime());
        return convertView;
    }

    class ViewHolder {
        TextView mTvErrorPoint, mTvErrorType,mTvErrorTime,mTvHaltTime;
    }
}
