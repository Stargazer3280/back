package com.example.demo.controller;

import com.example.demo.config.JsonReading;
import com.example.demo.dao.CommDisasterDao;
import com.example.demo.entity.CommDisaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private CommDisasterDao commDisasterDao;

    @GetMapping("/getData")
    public List<CommDisaster> getData() throws IOException {
        CommDisaster commDisaster = JsonReading.readJsonFromClassPath("static/202/CommDisaster/json.json", CommDisaster.class);
        commDisasterDao.insert(commDisaster);
        return commDisasterDao.getAll();
    }
}
