package com.myblog.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

/**
 * Author: 黄一辛 HUANGYIXIN
 * CreateTime: 2018/5/26 17:29
 * Contract: huangyixin@zhuojianchina.com
 * Description:
 **/
public class ResponseUtil {

    public static <T> ResponseEntity<T> createResponseEntity(T body){
        MultiValueMap<String,String> headers = new HttpHeaders();
        headers.set("Content-Type", "application/json; charset=utf-8");
        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }
}
