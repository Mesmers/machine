package com.tetris.djj.machine_m.activity.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.project.ProjectSearchActivity;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.OnWheelChangedListener;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.WheelView;
import com.tetris.djj.machine_m.api.kankan.wheel.widget.adapters.ArrayWheelAdapter;
import com.tetris.djj.machine_m.utils.ActivityManager;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.排产
 */
public class ProjectActivity extends BaseActivity implements OnWheelChangedListener,View.OnClickListener{

    @Bind(R.id.wheel_project_left)
    WheelView mWheelLeft;
    @Bind(R.id.wheel_project_right)
    WheelView mWheelRight;


    private String[] leftDatas;
    private Map<String,String[]> rightDatas = new HashMap<>();
    private String mCurrentLeft,mCurrentRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {
        mWheelLeft.addChangingListener(this);
        mWheelRight.addChangingListener(this);
    }

    @Override
    protected void initDatas() {
        leftDatas = new String[2];
        leftDatas[0]="规格";
        leftDatas[1]="机台";
        for (int i = 0 ; i < 2 ; i++){
            String[] right = new String[5];
            for (int j = 0 ; j < 5 ; j++){
                if (j==0)
                    right[j] = "所有"+leftDatas[i];
                else
                right[j] = leftDatas[i]+j;
            }
            rightDatas.put(leftDatas[i],right);
        }
        mWheelLeft.setViewAdapter(new ArrayWheelAdapter<>(this, leftDatas));
        mWheelLeft.setCurrentItem(0);
        updateRight();
    }

    private void updateRight(){
        int position = mWheelLeft.getCurrentItem();
        mCurrentLeft = leftDatas[position];
        String[] right = rightDatas.get(mCurrentLeft);
        mWheelRight.setViewAdapter(new ArrayWheelAdapter<>(this, right));
        mWheelRight.setCurrentItem(0);
    }

    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        if (wheel==mWheelLeft){
           updateRight();
        }else if (wheel==mWheelRight){
            mCurrentRight = rightDatas.get(mCurrentLeft)[newValue];
        }
    }

    @OnClick({R.id.i_btn_project_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_project_search:
                Intent intent = new Intent(this, ProjectSearchActivity.class);
                intent.putExtra("data",mCurrentLeft);
                startActivity(intent);
                break;
        }
    }
}
