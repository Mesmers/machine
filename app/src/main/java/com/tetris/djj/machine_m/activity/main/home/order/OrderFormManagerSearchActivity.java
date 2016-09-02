package com.tetris.djj.machine_m.activity.main.home.order;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.OrderFormManagerSearchAdapter;
import com.tetris.djj.machine_m.view.MyLineArrow;
import com.tetris.djj.machine_m.view.MyProcedureFlow;
import com.tetris.djj.machine_m.view.MyTextView;
import com.tetris.djj.machine_m.view.ProcedureFlowView;
import com.tetris.djj.machine_m.view.ProcessFlowView;
import com.tetris.djj.machine_m.widget.MeasureListView;
import com.tetris.djj.machine_m.widget.TitleText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/2.
 */
public class OrderFormManagerSearchActivity extends BaseActivity {

    @Bind(R.id.ll_order_form_manager_search_procedure)
    LinearLayout mLinearProcedure;
    @Bind(R.id.scroll_order_form_manager_search)
    ScrollView mScrollView;
    @Bind(R.id.list_order_form_manager_search_procedure)
    ListView mListProcedure;
    @Bind(R.id.procedure_flow_view_order_form_manager_search)
    ProcedureFlowView mProcedureFlowView;
    @Bind(R.id.tv_order_form_manager_search_delivery_date)
    TextView mTvDeliveryDate;//交货时间
    @Bind(R.id.tv_order_form_manager_search_complete_date)
    TextView mTvCompleteDate;//完工时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form_manager_search);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void initEvents() {
        //监听LinearLayout是否绘制完毕
        ViewTreeObserver vto = mLinearProcedure.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mLinearProcedure.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                ProcessFlowView mProcessFlowView = new ProcessFlowView(OrderFormManagerSearchActivity.this, new String[]{"工序1", "工序2", "工序3", "工序4", "工序5", "工序6", "工序7", "工序4", "工序5", "工序6", "工序7"}, new int[]{R.color.procedure_1, R.color.procedure_2, R.color.procedure_3, R.color.procedure_2, R.color.procedure_2, R.color.procedure_3, R.color.procedure_1, R.color.procedure_2, R.color.procedure_3, R.color.procedure_1, R.color.procedure_1}, mLinearProcedure.getWidth(), mLinearProcedure.getHeight());
                mProcessFlowView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                mLinearProcedure.addView(mProcessFlowView);
            }
        });

        mScrollView.smoothScrollTo(0,0);
        //监听ScrollView和ListView的滑动
        mListProcedure.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mListProcedure.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
        mScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mListProcedure.getParent().requestDisallowInterceptTouchEvent(false);
                return false;
            }
        });
    }

    private void addData(){
        List<String> datas = new ArrayList<>();
        datas.add("工序1"+"&"+"100%");
        datas.add("工序2"+"&"+"80%");
        datas.add("工序3"+"&"+"70%");
        datas.add("工序4"+"&"+"30%");
        datas.add("工序5"+"&"+"50%");
        datas.add("工序6"+"&"+"90%");
        datas.add("工序7"+"&"+"80%");
        datas.add("工序4"+"&"+"0%");
        datas.add("工序5"+"&"+"10%");
        datas.add("工序6"+"&"+"20%");
        datas.add("工序7" + "&" + "35%");
        Log.e("data", datas.size() + "");
        OrderFormManagerSearchAdapter adapter = new OrderFormManagerSearchAdapter(this,datas);
        mListProcedure.setAdapter(adapter);
    }

    @Override
    protected void initDatas() {
        mTvDeliveryDate.setText("交货日期：" + "2016-7-14");
        mTvCompleteDate.setText("预计完工日期：" + "2016-7-14");
        addData();
        mProcedureFlowView.setText("70");
    }
}
