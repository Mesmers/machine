package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/22.
 */
public class InventoryManagementRowEntity extends InventoryEntity{

    private String status;//状态
    private String materialName;//材料名称
    private String surplus;//剩余量
    private String enterLibrary;//入库
    private String outLibrary;//出库
    private String operator;//经办人
    private String supplier;//供应商

    public InventoryManagementRowEntity(int type){
         this.type = type;
    }

    public InventoryManagementRowEntity(int type,String... datas){
        this.type = type;
        status = datas[0];
        materialName = datas[1];
        surplus = datas[2];
        enterLibrary = datas[3];
        outLibrary = datas[4];
        operator = datas[5];
        supplier = datas[6];
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }

    public String getEnterLibrary() {
        return enterLibrary;
    }

    public void setEnterLibrary(String enterLibrary) {
        this.enterLibrary = enterLibrary;
    }

    public String getOutLibrary() {
        return outLibrary;
    }

    public void setOutLibrary(String outLibrary) {
        this.outLibrary = outLibrary;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
