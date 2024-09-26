package com.example.finalProject.vo;

import java.util.Map;

public class NaverVO implements LoginUser{
    private Map<String,Object> map;

    public NaverVO(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String getId() {
        return map.get("id").toString();
    }

    @Override
    public String getPassword() {
        return "123456";
    }

    @Override
    public String getRole() {
        return "USER";
    }
    public String getEmail(){
        return map.get("email").toString();
    }
    @Override
    public Map<String, Object> getAthorities() {
        return map;
    }
}
