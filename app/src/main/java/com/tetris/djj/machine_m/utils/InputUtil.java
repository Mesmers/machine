package com.tetris.djj.machine_m.utils;

import android.content.Context;
import android.hardware.input.InputManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by Adu on 2015/10/28.
 */
public class InputUtil {

    //隐藏软键盘
    public static void hideIM(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    //显示软键盘
    public static void showIM(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
    }

    //如果输入法在窗口上已经显示，则隐藏，反之则显示
    public static void autoIM(Context context, EditText editText) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    //isOpen若返回true，则表示输入法打开
    public static boolean isActiveIM(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return imm.isActive();
    }
}

