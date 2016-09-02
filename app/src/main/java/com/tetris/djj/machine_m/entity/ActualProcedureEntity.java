package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/17.
 */
public class ActualProcedureEntity {

    private String machineName;
    private int status;

    public ActualProcedureEntity(String machineName,int status){
        this.machineName = machineName;
        this.status = status;
    }

    public ActualProcedureEntity(){

    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
