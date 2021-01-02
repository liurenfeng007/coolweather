package com.coolweather.coolweather.util;

import android.text.TextUtils;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.CityDao;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.CountyDao;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoSession;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.ProvinceDao;
import com.coolweather.coolweather.MainActivity;
import com.coolweather.coolweather.db.City;
import com.coolweather.coolweather.db.County;
import com.coolweather.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {

    // 解析服务器返回的省级JSON格式数据，存到数据库中
    public static boolean handleProvinceResponse(String response) {
        DaoSession daoSession = MainActivity.getDaoSession();
        ProvinceDao provinceDao = daoSession.getProvinceDao();
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    provinceDao.insert(province);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 解析和处理服务器返回的市级数据
    public static boolean handleCityResponse(String response, int provinceId){
        DaoSession daoSession = MainActivity.getDaoSession();
        CityDao cityDao = daoSession.getCityDao();
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    cityDao.insert(city);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    // 解析和处理服务器返回的县级数据
    public static boolean handleCountyResponse(String response, int cityId){
        DaoSession daoSession = MainActivity.getDaoSession();
        CountyDao countyDao = daoSession.getCountyDao();
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCountyCode(countyObject.getInt("id"));
                    county.setCityId(cityId);
                    countyDao.insert(county);
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
