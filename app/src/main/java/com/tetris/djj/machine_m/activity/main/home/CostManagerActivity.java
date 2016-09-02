package com.tetris.djj.machine_m.activity.main.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.cost.CostMaterialManagerActivity;
import com.tetris.djj.machine_m.activity.main.home.cost.CostUseManagerActivity;
import com.tetris.djj.machine_m.utils.ActivityManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.成本管理
 */
public class CostManagerActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.spinner_cost_manager_choose)
    Spinner mSpinnerChoose;
    @Bind(R.id.et_cost_manager_work_form)//工作单
            EditText mEtWorkForm;
    @Bind(R.id.et_cost_manager_spec)//规格
            EditText mEtSpec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_manager);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        String[] items = getResources().getStringArray(R.array.cost_manager_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_cost_manager, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerChoose.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String result = data.getStringExtra("result");
            fillDatas(result);
        }
    }

    private void fillDatas(String... datas) {
        mEtWorkForm.setText(datas[0]);
        mEtSpec.setText(datas[0]);
    }

    @OnClick({R.id.i_btn_cost_manager_back, R.id.btn_cost_manager_search, R.id.i_btn_cost_manager_qr_search})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.i_btn_cost_manager_back:
                ActivityManager.getInstance().finishActivity(this);
                break;
            case R.id.btn_cost_manager_search:
                Intent intent;
                if (mSpinnerChoose.getSelectedItem().toString().equals("材料"))
                    intent = new Intent(this, CostMaterialManagerActivity.class);
                else
                    intent = new Intent(this, CostUseManagerActivity.class);
                startActivity(intent);
                break;
            case R.id.i_btn_cost_manager_qr_search:
                Intent intents = new Intent(this, QualityBackStrackingActivity.class);
                intents.putExtra("start", true);
                startActivityForResult(intents, 0);
                break;
        }
    }
}
