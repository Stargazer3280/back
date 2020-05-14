package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

@Service
public class JsonReadingService {
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

    public void JSONDealer(MultipartFile file, String MSCode) throws IOException {
        String jsonString = getStreamToStr(file.getInputStream());
        List<HashMap> list = JSON.parseArray(jsonString, HashMap.class);
        for (HashMap json : list) {
            switch (json.get("id").toString().substring(12, 15)) {
                case "111"://死亡DeathStatistics
                    DeathStatistics deathStatistics = JSON.parseObject(new JSONObject(json).toString(), DeathStatistics.class);
                    deathStatistics.setReportingUnit(MSCode + deathStatistics.getReportingUnit());
                    deathStatisticsDao.insert(deathStatistics);
                    break;
                case "221"://土木CivilStructure
                    CivilStructure civilStructure = JSON.parseObject(new JSONObject(json).toString(), CivilStructure.class);
                    civilStructure.setReportingUnit(MSCode + civilStructure.getReportingUnit());
                    civilStructureDao.insert(civilStructure);
                    break;
                case "336"://通信CommDisaster
                    CommDisaster commDisaster = JSON.parseObject(new JSONObject(json).toString(), CommDisaster.class);
                    commDisaster.setReportingUnit(MSCode + commDisaster.getReportingUnit());
                    commDisasterDao.insert(commDisaster);
                    break;
                case "441"://崩塌CollapseRecord
                    CollapseRecord collapseRecord = JSON.parseObject(new JSONObject(json).toString(), CollapseRecord.class);
                    collapseRecord.setReportingUnit(MSCode + collapseRecord.getReportingUnit());
                    collapseRecordDao.insert(collapseRecord);
                    break;
                case "552"://灾情预测DisasterPrediction
                    DisasterPrediction disasterPrediction = JSON.parseObject(new JSONObject(json).toString(), DisasterPrediction.class);
                    disasterPrediction.setReportingUnit(MSCode + disasterPrediction.getReportingUnit());
                    disasterPredictionDao.insert(disasterPrediction);
                    break;
            }
        }
    }

    private String getStreamToStr(InputStream tInputStream) {
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


    //    public static <T> T readJsonFromClassPath(String path, Type type) throws IOException {
//
//        ClassPathResource resource = new ClassPathResource(path);
//        if (resource.exists()) {
//            return JSON.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, type,
//                    // 自动关闭流
//                    Feature.AutoCloseSource,
//                    // 允许注释
//                    Feature.AllowComment,
//                    // 允许单引号
//                    Feature.AllowSingleQuotes,
//                    // 使用 Big decimal
//                    Feature.UseBigDecimal);
//        } else {
//            throw new IOException();
//        }
//    }
    private static <T> T readJsonFromClassPath(InputStream inputStream, Type type) throws IOException {

        return JSON.parseObject(inputStream, StandardCharsets.UTF_8, type,
                // 自动关闭流
                Feature.AutoCloseSource,
                // 允许注释
                Feature.AllowComment,
                // 允许单引号
                Feature.AllowSingleQuotes,
                // 使用 Big decimal
                Feature.UseBigDecimal);
    }
}
