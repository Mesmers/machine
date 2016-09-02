package com.tetris.djj.machine_m.activity.main.home.cost;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.CostMaterialManagerAdapter;
import com.tetris.djj.machine_m.entity.CostMaterialEntity;
import com.tetris.djj.machine_m.widget.MaterialPie;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/19.
 */
public class CostUseManagerActivity extends BaseActivity {

    @Bind(R.id.widget_cost_manager_material_material_pie)
    MaterialPie mMaterialPie;
    @Bind(R.id.list_cost_material_manager_material_cost_details)
    ListView mListMaterialCostDetails;
    @Bind(R.id.tv_cost_material_manager_material)//材料
            TextView mTvMaterial;
    @Bind(R.id.tv_cost_material_manager_dosage)//用量
            TextView mTvDosage;
    @Bind(R.id.tv_cost_material_manager_cost_sum)//总价格
            TextView mTvCostSum;
    @Bind(R.id.tv_cost_material_manager_prices_meter)//单价
            TextView mTvPricesMeter;
    @Bind(R.id.tv_cost_material_manager_material_details)
    TextView mTvMaterialDetails;

    private DecimalFormat df;

    private static String[] materials = new String[]{"机台S1", "机台S2", "机台S3", "机台S4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_material_manager);
        ButterKnife.bind(this);
        df = new java.text.DecimalFormat("#.#");
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        mMaterialPie.setCostName("能耗成本");

        mTvMaterialDetails.setText("超耗机台列表");

        mTvMaterial.setText("机台");
        mTvDosage.setText("任务(米)");
        mTvCostSum.setText("能耗(KWh)");
        mTvPricesMeter.setText("超耗");

        mMaterialPie.setDatas("WCD015H", "WYJY-42", "15000米", "1.5元/米");
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(this, R.color.procedure_one));
        colors.add(ContextCompat.getColor(this, R.color.procedure_two));
        colors.add(ContextCompat.getColor(this, R.color.procedure_three));
        colors.add(ContextCompat.getColor(this, R.color.procedure_four));
        mMaterialPie.setPie("能耗成本分布图", colors, new String[]{"工序1", "工序2", "工序3", "工序4"}, 40, 25, 20, 15);

        initAdapter();
    }

    private void initAdapter() {
        List<CostMaterialEntity> entities = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            entities.add(new CostMaterialEntity(materials[i], df.format(Math.random() * 3000 + 1000), df.format(Math.random() * 100+30), df.format(100 * Math.random())+"%"));
        CostMaterialManagerAdapter adapter = new CostMaterialManagerAdapter(mApplication, mContext, entities);
        mListMaterialCostDetails.setAdapter(adapter);
    }
}