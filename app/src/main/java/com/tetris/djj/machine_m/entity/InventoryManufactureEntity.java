package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/22.
 */
public class InventoryManufactureEntity extends InventoryEntity {
    private String manufactureNum;//成品码
    private String manufactureType;//成品类型
    private String stock;//库存
    private String enterLibrary;//入库
    private String outLibrary;//出库
    private String operator;//经办人
    private String remark;//备注

    public InventoryManufactureEntity(int type){
        this.type = type;
    }
    public InventoryManufactureEntity(int type , String... datas){
        this.type = type;
        manufactureNum = datas[0];
        manufactureType = datas[1];
        stock = datas[2];
        enterLibrary = datas[3];
        outLibrary = datas[4];
        operator = datas[5];
        remark = datas[6];
    }

    public String getManufactureNum() {
        return manufactureNum;
    }

    public void setManufactureNum(String manufactureNum) {
        this.manufactureNum = manufactureNum;
    }

    public String getManufactureType() {
        return manufactureType;
    }

    public void setManufactureType(String manufactureType) {
        this.manufactureType = manufactureType;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
