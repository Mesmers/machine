package com.tetris.djj.machine_m.activity.main.home.cost;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.ListView;

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
public class CostMaterialManagerActivity extends BaseActivity {

    @Bind(R.id.widget_cost_manager_material_material_pie)
    MaterialPie mMaterialPie;
    @Bind(R.id.list_cost_material_manager_material_cost_details)
    ListView mListMaterialCostDetails;

    private DecimalFormat df;

    private static String[] materials = new String[]{"铜", "铝", "铁", "包带", "胶料1", "胶料2", "胶料3", "胶料4"};

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
        mMaterialPie.setDatas("WCD015H", "WYJY-42", "15000米", "2元/米");
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(ContextCompat.getColor(this, R.color.glue_stock));
        colors.add(ContextCompat.getColor(this, R.color.copper));
        colors.add(ContextCompat.getColor(this, R.color.aluminum));
        colors.add(ContextCompat.getColor(this, R.color.tin));
        colors.add(ContextCompat.getColor(this, R.color.belting));
        mMaterialPie.setPie("材料成本分布图", colors, new String[]{"胶料", "铜", "铝", "锡", "包带"}, 30, 50, 5, 10, 5);

        initAdapter();
    }

    private void initAdapter() {
        List<CostMaterialEntity> entities = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            entities.add(new CostMaterialEntity(materials[i], df.format(Math.random() * 500 + 100), df.format(Math.random() * 1000), df.format(2 * Math.random())));
        CostMaterialManagerAdapter adapter = new CostMaterialManagerAdapter(mApplication, mContext, entities);
        mListMaterialCostDetails.setAdapter(adapter);
    }
}
