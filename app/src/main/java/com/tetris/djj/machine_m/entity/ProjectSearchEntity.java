package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/2.
 */
public class ProjectSearchEntity {

    private String date,workSheet,spec,classes,operator,taskMeter;

    public ProjectSearchEntity(String... params){
        date = params[0];
        workSheet = params[1];
        spec = params[2];
        classes = params[3];
        operator = params[4];
        taskMeter = params[5];
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWorkSheet() {
        return workSheet;
    }

    public void setWorkSheet(String workSheet) {
        this.workSheet = workSheet;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getTaskMeter() {
        return taskMeter;
    }

    public void setTaskMeter(String taskMeter) {
        this.taskMeter = taskMeter;
    }
}
