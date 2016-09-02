package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/15.
 */
public class ProduceProcessSpecEntity {

    private String machineName,actualOutput,planOutput,finshChance;

    public ProduceProcessSpecEntity(String... s){
        machineName=s[0];
        actualOutput = s[1];
        planOutput = s[2];
        finshChance = s[3];
    }

    public ProduceProcessSpecEntity(){

    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getActualOutput() {
        return actualOutput;
    }

    public void setActualOutput(String actualOutput) {
        this.actualOutput = actualOutput;
    }

    public String getPlanOutput() {
        return planOutput;
    }

    public void setPlanOutput(String planOutput) {
        this.planOutput = planOutput;
    }

    public String getFinshChance() {
        return finshChance;
    }

    public void setFinshChance(String finshChance) {
        this.finshChance = finshChance;
    }
}
