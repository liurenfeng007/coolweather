package com.coolweather.coolweather.db;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class County {
    @Id
    private int id; //实体类id
    private String countyName;//区县名称
    private int countyCode;//区县代码
    private String weatherId;//区县天气信息
    private int cityId;//区县上级市代码

    @Generated(hash = 1261057773)
    public County(int id, String countyName, int countyCode, String weatherId,
                  int cityId) {
        this.id = id;
        this.countyName = countyName;
        this.countyCode = countyCode;
        this.weatherId = weatherId;
        this.cityId = cityId;
    }

    @Generated(hash = 1991272252)
    public County() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return this.countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getCountyCode() {
        return this.countyCode;
    }

    public void setCountyCode(int countyCode) {
        this.countyCode = countyCode;
    }

    public String getWeatherId() {
        return this.weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}
