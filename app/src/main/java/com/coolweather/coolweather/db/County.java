package com.coolweather.coolweather.db;

import org.litepal.crud.LitePalSupport;

public class County extends LitePalSupport {
    private int id; //实体类id
    private String county;//区县名称
    private int countyCode;//区县代码
    private String weatherId;//区县天气信息
    private int cityId;//区县上级市代码

    public void setId(int id) {
        this.id = id;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setCountyCode(int countyCode) {
        this.countyCode = countyCode;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public String getCounty() {
        return county;
    }

    public int getCountyCode() {
        return countyCode;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public int getCityId() {
        return cityId;
    }
}
