package com.tetris.djj.machine_m.entity;

/**
 * Created by hehe on 2016/7/20.
 */
public class CostMaterialEntity {

    private String material;//材料
    private String dosage;//用量
    private String aggregatePrice;//总价格
    private String pricesMeter;//元/米

    public CostMaterialEntity(){

    }

    public CostMaterialEntity(String... datas){
        material=datas[0];
        dosage = datas[1];
        aggregatePrice = datas[2];
        pricesMeter = datas[3];
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getAggregatePrice() {
        return aggregatePrice;
    }

    public void setAggregatePrice(String aggregatePrice) {
        this.aggregatePrice = aggregatePrice;
    }

    public String getPricesMeter() {
        return pricesMeter;
    }

    public void setPricesMeter(String pricesMeter) {
        this.pricesMeter = pricesMeter;
    }
}
