package com.glassait.equipment_tanks.abstracts.wotApi;

import lombok.Getter;

import java.util.Map;

@Getter
public class Response {
    private String status;
    private Meta meta;
    private Map<String, Object> data;
}
