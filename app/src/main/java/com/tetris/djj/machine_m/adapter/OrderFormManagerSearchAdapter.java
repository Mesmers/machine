package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseArrayListAdapter;
import com.tetris.djj.machine_m.R;

import java.util.List;

/**
 * Created by hehe on 2016/7/14.
 */
public class OrderFormManagerSearchAdapter extends BaseArrayListAdapter {

    public OrderFormManagerSearchAdapter(Context context, List<String> datas) {
        super(context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_order_form_manager_search, parent, false);
            viewHolder.mTvProcedure = (TextView) convertView.findViewById(R.id.tv_item_order_form_manager_search_procedure);
            viewHolder.mTvProcedureProcess = (TextView) convertView.findViewById(R.id.tv_item_order_form_manager_search_procedure_process);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
            String[] data = mDatas.get(position).split("&");
            viewHolder.mTvProcedure.setText(data[0]);
            viewHolder.mTvProcedureProcess.setText(data[1]);
        return convertView;
    }

    class ViewHolder {
        TextView mTvProcedure, mTvProcedureProcess;
    }
}
