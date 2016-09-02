package com.tetris.djj.machine_m.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.tetris.djj.machine_m.widget.ProduceProcessSpecPie;

import java.util.List;

/**
 * Created by hehe on 2016/7/15.
 */
public class ProduceProcessSpecPieAdapter extends PagerAdapter {

    private Context mContext;
    private List<ProduceProcessSpecPie> mViews;

    public ProduceProcessSpecPieAdapter(Context mContext,List<ProduceProcessSpecPie> mViews){
        this.mContext = mContext;
        this.mViews = mViews;
    }

    @Override
    public int getCount() {
        return mViews.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mViews.get(position));
        return mViews.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
