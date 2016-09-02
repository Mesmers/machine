package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseObjectListAdapter;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.ProjectSearchEntity;

import java.util.List;

/**
 * Created by hehe on 2016/7/2.
 */
public class ProjectSearchTableAdapter extends BaseObjectListAdapter<ProjectSearchEntity> {

    public ProjectSearchTableAdapter(BaseApplication application, Context context, List<ProjectSearchEntity> datas) {
        super(application, context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_project_search_table,parent,false);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_list_project_search_table_date);
            viewHolder.tvWorkSheet = (TextView) convertView.findViewById(R.id.tv_list_project_search_table_work_sheet);
            viewHolder.tvSpec = (TextView) convertView.findViewById(R.id.tv_list_project_search_table_spec);
            viewHolder.tvClasses = (TextView) convertView.findViewById(R.id.tv_list_project_search_table_classes);
            viewHolder.tvOperator = (TextView) convertView.findViewById(R.id.tv_list_project_search_table_operator);
            viewHolder.tvTaskMeter = (TextView) convertView.findViewById(R.id.tv_list_project_search_table_task_meter);
            convertView.setTag(viewHolder);
        }else
        viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.tvDate.setText(mDatas.get(position).getDate());
            viewHolder.tvWorkSheet.setText(mDatas.get(position).getWorkSheet());
            viewHolder.tvSpec.setText(mDatas.get(position).getSpec());
            viewHolder.tvClasses.setText(mDatas.get(position).getClasses());
            viewHolder.tvOperator.setText(mDatas.get(position).getOperator());
            viewHolder.tvTaskMeter.setText(mDatas.get(position).getTaskMeter());
        return convertView;
    }


    class ViewHolder{
        TextView tvDate,tvWorkSheet,tvSpec,tvClasses,tvOperator,tvTaskMeter;
    }
}
