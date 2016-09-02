package com.tetris.djj.machine_m.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.adapter.MainViewPagerAdapter;
import com.tetris.djj.machine_m.fragment.FragmentHome;
import com.tetris.djj.machine_m.fragment.FragmentSetting;
import com.tetris.djj.machine_m.fragment.FragmentTextBook;
import com.tetris.djj.machine_m.fragment.FragmentUser;
import com.tetris.djj.machine_m.utils.ActivityManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{

    @Bind(R.id.vpg_main)
    ViewPager mViewPager;
    @Bind(R.id.i_btn_main_textbook)
    ImageButton mImgBtnTextBook;
    @Bind(R.id.i_btn_main_home)
    ImageButton mImgBtnHome;
    @Bind(R.id.i_btn_main_setting)
    ImageButton mImgBtnSetting;
    @Bind(R.id.i_btn_main_user)
    ImageButton mImgBtnUser;

    private int currentPosition;
    private ImageButton[] mImgBtnBottom = new ImageButton[4];
    private List<Fragment> mFragments;
    private int[][] mBottomIcons  =  new int[][]{{R.mipmap.ic_main_textbook,R.mipmap.ic_main_textbook_focus},
                                               {R.mipmap.ic_main_home,R.mipmap.ic_main_home_focus},
                                               {R.mipmap.ic_main_setting,R.mipmap.ic_main_setting_focus},
                                               {R.mipmap.ic_main_user,R.mipmap.ic_main_user_focus}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        color = R.color.main_top_sys;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    public static void launch(BaseActivity from) {
        Intent intent = new Intent(from, MainActivity.class);
        from.startActivity(intent);
    }

    @Override
    protected void initEvents() {
        mImgBtnBottom[0] = mImgBtnTextBook;
        mImgBtnBottom[1] = mImgBtnHome;
        mImgBtnBottom[2] = mImgBtnSetting;
        mImgBtnBottom[3] = mImgBtnUser;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            ActivityManager.getInstance().finishAllActivity(this);
        }
        return true;
    }

    @Override
    protected void initDatas() {
        mFragments = new ArrayList<>();
        mFragments.add(new FragmentTextBook(mApplication,this,mContext));
        mFragments.add(new FragmentHome(mApplication,this,mContext));
        mFragments.add(new FragmentSetting(mApplication,this,mContext));
        mFragments.add(new FragmentUser(mApplication,this,mContext));
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(),this,mFragments);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(this);
        mViewPager.setCurrentItem(1);
        mViewPager.setOffscreenPageLimit(4);
        currentPosition = 1;
    }

    @OnClick({R.id.i_btn_main_textbook,R.id.i_btn_main_home,R.id.i_btn_main_setting,R.id.i_btn_main_user})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.i_btn_main_textbook:
                if (currentPosition!=0)
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.i_btn_main_home:
                if (currentPosition!=1)
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.i_btn_main_setting:
                if (currentPosition!=2)
                mViewPager.setCurrentItem(2,false);
                break;
            case R.id.i_btn_main_user:
                if (currentPosition!=3)
                mViewPager.setCurrentItem(3,false);
                break;
        }
    }

    private void invalidateBottomOrPage(int i){
        if (currentPosition == i)
            return;
        mImgBtnBottom[currentPosition].setImageResource(mBottomIcons[currentPosition][0]);
        currentPosition = i;
        mImgBtnBottom[currentPosition].setImageResource(mBottomIcons[currentPosition][1]);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        invalidateBottomOrPage(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
