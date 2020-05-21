package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.service.JsonReadingService;
import com.example.demo.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private StatusService statusService;

    @GetMapping("/")
    public String a() {
        return "hello";
    }

    @GetMapping("/information/getAll/civilStructure")
    public List<CivilStructure> getAllCivilStructure() {
        return civilStructureDao.getAll();
    }

    @GetMapping("/information/getAll/collapseRecord")
    public List<CollapseRecord> getAllCollapseRecord() {
        return collapseRecordDao.getAll();
    }

    @GetMapping("/information/getAll/commDisaster")
    public List<CommDisaster> getAllCommDisaster() {
        return commDisasterDao.getAll();
    }

    @GetMapping("/information/getAll/deathStatistics")
    public List<DeathStatistics> getAllDeathStatistics() {
        return deathStatisticsDao.getAll();
    }

    @GetMapping("/information/getAll/disasterPrediction")
    public List<DisasterPrediction> getAllDisasterPrediction() {
        return disasterPredictionDao.getAll();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/information/get/civilStructure")
    public CivilStructure getCivilStructure(Integer no) {
        return civilStructureDao.getByNo(no);
    }

    @GetMapping("/information/get/collapseRecord")
    public CollapseRecord getCollapseRecord(Integer no) {
        return collapseRecordDao.getByNo(no);
    }

    @GetMapping("/information/get/commDisaster")
    public CommDisaster getCommDisaster(Integer no) {
        return commDisasterDao.getByNo(no);
    }

    @GetMapping("/information/get/deathStatistics")
    public DeathStatistics getDeathStatistics(Integer no) {
        return deathStatisticsDao.getByNo(no);
    }

    @GetMapping("/information/get/disasterPrediction")
    public DisasterPrediction getDisasterPrediction(Integer no) {
        return disasterPredictionDao.getByNo(no);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/information/delete")
    public String deleteCivilStructure(String database, Integer no) {
        switch (database) {
            case "civilStructure":
                civilStructureDao.delete(no);
                break;
            case "collapseRecord":
                collapseRecordDao.delete(no);
                break;
            case "commDisaster":
                commDisasterDao.delete(no);
                break;
            case "deathStatistics":
                deathStatisticsDao.delete(no);
                break;
            case "disasterPrediction":
                disasterPredictionDao.delete(no);
                break;
        }
        return "删除成功";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/information/insert/civilStructure")
    public String insertCivilStructure(@RequestBody(required = false) CivilStructure civilStructure) {
        civilStructureDao.insert(civilStructure);
        return "添加成功";
    }

    @PostMapping("/information/insert/collapseRecord")
    public String insertCollapseRecord(@RequestBody(required = false) CollapseRecord collapseRecord) {
        collapseRecordDao.insert(collapseRecord);
        return "添加成功";
    }

    @PostMapping("/information/insert/commDisaster")
    public String insertCommDisaster(@RequestBody(required = false) CommDisaster commDisaster) {
        commDisasterDao.insert(commDisaster);
        return "添加成功";
    }

    @PostMapping("/information/insert/deathStatistics")
    public String insertDeathStatistics(@RequestBody(required = false) DeathStatistics deathStatistics) {
        deathStatisticsDao.insert(deathStatistics);
        return "添加成功";
    }

    @PostMapping("/information/insert/disasterPrediction")
    public String insertDisasterPrediction(@RequestBody(required = false) DisasterPrediction disasterPrediction) {
        disasterPredictionDao.insert(disasterPrediction);
        return "添加成功";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/information/update/civilStructure")
    public String updateCivilStructure(@RequestBody(required = false) CivilStructure civilStructure) {
        civilStructureDao.update(civilStructure);
        return "修改成功";
    }

    @PostMapping("/information/update/collapseRecord")
    public String updateCollapseRecord(@RequestBody(required = false) CollapseRecord collapseRecord) {
        collapseRecordDao.update(collapseRecord);
        return "修改成功";
    }

    @PostMapping("/information/update/commDisaster")
    public String updateCommDisaster(@RequestBody(required = false) CommDisaster commDisaster) {
        commDisasterDao.update(commDisaster);
        return "修改成功";
    }

    @PostMapping("/information/update/deathStatistics")
    public String updateDeathStatistics(@RequestBody(required = false) DeathStatistics deathStatistics) {
        deathStatisticsDao.update(deathStatistics);
        return "修改成功";
    }

    @PostMapping("/information/update/disasterPrediction")
    public String updateDisasterPrediction(@RequestBody(required = false) DisasterPrediction disasterPrediction) {
        disasterPredictionDao.update(disasterPrediction);
        return "修改成功";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/upload")//上传json文件
    public String upload(@RequestParam MultipartFile file, String MSCode) throws IOException {
        jsonReadingService.JSONDealer(file, MSCode);
        return "上传文件成功";
    }

    @GetMapping("/jsonRead")//用户阅读新的变化的json，并且将status置1
    public String jsonRead(@RequestParam String database) {
        statusService.updateStatus(database, 1);
        return "已阅读";
    }

    @GetMapping("/getStatus")//获取status的数值，以判断是否有新消息要阅读
    public boolean getStatus(@RequestParam String database) {
        int status = statusService.getStatus(database);
        if (status == 0)
            return true;
        else return false;
    }
}
