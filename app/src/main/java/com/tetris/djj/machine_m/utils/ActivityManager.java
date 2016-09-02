package com.tetris.djj.machine_m.utils;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * Created by djj on 2015/10/19 0019.
 * Activity管理类
 */
public class ActivityManager {
    private static Stack<Activity> activityStack;
    private static ActivityManager manager = null;
    /*是否第一次点击back键*/
    private static boolean firstClickBack = true;

    private ActivityManager(){

    }
    /*构建单一实例*/
    public static ActivityManager getInstance(){
        if(manager == null){
            manager = new ActivityManager();
        }
        return  manager;
    }

    /*添加Activity到栈*/
    public void addActivity(Activity activity){
        if(activityStack==null){
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /*获取当前Activity*/
    public Activity getCurrentActivity(){
        return activityStack.lastElement();
    }


    /*结束指定的Activity*/
    public void finishActivity(Activity activity){
        if(activity!=null) {
            activityStack.remove(activity);
            activity.finish();
        }
        activity=null;
    }

    /*结束指定类名的Activity*/
    public  void finishActivity(Class<?> cls){
        for (Activity activity : activityStack) {
            if(activity.getClass().equals(cls)){
                finishActivity(activity);
            }
        }
    }

    /*结束所有的Activity*/
    public void finishAllActivity(Context context){
//        LogcatHelper.getInstance(context).stop();
//        Log.e("close","成功关闭");
        int size = activityStack.size();
        for (int i = 0;i < size;i++){
            if(activityStack.get(i)!=null) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

//    /*双击退出当前应用*/
//    public void doubleClickExitApp(Context context){
//        if (firstClickBack) {
//            firstClickBack = false;
//            ReflectToast.makeText(context,"再按一次退出应用",1).show();
//            new Thread(new Runnable() {
//                public void run() {
//                    try {
//                        Thread.sleep(1500);
//                        firstClickBack = true;
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        } else {
//            ActivityManager.getInstance().finishAllActivity(context);
//        }
//    }
}
