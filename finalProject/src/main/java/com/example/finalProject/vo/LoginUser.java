package com.example.finalProject.vo;

import java.util.Map;

public interface LoginUser {
    String getId();
    String getPassword();
    String getRole();
    String getEmail();
    Map<String,Object> getAthorities();
}
