package com.tetris.djj.machine_m.activity.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.produce.ProduceProcessSpec;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.OnWheelChangedListener;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.WheelView;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.adapters.ArrayWheelAdapter;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.adapters.WheelViewAdapter;
import com.tetris.djj.machine_m.utils.ActivityManager;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.生产进度
 */
public class ProduceProcessActivity extends BaseActivity implements OnWheelChangedListener, View.OnClickListener {

    @Bind(R.id.wheel_produce_process_date)
    WheelView mWheelDate;
    @Bind(R.id.wheel_produce_process_setting)
    WheelView mWheelSetting;
    @Bind(R.id.wheel_produce_process_content)
    WheelView mWheelContent;

    private String[] dateDatas, settingDatas;
    private Map<String, String[]> contentMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce_process);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    private void updateContent() {
        int position = mWheelSetting.getCurrentItem();
        String[] datas = contentMaps.get(settingDatas[position]);
        mWheelContent.setViewAdapter(new ArrayWheelAdapter<>(this,datas));
        mWheelContent.setCurrentItem(0);
    }

    @Override
    protected void initEvents() {
        mWheelSetting.addChangingListener(this);
    }

    @Override
    protected void initDatas() {
        dateDatas = new String[]{"当天", "当周", "当月"};
        settingDatas = new String[]{"规格", "车间"};
        contentMaps = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            String[] datas = new String[5];
            for (int j = 0; j < 5; j++) {
                if (j==0)
                    datas[j] = "所有"+settingDatas[i];
                else
                    datas[j] = settingDatas[i]+j;
            }
            contentMaps.put(settingDatas[i], datas);
        }
        mWheelDate.setViewAdapter(new ArrayWheelAdapter<>(this,dateDatas));
        mWheelSetting.setViewAdapter(new ArrayWheelAdapter<>(this, settingDatas));
        mWheelDate.setCurrentItem(0);
        mWheelSetting.setCurrentItem(0);
        updateContent();
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        if (wheel == mWheelSetting)
            updateContent();
    }

    @OnClick({R.id.i_btn_produce_process_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i_btn_produce_process_search:
                Intent intent = new Intent(this, ProduceProcessSpec.class);
                startActivity(intent);
                break;
        }
    }
}
