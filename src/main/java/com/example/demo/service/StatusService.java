package com.example.demo.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.StatusDao;
import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusDao statusDao;

    public void updateStatus(String database, int status) {
        switch (database) {
            case "civilStructure":
                statusDao.updateCivilStructure(status);
                break;
            case "collapseRecord":
                statusDao.updateCollapseRecord(status);
                break;
            case "commDisaster":
                statusDao.updateCommDisaster(status);
                break;
            case "deathStatistics":
                statusDao.updateDeathStatistics(status);
                break;
            case "disasterPrediction":
                statusDao.updateDisasterPrediction(status);
                break;
        }
    }

    public int getStatus(String database) {
        int status = 0;
        switch (database) {
            case "civilStructure":
                status = statusDao.selectCivilStructure();
                break;
            case "collapseRecord":
                status = statusDao.selectCollapseRecord();
                break;
            case "commDisaster":
                status = statusDao.selectCommDisaster();
                break;
            case "deathStatistics":
                status = statusDao.selectDeathStatistics();
                break;
            case "disasterPrediction":
                status = statusDao.selectDisasterPrediction();
                break;
        }
        return status;
    }
}
