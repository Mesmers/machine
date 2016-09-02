package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseObjectListAdapter;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.CostMaterialEntity;

import java.util.List;

/**
 * Created by hehe on 2016/7/20.
 */
public class CostMaterialManagerAdapter extends BaseObjectListAdapter<CostMaterialEntity> {

    public CostMaterialManagerAdapter(BaseApplication application, Context context, List<CostMaterialEntity> datas) {
        super(application, context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_cost_manager_material, parent, false);
            viewHolder.mTvMaterial = (TextView) convertView.findViewById(R.id.tv_item_cost_manager_material_material);
            viewHolder.mTvDosage = (TextView) convertView.findViewById(R.id.tv_item_cost_manager_material_dosage);
            viewHolder.mTvAggregatePrices = (TextView) convertView.findViewById(R.id.tv_item_cost_manager_material_aggregate_price);
            viewHolder.mTvPricesMeters = (TextView) convertView.findViewById(R.id.tv_item_cost_manager_material_prices_meter);
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        CostMaterialEntity entity = mDatas.get(position);
        viewHolder.mTvMaterial.setText(entity.getMaterial());
        viewHolder.mTvDosage.setText(entity.getDosage());
        viewHolder.mTvAggregatePrices.setText(entity.getAggregatePrice());
        viewHolder.mTvPricesMeters.setText(entity.getPricesMeter());
        return convertView;
    }

    class ViewHolder{
        TextView mTvMaterial,mTvDosage,mTvAggregatePrices,mTvPricesMeters;
    }
}
