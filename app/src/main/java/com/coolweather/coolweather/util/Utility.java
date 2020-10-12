package com.coolweather.coolweather.util;

import android.text.TextUtils;

import com.coolweather.coolweather.db.City;
import com.coolweather.coolweather.db.County;
import com.coolweather.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    //解析服务器返回的省级JSON格式数据，存到数据库中
    public static boolean handledProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvinces =new JSONArray(response);
                for (int i = 0; i < allProvinces.length(); i++) {
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //解析服务器返回的城市JSON格式数据，存到数据库中
    public static boolean handleCityResponse(String response,int provinceId){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties=new JSONArray(response);
                for (int i = 0; i <allCounties.length() ; i++) {
                    JSONObject cityObject =allCounties.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean handleCountyResponse(String response,int cityId){
        if(TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
