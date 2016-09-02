package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/14.
 */
public class OrderFormManagerSearchEntity {

    private String procedure, procedure_process;

    public OrderFormManagerSearchEntity(String... s) {
        procedure = s[0];
        procedure_process = s[1];
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getProcedure_process() {
        return procedure_process;
    }

    public void setProcedure_process(String procedure_process) {
        this.procedure_process = procedure_process;
    }
}
