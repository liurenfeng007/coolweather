package com.coolweather.coolweather.db;


import org.litepal.exceptions.DataSupportException;

public class City {
    private int id;//实体类id
    private String cityName;//记录城市名称
    private int cityCode;//记录城市代码
    private int provinceId;//记录上级省代码

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
