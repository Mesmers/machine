package com.tetris.djj.machine_m.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tetris.djj.machine_m.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hehe on 2016/7/2.
 */
public class ProjectSearchText extends LinearLayout {

    @Bind(R.id.et_widget_project_search_content)
    EditText mEtContent;
    @Bind(R.id.tv_widget_project_search_name)
    TextView mTvName;

    private View mView;
    private Context mContext;

    public ProjectSearchText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mView = LayoutInflater.from(context).inflate(R.layout.widget_viewgroup_project_search_text,this,true);
        ButterKnife.bind(this,mView);
        mContext = context;
    }

    public void setTextName(String text){
        if (mTvName!=null)
        mTvName.setText(text);
    }

    public void setEditContent(String text){
        if (mEtContent!=null)
        mEtContent.setText(text);
    }

}
