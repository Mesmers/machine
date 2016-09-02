package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.BaseObjectListAdapter;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.entity.InventoryEntity;
import com.tetris.djj.machine_m.entity.InventoryManagementRowEntity;
import com.tetris.djj.machine_m.entity.InventoryManufactureEntity;

import java.util.List;

/**
 * Created by hehe on 2016/7/22.
 */
public class InventoryManagementRowAdapter extends BaseObjectListAdapter<InventoryEntity> {

    private static final int ROW = 0;
    private static final int Manufacture = 1;

    public InventoryManagementRowAdapter(BaseApplication application, Context context, List<InventoryEntity> datas) {
        super(application, context, datas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_inventory_management_row, parent, false);
            viewHolder.mTvStatus = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_status);
            viewHolder.mTvMaterial = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_material_name);
            viewHolder.mTvSurplus = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_surplus);
            viewHolder.mTvEnterLibrary = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_enter_library);
            viewHolder.mTvOutLibrary = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_out_library);
            viewHolder.mTvOperator = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_operator);
            viewHolder.mTvSupplier = (TextView) convertView.findViewById(R.id.tv_item_inventory_management_row_supplier);
            InventoryEntity mEntity = mDatas.get(position);
            switch (mEntity.getType()){
                case ROW:
                    viewHolder.mTvStatus.setTextColor(ContextCompat.getColor(mContext,R.color.inventory_status));
                    viewHolder.mTvMaterial.setTextColor(ContextCompat.getColor(mContext,R.color.inventory_material_name));
                    break;
                case Manufacture:
                    viewHolder.mTvMaterial.setTextColor(ContextCompat.getColor(mContext,R.color.inventory_manufacture_type));
                    viewHolder.mTvSupplier.setTextColor(ContextCompat.getColor(mContext,R.color.inventory_manufacture_remark));
                    break;
            }
            convertView.setTag(viewHolder);
        } else
            viewHolder = (ViewHolder) convertView.getTag();
        InventoryEntity mEntity = mDatas.get(position);
        switch (mEntity.getType()){
            case ROW:
                InventoryManagementRowEntity entity = (InventoryManagementRowEntity) mEntity;
                viewHolder.mTvStatus.setText(entity.getStatus());
                viewHolder.mTvMaterial.setText(entity.getMaterialName());
                viewHolder.mTvSurplus.setText(entity.getSurplus());
                viewHolder.mTvEnterLibrary.setText(entity.getEnterLibrary());
                viewHolder.mTvOutLibrary.setText(entity.getOutLibrary());
                viewHolder.mTvOperator.setText(entity.getOperator());
                viewHolder.mTvSupplier.setText(entity.getSupplier());
                break;
            case Manufacture:
                InventoryManufactureEntity manufactureEntity = (InventoryManufactureEntity) mEntity;
                viewHolder.mTvStatus.setText(manufactureEntity.getManufactureNum());
                viewHolder.mTvMaterial.setText(manufactureEntity.getManufactureType());
                viewHolder.mTvSurplus.setText(manufactureEntity.getStock());
                viewHolder.mTvEnterLibrary.setText(manufactureEntity.getEnterLibrary());
                viewHolder.mTvOutLibrary.setText(manufactureEntity.getOutLibrary());
                viewHolder.mTvOperator.setText(manufactureEntity.getOperator());
                viewHolder.mTvSupplier.setText(manufactureEntity.getRemark());
                break;
        }
        return convertView;
    }

    class ViewHolder {
        TextView mTvStatus, mTvMaterial, mTvSurplus, mTvEnterLibrary, mTvOutLibrary, mTvOperator, mTvSupplier;
    }
}
