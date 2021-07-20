package com.yuntravel.po;

public class TravelType {

    private int typeId;
    private String typeName;
    private float startSal;
    private float endSal;

    public TravelType() {
    }

    public TravelType(int typeId, String typeName, float startSal, float endSal) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.startSal = startSal;
        this.endSal = endSal;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public float getStartSal() {
        return startSal;
    }

    public void setStartSal(float startSal) {
        this.startSal = startSal;
    }

    public float getEndSal() {
        return endSal;
    }

    public void setEndSal(float endSal) {
        this.endSal = endSal;
    }
}
