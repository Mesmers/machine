package com.tetris.djj.machine_m.activity.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.inventory.ManufacturesActivity;
import com.tetris.djj.machine_m.activity.main.home.inventory.RowActivity;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.OnWheelChangedListener;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.WheelView;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.adapters.ArrayWheelAdapter;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.库存管理
 */
public class InventoryManagementActivity extends BaseActivity implements View.OnClickListener, OnWheelChangedListener {

    @Bind(R.id.wheel_inventory_management_date)
    WheelView mWheelDate;
    @Bind(R.id.wheel_inventory_management_material)
    WheelView mWheelMaterial;
    @Bind(R.id.wheel_inventory_management_content)
    WheelView mWheelContent;

    private String[] materials,dates;
    private Map<String,String[]> contentMaps;

    private String mCurrentDate, mCurrentMaterial, mCurrentContent;

    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_management);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {
        mWheelDate.addChangingListener(this);
        mWheelMaterial.addChangingListener(this);
        mWheelContent.addChangingListener(this);
    }

    @Override
    protected void initDatas() {
        dates = getResources().getStringArray(R.array.power_time_array);
        materials = getResources().getStringArray(R.array.inventory_management_material_array);
        contentMaps = new HashMap<>();
        contentMaps.put(materials[0],getResources().getStringArray(R.array.inventory_management_row_material_content_array));
        contentMaps.put(materials[1],getResources().getStringArray(R.array.inventory_management_semi_manufactures_content_array));
        contentMaps.put(materials[2],getResources().getStringArray(R.array.inventory_management_manufactures_content_array));

        mWheelDate.setViewAdapter(new ArrayWheelAdapter<>(this, dates));
        mWheelMaterial.setViewAdapter(new ArrayWheelAdapter<>(this, materials));

        mWheelDate.setCurrentItem(0);
        mWheelMaterial.setCurrentItem(0);
        mCurrentDate = dates[0];
        mCurrentMaterial = materials[0];
        updateContent();
    }

    private void updateContent() {
        position = mWheelMaterial.getCurrentItem();
        String[] datas = contentMaps.get(materials[position]);
        mWheelContent.setViewAdapter(new ArrayWheelAdapter<>(this,datas));
        mWheelContent.setCurrentItem(0);
        mCurrentContent = datas[0];
    }

    @OnClick({R.id.i_btn_inventory_management_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_inventory_management_search:
                Intent intent=null;
                switch (position){
                    case 0:
                        intent = new Intent(this, RowActivity.class);
                        break;
                    case 1:
                        intent = new Intent(this, ManufacturesActivity.class);
                        break;
                    case 2:
                        intent = new Intent(this, ManufacturesActivity.class);
                        break;
                }
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        if (wheel==mWheelDate)
            mCurrentDate = dates[wheel.getCurrentItem()];
        if (wheel==mWheelMaterial) {
            mCurrentMaterial = materials[wheel.getCurrentItem()];
            updateContent();
        }
        if (wheel==mWheelContent)
            mCurrentContent = contentMaps.get(materials[position])[wheel.getCurrentItem()];
    }
}
