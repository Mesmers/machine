package com.tetris.djj.machine_m.activity.main.home.inventory;

import android.os.Bundle;
import android.widget.ListView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.InventoryManagementRowAdapter;
import com.tetris.djj.machine_m.entity.InventoryEntity;
import com.tetris.djj.machine_m.entity.InventoryManagementRowEntity;
import com.tetris.djj.machine_m.widget.ProjectSearchText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/22.
 */
public class RowActivity extends BaseActivity {

    @Bind(R.id.widget_inventory_management_row_depot)//仓库
    ProjectSearchText mWidgetDepot;
    @Bind(R.id.widget_inventory_management_row_use_depot)//已用库位
    ProjectSearchText mWidgetUseDepot;
    @Bind(R.id.widget_inventory_management_row_surplus_depot)//剩余库位
    ProjectSearchText mWidgetSurplusDepot;
    @Bind(R.id.list_inventory_management_row_table)
    ListView mListTable;

    private static String[] materials = new String[]{"铜", "铝", "铁", "包带", "胶料1", "胶料2", "胶料3", "胶料4"};

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
        mWidgetDepot.setTextName("仓库");
        mWidgetDepot.setEditContent("原材料库1");

        mWidgetUseDepot.setTextName("已用库位");
        mWidgetUseDepot.setEditContent("80%");

        mWidgetSurplusDepot.setTextName("剩余库位");
        mWidgetSurplusDepot.setEditContent("1025个");

        initList();
    }

    private void initList(){
        List<InventoryEntity> entities = new ArrayList<>();
        for (int i = 0 ;i<8;i++)
            entities.add(new InventoryManagementRowEntity(0,((int)(Math.random()*2))==0?"需采购":"",materials[i],(int)(Math.random()*1000+200)+"",(int)(Math.random()*1000+200)+"",(int)(Math.random()*700+200)+"","经办人"+i,"供应商"+i));
        InventoryManagementRowAdapter adapter = new InventoryManagementRowAdapter(mApplication,mContext,entities);
        mListTable.setAdapter(adapter);
    }

}
