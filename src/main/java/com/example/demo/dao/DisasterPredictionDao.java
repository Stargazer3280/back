package com.example.demo.dao;

import com.example.demo.entity.DisasterPrediction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DisasterPredictionDao {
    @Select("select * from disaster_prediction")
    List<DisasterPrediction> getAll();

    @Insert("insert into disaster_prediction(id,date,location,longitude,latitude,depth,magnitude,intensity,type,picture,note,reporting_unit) values(#{id},#{date},#{location},#{longitude},#{latitude},#{depth},#{magnitude},#{intensity},#{type},#{picture},#{note},#{reportingUnit})")
    void insert(DisasterPrediction disasterPrediction);
}
