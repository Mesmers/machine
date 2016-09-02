package com.tetris.djj.machine_m.activity.main.home.produce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.ProduceProcessSpecAdapter;
import com.tetris.djj.machine_m.adapter.ProduceProcessSpecPieAdapter;
import com.tetris.djj.machine_m.entity.ProduceProcessSpecEntity;
import com.tetris.djj.machine_m.view.CircleView;
import com.tetris.djj.machine_m.widget.ProduceProcessSpecPie;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/15.
 */
public class ProduceProcessSpec extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.vpg_produce_process_spec_spec)
    ViewPager mVpgSpec;
    @Bind(R.id.ll_produce_process_spec_circle)
    LinearLayout mLinearCircle;
    @Bind(R.id.list_produce_process_spec_spec)
    ListView mListSpec;

    private List<ProduceProcessSpecEntity> entities;

    private CircleView[] circleViews;

    private int position = 0;

    private ProduceProcessSpecAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produce_process_spec);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {
        mVpgSpec.setOnPageChangeListener(this);
    }

    @Override
    protected void initDatas() {
        initList();
        List<ProduceProcessSpecPie> views = new ArrayList<>();
        circleViews = new CircleView[2];
        ProduceProcessSpecPie produceProcessSpecPie;
        for (int i = 0; i < 2; i++) {
            produceProcessSpecPie = new ProduceProcessSpecPie(this);
            produceProcessSpecPie.setData(new String[]{"BY-35*" + i, "950", "800", (int) ((800.0 / 950.0) * 100) + "%"});
            views.add(produceProcessSpecPie);
            CircleView circleView = new CircleView(this);
            mLinearCircle.addView(circleView);
            circleViews[i] = circleView;
        }
        ProduceProcessSpecPieAdapter adapter = new ProduceProcessSpecPieAdapter(this, views);
        mVpgSpec.setAdapter(adapter);
        circleViews[0].setSelect(true);
    }

    private synchronized void initList() {
        entities = new ArrayList<>();
        ProduceProcessSpecEntity entity;
        for (int i = 0; i < 10; i++) {
            if (i == 0)
                entity = new ProduceProcessSpecEntity("机台", "实际产量(米)", "计划产量(米)", "完成率");
            else
                entity = new ProduceProcessSpecEntity("M" + i, (int) (Math.random() * 1000) + "", (int) (Math.random() * 1000) + "", (int) (Math.random() * 100) + "%");
            entities.add(entity);
        }
        adapter = new ProduceProcessSpecAdapter(mApplication, mContext, entities);
        mListSpec.setAdapter(adapter);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    private void notifyAdapter() {
        entities = new ArrayList<>();
        ProduceProcessSpecEntity entity;
        for (int i = 0; i < 10; i++) {
            entity = new ProduceProcessSpecEntity("M" + i, (int) (Math.random() * 1000) + "", (int) (Math.random() * 1000) + "", (int) (Math.random() * 100) + "%");
            entities.add(entity);
        }
        adapter.setmDatas(entities);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onPageSelected(int position) {
        if (this.position == position)
            return;
        else {
            circleViews[this.position].setSelect(false);
            circleViews[position].setSelect(true);
            this.position = position;
            notifyAdapter();
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
