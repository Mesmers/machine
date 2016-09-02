package com.tetris.djj.machine_m.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.tetris.djj.machine_m.BaseActivity;
import com.tetris.djj.machine_m.BaseApplication;
import com.tetris.djj.machine_m.R;
import com.tetris.djj.machine_m.activity.main.MainActivity;
import com.tetris.djj.machine_m.utils.ActivityManager;
import com.tetris.djj.machine_m.utils.PreferencesUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hehe on 2016/6/30.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{

    @Bind (R.id.btn_login_enter)
    Button mBtnLogin;
    @Bind(R.id.view_login_phone)
     View mViewPhone;
    @Bind(R.id.view_login_password)
     View mViewPassword;
    @Bind(R.id.et_login_phone)
     EditText mEtPhone;
    @Bind(R.id.et_login_password)
     EditText mEtPassword;
    @Bind(R.id.chb_login_save_password)
     CheckBox mCheckBoxPassWords;
    @Bind(R.id.btn_login_forget_password)
     Button mBtnForgetPassWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initEvents();
        initDatas();
    }

    public static void launch(BaseActivity from) {
        Intent intent = new Intent(from, LoginActivity.class);
        from.startActivity(intent);
    }

    @OnClick({R.id.btn_login_enter,R.id.btn_login_forget_password})
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_enter:
                PreferencesUtils.putString("userId",mEtPhone.getText().toString());
                PreferencesUtils.putString("password",mCheckBoxPassWords.isChecked()?mEtPassword.getText().toString():"");
                MainActivity.launch(LoginActivity.this);
//                appAction.login(mEtPhone.getText().toString(), mCheckBoxPassWords.getText().toString(), new ActionCallbackListener() {
//                    @Override
//                    public void onSuccess(int isSuc, String des, String datas) {
//
//                    }
//
//                    @Override
//                    public void onFailure(String errorEvent, String message) {
//
//                    }
//
//                    @Override
//                    public void onBefore() {
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//                });
                break;
            case R.id.btn_login_forget_password:

                break;
        }
    }

    class FocusChangerListener implements View.OnFocusChangeListener{

        private View v;

        public FocusChangerListener(View v){
            this.v = v;
        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus){
                this.v.setBackgroundResource(R.drawable.shape_et_bottom_bg_pressed);
            }else {
                this.v.setBackgroundResource(R.drawable.shape_et_bottom_bg_normal);
            }
        }
    }
    @Override
    protected void initEvents() {
        mEtPhone.setOnFocusChangeListener(new FocusChangerListener(mViewPhone));
        mEtPassword.setOnFocusChangeListener(new FocusChangerListener(mViewPassword));
    }

    @Override
    protected void initDatas() {
        mEtPhone.setText(BaseApplication.userId);
        mEtPassword.setText(BaseApplication.password);
    }
}
