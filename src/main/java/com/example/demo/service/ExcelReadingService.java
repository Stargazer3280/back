package com.example.demo.service;


import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

@Service
public class ExcelReadingService {
    private HashMap<String, String> map;

    @PostConstruct
    private void init() throws Exception {
        map = new HashMap<>();
        ClassPathResource classPathResource = new ClassPathResource("static/excel.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            map.put(str.split("\t")[0], str.split("\t")[1]);
        }
    }

    public String getLocation(String code) {
        String s1 = map.get(code.substring(0, 2) + "0000000000");//省级
        String s2 = map.get(code.substring(0, 4) + "00000000");//市级
        String s3 = map.get(code.substring(0, 6) + "000000");//县级
        String s4 = map.get(code.substring(0, 9) + "000");//乡镇街道
        String s5 = map.get(code.substring(0, 12));//行政村或社区代码
        return s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5;
    }
}