package com.tetris.djj.machine_m.activity.main.home.project;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.home.ProjectActivity;
import com.tetris.djj.machine_m.adapter.ProjectSearchTableAdapter;
import com.tetris.djj.machine_m.entity.ProjectSearchEntity;
import com.tetris.djj.machine_m.utils.ActivityManager;
import com.tetris.djj.machine_m.widget.ProjectSearchText;
import com.tetris.djj.machine_m.widget.TitleText;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/7/1.
 */
public class ProjectSearchActivity extends BaseActivity {

//    @Bind(R.id.tv_project_search_title)
//    TextView mTvTitle;
    @Bind(R.id.widget_project_search_title)
    TitleText mWidgetTitle;
    @Bind(R.id.widget_project_search_date)//交货日期
    ProjectSearchText mWidgetDate;
    @Bind(R.id.widget_project_search_time)//计划完成时间
    ProjectSearchText mWidgetTime;
    @Bind(R.id.widget_project_search_task_num)//任务数量
    ProjectSearchText mWidgetTaskNum;
    @Bind(R.id.widget_project_search_params_one)//参数1
    ProjectSearchText mWidgetParamOne;
    @Bind(R.id.widget_project_search_params_two)//参数2
    ProjectSearchText mWidgetParamTwo;
    @Bind(R.id.widget_project_search_params_three)//参数3
    ProjectSearchText mWidgetParamThree;
    @Bind(R.id.tv_project_search_table_name)
    TextView mTvTableName;
    @Bind(R.id.list_project_search_table)
    ListView mListTable;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_search);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    @Override
    protected void initEvents() {

    }

    @Override
    protected void initDatas() {
        title = getIntent().getStringExtra("data");
        mWidgetTitle.setTitle(title+"排产");
        setParam(mWidgetDate, "交货日期", "2016-7-1");
        setParam(mWidgetTime,"计划完成时间","2016-9-1");
        setParam(mWidgetTaskNum,"任务数量","10000米");
        setParam(mWidgetParamOne,title.equals("机台")?"温度":"厚度",title.equals("机台")?"50~60℃":"0.9~1.0mm");
        setParam(mWidgetParamTwo,title.equals("机台")?"速度":"绞距",title.equals("机台")?"2000m/s":"70~90mm");
        setParam(mWidgetParamThree,title.equals("机台")?"张力":"外径",title.equals("机台")?"20~30N":"6.9~7.0mm");

        List<ProjectSearchEntity> datas = new ArrayList<>();
        for (int i = 0 ; i<10 ; i++)
        datas.add(new ProjectSearchEntity("2015-06-01","CDWM1","规格1","白天","小王","4000"));
        ProjectSearchTableAdapter adapter = new ProjectSearchTableAdapter(mApplication,this,datas);
        mListTable.setAdapter(adapter);
    }

    private void setParam(ProjectSearchText param,String... text){
        param.setTextName(text[0]);
        param.setEditContent(text[1]);
    }

}
