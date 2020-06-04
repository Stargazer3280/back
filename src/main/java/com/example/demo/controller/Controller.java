package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.service.ExcelReadingService;
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
    private CivilStructureDao civilStructureDao;
    @Autowired
    private CollapseRecordDao collapseRecordDao;
    @Autowired
    private CommDisasterDao commDisasterDao;
    @Autowired
    private DeathStatisticsDao deathStatisticsDao;
    @Autowired
    private DisasterInfoDao disasterInfoDao;
    @Autowired
    private DisasterPredictionDao disasterPredictionDao;
    @Autowired
    private LandslideRecordDao landslideRecordDao;
    @Autowired
    private MasonryStructureDao masonryStructureDao;
    @Autowired
    private MissingStatisticsDao missingStatisticsDao;
    @Autowired
    private TrafficDisasterDao trafficDisasterDao;


    @Autowired
    private ExcelReadingService excelReadingService;
    @Autowired
    private JsonReadingService jsonReadingService;
    @Autowired
    private StatusService statusService;

    @GetMapping("/")
    public String a() {
        System.out.println(excelReadingService.getLocation("451103105000"));
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

    @GetMapping("/information/getAll/disasterInfo")
    public List<DisasterInfo> getAllDisasterInfo() {
        return disasterInfoDao.getAll();
    }

    @GetMapping("/information/getAll/disasterPrediction")
    public List<DisasterPrediction> getAllDisasterPrediction() {
        return disasterPredictionDao.getAll();
    }

    @GetMapping("/information/getAll/landslideRecord")
    public List<LandslideRecord> getAllLandslideRecord() {
        return landslideRecordDao.getAll();
    }

    @GetMapping("/information/getAll/masonryStructure")
    public List<MasonryStructure> getAllMasonryStructure() {
        return masonryStructureDao.getAll();
    }

    @GetMapping("/information/getAll/missingStatistics")
    public List<MissingStatistics> getAllMissingStatistics() {
        return missingStatisticsDao.getAll();
    }

    @GetMapping("/information/getAll/trafficDisaster")
    public List<TrafficDisaster> getAllTrafficDisaster() {
        return trafficDisasterDao.getAll();
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

    @GetMapping("/information/get/disasterInfo")
    public DisasterInfo getDisasterInfo(Integer no) {
        return disasterInfoDao.getByNo(no);
    }

    @GetMapping("/information/get/disasterPrediction")
    public DisasterPrediction getDisasterPrediction(Integer no) {
        return disasterPredictionDao.getByNo(no);
    }

    @GetMapping("/information/get/landslideRecord")
    public LandslideRecord getLandslideRecord(Integer no) {
        return landslideRecordDao.getByNo(no);
    }

    @GetMapping("/information/get/masonryStructure")
    public MasonryStructure getMasonryStructure(Integer no) {
        return masonryStructureDao.getByNo(no);
    }

    @GetMapping("/information/get/missingStatistics")
    public MissingStatistics getMissingStatistics(Integer no) {
        return missingStatisticsDao.getByNo(no);
    }

    @GetMapping("/information/get/trafficDisaster")
    public TrafficDisaster getTrafficDisaster(Integer no) {
        return trafficDisasterDao.getByNo(no);
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
            case "disasterInfo":
                disasterInfoDao.delete(no);
                break;
            case "disasterPrediction":
                disasterPredictionDao.delete(no);
                break;
            case "landslideRecord":
                landslideRecordDao.delete(no);
                break;
            case "masonryStructure":
                masonryStructureDao.delete(no);
                break;
            case "missingStatistics":
                missingStatisticsDao.delete(no);
                break;
            case "trafficDisaster":
                trafficDisasterDao.delete(no);
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

    @PostMapping("/information/insert/disasterInfo")
    public String insertDisasterInfo(@RequestBody(required = false) DisasterInfo disasterInfo) {
        disasterInfoDao.insert(disasterInfo);
        return "添加成功";
    }

    @PostMapping("/information/insert/disasterPrediction")
    public String insertDisasterPrediction(@RequestBody(required = false) DisasterPrediction disasterPrediction) {
        disasterPredictionDao.insert(disasterPrediction);
        return "添加成功";
    }

    @PostMapping("/information/insert/landslideRecord")
    public String insertLandslideRecord(@RequestBody(required = false) LandslideRecord landslideRecord) {
        landslideRecordDao.insert(landslideRecord);
        return "添加成功";
    }

    @PostMapping("/information/insert/masonryStructure")
    public String insertMasonryStructure(@RequestBody(required = false) MasonryStructure masonryStructure) {
        masonryStructureDao.insert(masonryStructure);
        return "添加成功";
    }

    @PostMapping("/information/insert/missingStatistics")
    public String insertMissingStatistics(@RequestBody(required = false) MissingStatistics missingStatistics) {
        missingStatisticsDao.insert(missingStatistics);
        return "添加成功";
    }

    @PostMapping("/information/insert/trafficDisaster")
    public String insertTrafficDisaster(@RequestBody(required = false) TrafficDisaster trafficDisaster) {
        trafficDisasterDao.insert(trafficDisaster);
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

    @PostMapping("/information/update/disasterInfo")
    public String updateDisasterInfo(@RequestBody(required = false) DisasterInfo disasterInfo) {
        disasterInfoDao.update(disasterInfo);
        return "修改成功";
    }

    @PostMapping("/information/update/disasterPrediction")
    public String updateDisasterPrediction(@RequestBody(required = false) DisasterPrediction disasterPrediction) {
        disasterPredictionDao.update(disasterPrediction);
        return "修改成功";
    }

    @PostMapping("/information/update/landslideRecord")
    public String updateLandslideRecord(@RequestBody(required = false) LandslideRecord landslideRecord) {
        landslideRecordDao.update(landslideRecord);
        return "修改成功";
    }

    @PostMapping("/information/update/masonryStructure")
    public String updateMasonryStructure(@RequestBody(required = false) MasonryStructure masonryStructure) {
        masonryStructureDao.update(masonryStructure);
        return "修改成功";
    }

    @PostMapping("/information/update/missingStatistics")
    public String updateMissingStatistics(@RequestBody(required = false) MissingStatistics missingStatistics) {
        missingStatisticsDao.update(missingStatistics);
        return "修改成功";
    }

    @PostMapping("/information/update/trafficDisaster")
    public String updateTrafficDisaster(@RequestBody(required = false) TrafficDisaster trafficDisaster) {
        trafficDisasterDao.update(trafficDisaster);
        return "修改成功";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/upload")//上传json文件
    public String upload(@RequestParam MultipartFile file, String MSCode) throws IOException {
        jsonReadingService.JSONDealer(jsonReadingService.getStreamToStr(file.getInputStream()), MSCode);
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
