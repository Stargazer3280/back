package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;
import java.util.List;

@Service
public class JsonReadingService {
    @Autowired
    private DeathStatisticsDao deathStatisticsDao;
    @Autowired
    private MissingStatisticsDao missingStatisticsDao;
    @Autowired
    private CivilStructureDao civilStructureDao;
    @Autowired
    private MasonryStructureDao masonryStructureDao;
    @Autowired
    private TrafficDisasterDao trafficDisasterDao;
    @Autowired
    private CommDisasterDao commDisasterDao;
    @Autowired
    private CollapseRecordDao collapseRecordDao;
    @Autowired
    private LandslideRecordDao landslideRecordDao;
    @Autowired
    private DisasterInfoDao disasterInfoDao;
    @Autowired
    private DisasterPredictionDao disasterPredictionDao;

    @Autowired
    private ExcelReadingService excelReadingService;
    @Autowired
    private StatusService statusService;

    public void JSONDealer(String jsonString, String MSCode) throws IOException {
        List<HashMap> list = JSON.parseArray(jsonString, HashMap.class);
        for (HashMap json : list) {
            switch (json.get("id").toString().substring(12, 15)) {
                case "111"://死亡DeathStatistics
                    DeathStatistics deathStatistics = JSON.parseObject(new JSONObject(json).toString(), DeathStatistics.class);
                    deathStatistics.setReportingUnit(MSCode + deathStatistics.getReportingUnit());
                    deathStatistics.setLocation(excelReadingService.getLocation(deathStatistics.getId()));
                    deathStatisticsDao.insert(deathStatistics);
                    statusService.updateStatus("deathStatistics", 0);
                    break;
                case "113"://失踪MissingStatistics
                    MissingStatistics missingStatistics = JSON.parseObject(new JSONObject(json).toString(), MissingStatistics.class);
                    missingStatistics.setReportingUnit(MSCode + missingStatistics.getReportingUnit());
                    missingStatistics.setLocation(excelReadingService.getLocation(missingStatistics.getId()));
                    missingStatisticsDao.insert(missingStatistics);
                    //statusService.updateStatus("missingStatistics", 0);
                    break;
                case "221"://土木CivilStructure
                    CivilStructure civilStructure = JSON.parseObject(new JSONObject(json).toString(), CivilStructure.class);
                    civilStructure.setReportingUnit(MSCode + civilStructure.getReportingUnit());
                    civilStructure.setLocation(excelReadingService.getLocation(civilStructure.getId()));
                    civilStructureDao.insert(civilStructure);
                    statusService.updateStatus("civilStructure", 0);
                    break;
                case "223"://砖混MasonryStructure
                    MasonryStructure masonryStructure = JSON.parseObject(new JSONObject(json).toString(), MasonryStructure.class);
                    masonryStructure.setReportingUnit(MSCode + masonryStructure.getReportingUnit());
                    masonryStructure.setLocation(excelReadingService.getLocation(masonryStructure.getId()));
                    masonryStructureDao.insert(masonryStructure);
                    //statusService.updateStatus("civilStructure", 0);
                    break;
                case "331"://交通TrafficDisaster
                    TrafficDisaster trafficDisaster = JSON.parseObject(new JSONObject(json).toString(), TrafficDisaster.class);
                    trafficDisaster.setReportingUnit(MSCode + trafficDisaster.getReportingUnit());
                    trafficDisaster.setLocation(excelReadingService.getLocation(trafficDisaster.getId()));
                    trafficDisasterDao.insert(trafficDisaster);
                    //statusService.updateStatus("civilStructure", 0);
                    break;
                case "336"://通信CommDisaster
                    CommDisaster commDisaster = JSON.parseObject(new JSONObject(json).toString(), CommDisaster.class);
                    commDisaster.setReportingUnit(MSCode + commDisaster.getReportingUnit());
                    commDisaster.setLocation(excelReadingService.getLocation(commDisaster.getId()));
                    commDisasterDao.insert(commDisaster);
                    statusService.updateStatus("commDisaster", 0);
                    break;
                case "441"://崩塌CollapseRecord
                    CollapseRecord collapseRecord = JSON.parseObject(new JSONObject(json).toString(), CollapseRecord.class);
                    collapseRecord.setReportingUnit(MSCode + collapseRecord.getReportingUnit());
                    collapseRecord.setLocation(excelReadingService.getLocation(collapseRecord.getId()));
                    collapseRecordDao.insert(collapseRecord);
                    //statusService.updateStatus("commDisaster", 0);
                    break;
                case "442"://滑坡LandslideRecord
                    LandslideRecord landslideRecord = JSON.parseObject(new JSONObject(json).toString(), LandslideRecord.class);
                    landslideRecord.setReportingUnit(MSCode + landslideRecord.getReportingUnit());
                    landslideRecord.setLocation(excelReadingService.getLocation(landslideRecord.getId()));
                    landslideRecordDao.insert(landslideRecord);
                    //statusService.updateStatus("collapseRecord", 0);
                    break;
                case "551"://基本震情DisasterInfo
                    DisasterInfo disasterInfo = JSON.parseObject(new JSONObject(json).toString(), DisasterInfo.class);
                    disasterInfo.setReportingUnit(MSCode + disasterInfo.getReportingUnit());
                    disasterInfo.setLocation(excelReadingService.getLocation(disasterInfo.getId()));
                    disasterInfoDao.insert(disasterInfo);
                    //statusService.updateStatus("disasterPrediction", 0);
                    break;
                case "552"://灾情预测DisasterPrediction
                    DisasterPrediction disasterPrediction = JSON.parseObject(new JSONObject(json).toString(), DisasterPrediction.class);
                    disasterPrediction.setReportingUnit(MSCode + disasterPrediction.getReportingUnit());
                    disasterPrediction.setLocation(excelReadingService.getLocation(disasterPrediction.getId()));
                    disasterPredictionDao.insert(disasterPrediction);
                    statusService.updateStatus("disasterPrediction", 0);
                    break;
            }
        }
    }

    public String getStreamToStr(InputStream tInputStream) {
        if (tInputStream != null) {
            try {
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
                StringBuffer tStringBuffer = new StringBuffer();
                String sTempOneLine;
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    tStringBuffer.append(sTempOneLine);
                }
                return tStringBuffer.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    @PostConstruct
    private void timer() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    //Thread.sleep(1000*60*10);
                    ClassPathResource classPathResource = new ClassPathResource("static/json.json");
                    if (classPathResource.exists()) {//文件存在则读取
                        File file = classPathResource.getFile();
                        FileInputStream f = new FileInputStream(file);
                        JSONDealer(getStreamToStr(f), "201");//自动读取的假设MSCode为201
                        f.close();
                        if (file.delete())//读取完毕后删除文件
                            System.out.println("读取完毕，已删除文件");
                    }
                    System.out.println("1s");
                } catch (InterruptedException | IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        thread.start();
    }
}
