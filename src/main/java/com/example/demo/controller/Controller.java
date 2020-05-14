package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.service.JsonReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    private JsonReadingService jsonReadingService;
    @Autowired
    private DeathStatisticsDao deathStatisticsDao;
    @Autowired
    private CivilStructureDao civilStructureDao;
    @Autowired
    private CommDisasterDao commDisasterDao;
    @Autowired
    private CollapseRecordDao collapseRecordDao;
    @Autowired
    private DisasterPredictionDao disasterPredictionDao;

    @GetMapping("/")
    public String a() {
        System.out.println();
        return "hello";
    }

    @GetMapping("/information/getCivilStructure")
    public List<CivilStructure> getCivilStructure() {
        return civilStructureDao.getAll();
    }

    @GetMapping("/information/getCollapseRecord")
    public List<CollapseRecord> getCollapseRecord() {
        return collapseRecordDao.getAll();
    }

    @GetMapping("/information/getCommDisaster")
    public List<CommDisaster> getCommDisaster() {
        return commDisasterDao.getAll();
    }

    @GetMapping("/information/getDeathStatistics")
    public List<DeathStatistics> getDeathStatistics() {
        return deathStatisticsDao.getAll();
    }

    @GetMapping("/information/getDisasterPrediction")
    public List<DisasterPrediction> getDisasterPrediction() {
        return disasterPredictionDao.getAll();
    }

    @PostMapping("/upload")//上传json文件
    public String upload(@RequestParam MultipartFile file, String MSCode) throws IOException {
        jsonReadingService.JSONDealer(file, MSCode);
        return "上传文件成功";
    }
}
