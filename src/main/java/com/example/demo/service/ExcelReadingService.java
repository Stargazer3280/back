package com.example.demo.service;


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
    public void init() throws Exception {
        map = new HashMap<>();
        ClassPathResource classPathResource = new ClassPathResource("static/excel.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            map.put(str.split("\t")[0], str.split("\t")[1]);
        }
    }

    public String get(String key) {
        return map.get(key);
    }
}