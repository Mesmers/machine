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
 * Created by hehe on 2016/6/30.OEE分析
 */
public class OEEActivity extends BaseActivity implements View.OnClickListener,OnWheelChangedListener{

    @Bind(R.id.wheel_oee_date)
    WheelView mWheelDate;
    @Bind(R.id.wheel_oee_type)
    WheelView mWheelType;
    @Bind(R.id.wheel_oee_content)
    WheelView mWheelContent;

    private String[] type,dates;
    private Map<String,String[]> contentMaps;

    private String mCurrentDate, mCurrentType, mCurrentContent;

    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oee);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {
        mWheelDate.addChangingListener(this);
        mWheelType.addChangingListener(this);
        mWheelContent.addChangingListener(this);
    }

    @Override
    protected void initDatas() {
        dates = getResources().getStringArray(R.array.power_time_array);
        type = getResources().getStringArray(R.array.oee_type_array);
        contentMaps = new HashMap<>();
        contentMaps.put(type[0],getResources().getStringArray(R.array.oee_spec_array));
        contentMaps.put(type[1],getResources().getStringArray(R.array.oee_machine_array));
        contentMaps.put(type[2],getResources().getStringArray(R.array.oee_person_array));
        contentMaps.put(type[3], getResources().getStringArray(R.array.oee_procedure_array));

        mWheelDate.setViewAdapter(new ArrayWheelAdapter<>(this, dates));
        mWheelType.setViewAdapter(new ArrayWheelAdapter<>(this, type));

        mWheelDate.setCurrentItem(0);
        mWheelType.setCurrentItem(0);
        mCurrentDate = dates[0];
        mCurrentType = type[0];
        updateContent();
    }

    private void updateContent() {
        position = mWheelType.getCurrentItem();
        String[] datas = contentMaps.get(type[position]);
        mWheelContent.setViewAdapter(new ArrayWheelAdapter<>(this, datas));
        mWheelContent.setCurrentItem(0);
        mCurrentContent = datas[0];
    }

    @OnClick({R.id.i_btn_oee_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_oee_search:
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
                    case 3:
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
        if (wheel==mWheelType) {
            mCurrentType = type[wheel.getCurrentItem()];
            updateContent();
        }
        if (wheel==mWheelContent)
            mCurrentContent = contentMaps.get(type[position])[wheel.getCurrentItem()];
    }
}
