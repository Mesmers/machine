package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/18.
 */
public class ActualErrorEntity {

    private String errorPoint,errorType,errorTime,haltTime;

    public ActualErrorEntity(){

    }

    public ActualErrorEntity(String... datas){
        errorPoint=datas[0];
        errorType=datas[1];
        errorTime=datas[2];
        haltTime=datas[3];
    }

    public String getErrorPoint() {
        return errorPoint;
    }

    public void setErrorPoint(String errorPoint) {
        this.errorPoint = errorPoint;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(String errorTime) {
        this.errorTime = errorTime;
    }

    public String getHaltTime() {
        return haltTime;
    }

    public void setHaltTime(String haltTime) {
        this.haltTime = haltTime;
    }
}
