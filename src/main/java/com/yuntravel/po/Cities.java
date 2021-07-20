package com.yuntravel.po;

public class Cities {

private int cityId;
private String cityName;
private int parentCity;

    public Cities() {
    }

    public Cities(int cityId, String cityName, int parentCity) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.parentCity = parentCity;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getParentCity() {
        return parentCity;
    }

    public void setParentCity(int parentCity) {
        this.parentCity = parentCity;
    }
}
