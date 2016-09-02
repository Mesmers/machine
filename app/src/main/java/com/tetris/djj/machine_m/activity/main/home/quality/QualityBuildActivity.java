package com.tetris.djj.machine_m.activity.main.home.quality;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.QualityBackStrackingActivity;
import com.tetris.djj.machine_m.utils.ActivityManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/1.
 */
public class QualityBuildActivity extends BaseActivity {

    @Bind(R.id.tv_quality_build_work_sheet)
    TextView mTvWorkSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_build);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }



    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        mTvWorkSheet.setText(getIntent().getStringExtra("result"));
    }

}
