package com.tetris.djj.machine_m.activity.main.home.inventory;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.InventoryManagementRowAdapter;
import com.tetris.djj.machine_m.entity.InventoryEntity;
import com.tetris.djj.machine_m.entity.InventoryManufactureEntity;
import com.tetris.djj.machine_m.widget.ProjectSearchText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/22.
 */
public class ManufacturesActivity extends BaseActivity {
    @Bind(R.id.widget_inventory_management_row_depot)//仓库
            ProjectSearchText mWidgetDepot;
    @Bind(R.id.widget_inventory_management_row_use_depot)//已用库位
            ProjectSearchText mWidgetUseDepot;
    @Bind(R.id.widget_inventory_management_row_surplus_depot)//剩余库位
            ProjectSearchText mWidgetSurplusDepot;
    @Bind(R.id.list_inventory_management_row_table)
    ListView mListTable;
    @Bind(R.id.tv_inventory_management_row_center_name)
    TextView mTvCenterName;

    @Bind(R.id.tv_inventory_management_row_status)
    TextView tvStatus;
    @Bind(R.id.tv_inventory_management_row_material_name)
    TextView tvMaterialName;
    @Bind(R.id.tv_inventory_management_row_surplus)
    TextView tvSurplus;
    @Bind(R.id.tv_inventory_management_row_enter_library)
    TextView tvEnterLibrary;
    @Bind(R.id.tv_inventory_management_row_out_library)
    TextView tvOutLibrary;
    @Bind(R.id.tv_inventory_management_row_operator)
    TextView tvOperator;
    @Bind(R.id.tv_inventory_management_row_supplier)
    TextView tvSupplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_management_row);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        mTvCenterName.setText("统计报表");

        mWidgetDepot.setTextName("仓库");
        mWidgetDepot.setEditContent("成品库1");

        mWidgetUseDepot.setTextName("饱和度");
        mWidgetUseDepot.setEditContent("80%");

        mWidgetSurplusDepot.setTextName("状态");
        mWidgetSurplusDepot.setEditContent("良好");

        tvStatus.setText("成品码");
        tvMaterialName.setText("成品类型");
        tvSurplus.setText("库存(个)");
        tvEnterLibrary.setText("入库(个)");
        tvOutLibrary.setText("出库(个)");
        tvOperator.setText("经办人");
        tvSupplier.setText("备注");

        initList();
    }

    private void initList() {
        List<InventoryEntity> entities = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            entities.add(new InventoryManufactureEntity(1,"成品码"+i,"成品"+i, (int)(Math.random() * 1000 + 200) + "",(int)( Math.random() * 1000 + 200) + "", (int)(Math.random() * 700 + 200 )+ "", "经办人" + i,((int) (Math.random() * 2)) == 0 ? "交货" : ""));
        InventoryManagementRowAdapter adapter = new InventoryManagementRowAdapter(mApplication, mContext, entities);
        mListTable.setAdapter(adapter);
    }
}
